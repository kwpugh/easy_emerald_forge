package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class RubyToolMaterial implements IItemTier
{
	private int rubyDurability = GeneralModConfig.RUBY_TOOL_DURABILITY.get();
	private double rubyEfficiency = GeneralModConfig.RUBY_TOOL_EFFICIENCY.get();
	private double rubyAttack = GeneralModConfig.RUBY_TOOL_ATTACK.get();
	private int rubyMiningLevel = GeneralModConfig.RUBY_TOOL_MINING_LEVEL.get();
	private int rubyEnchantability = GeneralModConfig.RUBY_TOOL_ENCHANTABILITY.get();
	
	@Override
	public int getMaxUses()
	{
		return rubyDurability;
	}

	@Override
	public float getEfficiency()
	{
		return (float) rubyEfficiency;
	}

	@Override
	public float getAttackDamage()
	{
		return (float) rubyAttack;
	}

	@Override
	public int getHarvestLevel()
	{
		return rubyMiningLevel;
	}

	@Override
	public int getEnchantability()
	{
		return rubyEnchantability;
	}

	@Override
	public Ingredient getRepairMaterial()
	{
		return Ingredient.fromItems(ItemInit.RUBY.get());
	}

}