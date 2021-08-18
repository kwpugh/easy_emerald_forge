package com.kwpugh.easy_emerald.items.tools.base;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/*
 * Adapted from several sources
 * 
 * Credits to original authors:
 * 
 * - astradamus
 * - neurodr0me
 * - DoubleDoorDev
 * - and few others I don't remember
 * 
 * 
 */

public class TreeAxeBase extends AxeItem
{   
    public static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.ACACIA_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.BOOKSHELF, Blocks.OAK_WOOD, Blocks.SPRUCE_WOOD, Blocks.BIRCH_WOOD, Blocks.JUNGLE_WOOD, Blocks.ACACIA_WOOD, Blocks.DARK_OAK_WOOD, Blocks.OAK_LOG, Blocks.SPRUCE_LOG, Blocks.BIRCH_LOG, Blocks.JUNGLE_LOG, Blocks.ACACIA_LOG, Blocks.DARK_OAK_LOG, Blocks.CHEST, Blocks.PUMPKIN, Blocks.CARVED_PUMPKIN, Blocks.JACK_O_LANTERN, Blocks.MELON, Blocks.LADDER, Blocks.SCAFFOLDING, Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON, Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.ACACIA_BUTTON, Blocks.OAK_PRESSURE_PLATE, Blocks.SPRUCE_PRESSURE_PLATE, Blocks.BIRCH_PRESSURE_PLATE, Blocks.JUNGLE_PRESSURE_PLATE, Blocks.DARK_OAK_PRESSURE_PLATE, Blocks.ACACIA_PRESSURE_PLATE);

    public static final Set<Material> EFFECTIVE_MATERIALS = ImmutableSet.of(Material.WOOD, Material.VEGETABLE, Material.CACTUS);

    public static final int LOG_BREAK_DELAY = 1;

    public TreeAxeBase(Tier tier, float attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entityLiving)
    {
        stack.hurt(3, random, null);

        if (entityLiving instanceof Player)
        {
            Player player = (Player) entityLiving;

            if (!attemptFellTree(world, pos, player))
            {
                attemptBreakNeighbors(world, pos, player, EFFECTIVE_ON, EFFECTIVE_MATERIALS, false);
            }
        }

        return super.mineBlock(stack, world, state, pos, entityLiving);
    }

    private boolean attemptFellTree(Level world, BlockPos pos, Player player)
    {

        ArrayList<BlockPos> logs = new ArrayList<>();
        ArrayList<BlockPos> candidates = new ArrayList<>();
        candidates.add(pos);

        int leaves = 0;

        // Find all connected logs and count all connected leaves
        for (int i = 0; i < candidates.size(); i++)
        {
            if (logs.size() > 200) return false; // Whatever this is, it's too big! I don't want to know what happens if I let you use this in an all-log RFTDim.

            BlockPos candidate = candidates.get(i);
            Block block = world.getBlockState(candidate).getBlock();

            if (BlockTags.LEAVES.contains(block))
            {
                leaves++;
            }
            else if (logs.size() == 0 || BlockTags.LOGS.contains(block))
            {
                logs.add(candidate);

                // We found a log, check for neighboring logs
                for (int x = -1; x <= 1; x++)
                {
                    for (int y = 0; y <= 1; y++)
                    { // No good reason to check downwards, cuts 1/3 off this loop
                        for (int z = -1; z <= 1; z++)
                        {
                            BlockPos neighbor = candidate.offset(x, y, z);
                            if (candidates.contains(neighbor)) continue; // Don't check positions twice
                            candidates.add(neighbor);
                        }
                    }
                }
            }
        }

        if (logs.size() == 0) return false; // No logs? No tree.

        if (leaves >= logs.size()/6.0)
        { // Trees have leaves. Since we only count leaves adjacent to logs, we favor leaves a bit.

            // Break the tree. Spread across several ticks because doing all at once causes the game to stutter, even for small trees.
            MinecraftForge.EVENT_BUS.register(new Object()
            {
                int fortuneLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, player.getMainHandItem());
                int silkLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, player.getMainHandItem());

                int delay = LOG_BREAK_DELAY;
                int i = 0;

                @SubscribeEvent
                public void onTick(TickEvent.WorldTickEvent event)
                {
                    if (delay-- > 0) return;
                    delay = LOG_BREAK_DELAY;
                    if (i < logs.size()) {
                        BlockPos log = logs.get(i);
                        attemptBreak(world, log, player, EFFECTIVE_ON, EFFECTIVE_MATERIALS, fortuneLevel, silkLevel, false);
                        i++;
                    }
                    else
                    {
                        MinecraftForge.EVENT_BUS.unregister(this);
                    }
                }
            });

            return true;
        }

        return false;
    }
    

    public static final Random random = new Random();

    public static void attemptBreakNeighbors(Level world, BlockPos pos, Player player, Set<Block> effectiveOn, Set<Material> effectiveMaterials, boolean checkHarvestLevel)
    {
        world.setBlockAndUpdate(pos, Blocks.GLASS.defaultBlockState());
        HitResult trace = calcRayTrace(world, player, ClipContext.Fluid.ANY);
        world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());

        if (trace.getType() == HitResult.Type.BLOCK)
        {
            BlockHitResult blockTrace = (BlockHitResult) trace;
            Direction face = blockTrace.getDirection();

            int fortuneLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, player.getMainHandItem());
            int silkLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, player.getMainHandItem());

            for (int a = -1; a <= 1; a++)
            {
                for (int b = -1; b <= 1; b++)
                {
                    if (a == 0 && b == 0) continue;

                    BlockPos target = null;

                    if (face == Direction.UP    || face == Direction.DOWN)  target = pos.offset(a, 0, b);
                    if (face == Direction.NORTH || face == Direction.SOUTH) target = pos.offset(a, b, 0);
                    if (face == Direction.EAST  || face == Direction.WEST)  target = pos.offset(0, a, b);

                    attemptBreak(world, target, player, effectiveOn, effectiveMaterials, fortuneLevel, silkLevel, checkHarvestLevel);
                }
            }
        }
    }

    public static void attemptBreak(Level world, BlockPos pos, Player player, Set<Block> effectiveOn, Set<Material> effectiveMaterials, int fortuneLevel, int silkLevel, boolean checkHarvestLevel)
    {
        BlockState state = world.getBlockState(pos);

        boolean validHarvest = !checkHarvestLevel || player.getMainHandItem().isCorrectToolForDrops(state);
        boolean isEffective = effectiveOn.contains(state.getBlock()) || effectiveMaterials.contains(state.getMaterial());
        boolean witherImmune = BlockTags.WITHER_IMMUNE.contains(state.getBlock());

        if (validHarvest && isEffective && !witherImmune)
        {
            world.destroyBlock(pos, false);
            Block.dropResources(state, world, pos, null, player, player.getMainHandItem());

            int exp = state.getExpDrop(world, pos, fortuneLevel, silkLevel);
            if (exp > 0)
            {
                state.getBlock().popExperience((ServerLevel) world, pos, exp);
            }
        }
    }

    public static HitResult calcRayTrace(Level worldIn, Player player, ClipContext.Fluid fluidMode)
    {
        float f = player.xRotO;
        float f1 = player.yRotO;
        Vec3 vec3d = player.getEyePosition(1.0F);
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = player.getAttribute(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).getValue();
        Vec3 vec3d1 = vec3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return worldIn.clip(new ClipContext(vec3d, vec3d1, ClipContext.Block.OUTLINE, fluidMode, player));
    }
} 