package com.kwpugh.easy_emerald.tools;

import com.kwpugh.easy_emerald.tools.base.ExcavatorBase;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class EmeraldExcavator extends ExcavatorBase
{
	public EmeraldExcavator(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
    
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == Items.EMERALD;
	}
}