package com.kwpugh.easy_emerald.tools;

import com.kwpugh.easy_emerald.init.ItemInit;
import com.kwpugh.easy_emerald.tools.base.HammerBase;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class RubyHammer extends HammerBase
{
	public RubyHammer(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemInit.RUBY.get();
	}
}