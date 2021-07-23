package com.kwpugh.easy_emerald.tools;

import com.kwpugh.easy_emerald.init.ItemInit;
import com.kwpugh.easy_emerald.tools.base.ExcavatorBase;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.Item.Properties;

public class RubyExcavator extends ExcavatorBase
{
	public RubyExcavator(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
    
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemInit.RUBY.get();
	}
}