package com.kwpugh.easy_emerald.tools;

import com.kwpugh.easy_emerald.tools.base.HammerBase;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class EmeraldHammer extends HammerBase
{
	public EmeraldHammer(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == Items.EMERALD;
	}
}