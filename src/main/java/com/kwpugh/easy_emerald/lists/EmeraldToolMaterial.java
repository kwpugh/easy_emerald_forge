package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.config.GeneralModConfig;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public class EmeraldToolMaterial implements IItemTier
{
	private int emeraldDurability = GeneralModConfig.EMERALD_TOOL_DURABILITY.get(); 
	private double emeraldEfficiency = GeneralModConfig.EMERALD_TOOL_EFFICIENCY.get();
	private double emeraldAttack = GeneralModConfig.EMERALD_TOOL_ATTACK.get();
	private int emeraldMiningLevel = GeneralModConfig.EMERALD_TOOL_MINING_LEVEL.get();
	private int emeraldEnchantability = GeneralModConfig.EMERALD_TOOL_ENCHANTABILITY.get();
    
	@Override
	public int getMaxUses()
	{
		return emeraldDurability;
	}

	@Override
	public float getEfficiency()
	{
		return (float) emeraldEfficiency;
	}

	@Override
	public float getAttackDamage()
	{
		return (float) emeraldAttack;
	}

	@Override
	public int getHarvestLevel()
	{
		return emeraldMiningLevel;
	}

	@Override
	public int getEnchantability()
	{
		return emeraldEnchantability;
	}

	@Override
	public Ingredient getRepairMaterial()
	{
		return Ingredient.fromItems(Items.EMERALD);
	}
}
