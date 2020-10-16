package com.kwpugh.easy_emerald.tools;

import java.util.Set;

import com.kwpugh.easy_emerald.init.ItemInit;
import com.kwpugh.easy_emerald.tools.base.PaxelBase;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class RubyPaxel extends PaxelBase
{	
	public RubyPaxel(float attackDamageIn, float attackSpeedIn, IItemTier tier, Set<Block> effectiveBlocksIn,
			Properties builder)
	{
		super(attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder);	
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemInit.RUBY.get();
	}
}