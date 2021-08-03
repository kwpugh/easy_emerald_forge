package com.kwpugh.easy_emerald.tools.base;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;

import com.kwpugh.easy_emerald.init.TagInit;

import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants.WorldEvents;

/*
 * This is the base class for all types of Paxels
 * 
 */
public class PaxelBase extends DiggerItem
{
	public static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new Builder<Block, Block>()).put(Blocks.OAK_WOOD, 
			Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, 
			Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, 
			Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, 
			Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, 
			Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, 
			Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, 
			Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, 
			Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, 
			Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, 
			Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, 
			Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, 
			Blocks.STRIPPED_SPRUCE_LOG).build();
	
	public static final Map<Block, BlockState> SHOVEL_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK,
			Blocks.DIRT_PATH.defaultBlockState()));

	public PaxelBase(float attackDamageIn, float attackSpeedIn, Tier tier, Tag<Block> mineabl,
					 Properties builder)
	{
		super(attackDamageIn, attackSpeedIn, tier, TagInit.PAXEL_MINEABLE,
				builder.addToolType(net.minecraftforge.common.ToolType.AXE, tier.getLevel())
				.addToolType(net.minecraftforge.common.ToolType.PICKAXE, tier.getLevel())
				.addToolType(net.minecraftforge.common.ToolType.SHOVEL, tier.getLevel()));
	}

	public boolean isCorrectToolForDrops(BlockState blockIn) {
		int i = this.getTier().getLevel();
		return i >= blockIn.getHarvestLevel();
	}

	public float getDestroySpeed(ItemStack stack, BlockState state) {
		Material material = state.getMaterial();
		return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE
				&& material != Material.WOOD && material != Material.PLANT ? super.getDestroySpeed(stack, state)
						: this.speed;
	}
	   
    @Nonnull
    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState blockstate = world.getBlockState(blockpos);
        BlockState resultToSet = null;
        Block strippedResult = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
        
        if (strippedResult != null)
        {
            world.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            resultToSet = strippedResult.defaultBlockState().setValue(RotatedPillarBlock.AXIS, blockstate.getValue(RotatedPillarBlock.AXIS));
        }
        else
        {
            if (context.getClickedFace() == Direction.DOWN)
            {
                return InteractionResult.PASS;
            }
            
            BlockState foundResult = SHOVEL_LOOKUP.get(blockstate.getBlock());
            
            if (foundResult != null && world.isEmptyBlock(blockpos.above()))
            {
                world.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultToSet = foundResult;
            }
            else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT))
            {
                world.levelEvent(null, WorldEvents.FIRE_EXTINGUISH_SOUND, blockpos, 0);
                resultToSet = blockstate.setValue(CampfireBlock.LIT, false);
            }
        }
        if (resultToSet == null)
        {
            return InteractionResult.PASS;
        }
        if (!world.isClientSide)
        {
            world.setBlock(blockpos, resultToSet, 11);
            
            if (player != null)
            {
                context.getItemInHand().hurtAndBreak(1, player, onBroken -> onBroken.broadcastBreakEvent(context.getHand()));
            }
        }
        
        return InteractionResult.SUCCESS;
    }
    
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add((new TranslatableComponent("item.easy_emerald.paxel.tip1").withStyle(ChatFormatting.GREEN)));
	}
}