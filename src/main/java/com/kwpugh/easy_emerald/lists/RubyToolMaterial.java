package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.init.ItemInit;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class RubyToolMaterial implements Tier
{
	private int rubyDurability = GeneralModConfig.RUBY_TOOL_DURABILITY.get();
	private double rubyEfficiency = GeneralModConfig.RUBY_TOOL_EFFICIENCY.get();
	private double rubyAttack = GeneralModConfig.RUBY_TOOL_ATTACK.get();
	private int rubyMiningLevel = GeneralModConfig.RUBY_TOOL_MINING_LEVEL.get();
	private int rubyEnchantability = GeneralModConfig.RUBY_TOOL_ENCHANTABILITY.get();
	
	@Override
	public int getUses()
	{
		return rubyDurability;
	}

	@Override
	public float getSpeed()
	{
		return (float) rubyEfficiency;
	}

	@Override
	public float getAttackDamageBonus()
	{
		return (float) rubyAttack;
	}

	@Override
	public int getLevel()
	{
		return rubyMiningLevel;
	}

	@Override
	public int getEnchantmentValue()
	{
		return rubyEnchantability;
	}

	@Override
	public Ingredient getRepairIngredient()
	{
		return Ingredient.of(ItemInit.RUBY.get());
	}

}