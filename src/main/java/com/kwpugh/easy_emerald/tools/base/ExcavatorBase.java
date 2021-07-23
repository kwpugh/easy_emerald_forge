package com.kwpugh.easy_emerald.tools.base;

import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.kwpugh.easy_emerald.tools.util.ExcavatorUtil;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

/*
 * This is the base class for all types of Excavators
 * 
 */

public class ExcavatorBase extends ShovelItem
{
	Random random = new Random();

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.GRASS_BLOCK, 
			Blocks.DIRT_PATH,
			Blocks.DIRT, 
			Blocks.COARSE_DIRT, 
			Blocks.RED_SAND, 
			Blocks.SAND, 
			Blocks.PODZOL, 
			Blocks.GRAVEL, 
			Blocks.SOUL_SAND, 
			Blocks.CLAY);
	
	public static final Set<Material> EFFECTIVE_MATERIALS = ImmutableSet.of(Material.DIRT);

	public ExcavatorBase(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity)
    {
        stack.hurt(1, random, null);

        if (entity instanceof Player)
        {
        	ExcavatorUtil.attemptBreakNeighbors(world, pos, (Player) entity, EFFECTIVE_ON, EFFECTIVE_MATERIALS);
        }
        return super.mineBlock(stack, world, state, pos, entity);
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
		tooltip.add((new TranslatableComponent("item.easy_emerald.excavator.tip1").withStyle(ChatFormatting.GREEN)));
	}
}
