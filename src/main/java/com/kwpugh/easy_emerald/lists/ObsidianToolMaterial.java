package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.config.GeneralModConfig;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public class ObsidianToolMaterial implements IItemTier
{
	private int obsidianDurability = GeneralModConfig.OBSIDIAN_TOOL_DURABILITY.get(); 
	private double obsidianEfficiency = GeneralModConfig.OBSIDIAN_TOOL_EFFICIENCY.get();
	private double obsidianAttack = GeneralModConfig.OBSIDIAN_TOOL_ATTACK.get();
	private int obsidianMiningLevel = GeneralModConfig.OBSIDIAN_TOOL_MINING_LEVEL.get();
	private int obsidianEnchantability = GeneralModConfig.OBSIDIAN_TOOL_ENCHANTABILITY.get();
	
	@Override
	public int getMaxUses()
	{
		return obsidianDurability;
	}

	@Override
	public float getEfficiency()
	{
		return (float) obsidianEfficiency;
	}

	@Override
	public float getAttackDamage()
	{
		return (float) obsidianAttack;
	}

	@Override
	public int getHarvestLevel()
	{
		return obsidianMiningLevel;
	}

	@Override
	public int getEnchantability()
	{
		return obsidianEnchantability;
	}

	@Override
	public Ingredient getRepairMaterial()
	{
		return Ingredient.fromItems(Items.OBSIDIAN);
	}
}