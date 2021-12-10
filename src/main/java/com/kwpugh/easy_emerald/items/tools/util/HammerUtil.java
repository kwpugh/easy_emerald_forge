package com.kwpugh.easy_emerald.items.tools.util;

import java.util.Random;
import java.util.Set;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.entity.player.Player;
import net.minecraft.tags.BlockTags;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

public class HammerUtil
{
    public static final Random random = new Random();

    public static void attemptBreakNeighbors(Level world, BlockPos pos, Player player, Set<Material> effectiveMaterials)
    {    	
    	HitResult trace = calcRayTrace(world, player, ClipContext.Fluid.ANY);

        if (trace.getType() == HitResult.Type.BLOCK)
        {
            BlockHitResult blockTrace = (BlockHitResult) trace;
            Direction face = blockTrace.getDirection();

            for (int a = -1; a <= 1; a++)
            {
                for (int b = -1; b <= 1; b++)
                {
                    if (a == 0 && b == 0) continue;

                    BlockPos target = null;

                    if (face == Direction.UP    || face == Direction.DOWN)  target = pos.offset(a, 0, b);
                    if (face == Direction.NORTH || face == Direction.SOUTH) target = pos.offset(a, b, 0);
                    if (face == Direction.EAST  || face == Direction.WEST)  target = pos.offset(0, a, b);

                    attemptBreak(world, target, player, effectiveMaterials);
                }
            }
        }
    }

    public static void attemptBreak(Level world, BlockPos pos, Player player, Set<Material> effectiveMaterials)
    {
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        boolean isWithinHarvestLevel = player.getMainHandItem().isCorrectToolForDrops(state);  //added to ensure each block in the breaking is harvestable with this tool material
        boolean isHarvestable = block.canHarvestBlock(state, world, pos, player);  // added in case a block overrides canHarvestBlock to false at block level
        boolean isEffective = effectiveMaterials.contains(state.getMaterial());
        boolean witherImmune = BlockTags.WITHER_IMMUNE.contains(state.getBlock());

        if(isEffective && !witherImmune && isWithinHarvestLevel & isHarvestable)
        {
            if(!state.hasBlockEntity())
            {
                world.destroyBlock(pos, false);  //true or false?
                Block.dropResources(state, world, pos, null, player, player.getMainHandItem());
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
        double d0 = player.getAttribute(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).getValue() + 1;;
        Vec3 vec3d1 = vec3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return worldIn.clip(new ClipContext(vec3d, vec3d1, ClipContext.Block.OUTLINE, fluidMode, player));
    }
}