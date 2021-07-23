package com.kwpugh.easy_emerald.tools;

import java.util.Set;

import com.kwpugh.easy_emerald.tools.base.PaxelBase;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import net.minecraft.world.item.Item.Properties;

public class EmeraldPaxel extends PaxelBase
{	
	public EmeraldPaxel(float attackDamageIn, float attackSpeedIn, Tier tier, Set<Block> effectiveBlocksIn,
			Properties builder)
	{
		super(attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder);	
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == Items.EMERALD;
	}
}