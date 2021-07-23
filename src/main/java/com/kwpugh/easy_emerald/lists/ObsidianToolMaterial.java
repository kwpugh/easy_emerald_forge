package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.config.GeneralModConfig;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class ObsidianToolMaterial implements Tier
{
	private int obsidianDurability = GeneralModConfig.OBSIDIAN_TOOL_DURABILITY.get(); 
	private double obsidianEfficiency = GeneralModConfig.OBSIDIAN_TOOL_EFFICIENCY.get();
	private double obsidianAttack = GeneralModConfig.OBSIDIAN_TOOL_ATTACK.get();
	private int obsidianMiningLevel = GeneralModConfig.OBSIDIAN_TOOL_MINING_LEVEL.get();
	private int obsidianEnchantability = GeneralModConfig.OBSIDIAN_TOOL_ENCHANTABILITY.get();
	
	@Override
	public int getUses()
	{
		return obsidianDurability;
	}

	@Override
	public float getSpeed()
	{
		return 5.5f;
	}

	@Override
	public float getAttackDamageBonus()
	{
		return (float) obsidianAttack;
	}

	@Override
	public int getLevel()
	{
		return obsidianMiningLevel;
	}

	@Override
	public int getEnchantmentValue()
	{
		return obsidianEnchantability;
	}

	@Override
	public Ingredient getRepairIngredient()
	{
		return Ingredient.of(Items.OBSIDIAN);
	}
}