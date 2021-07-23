package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.config.GeneralModConfig;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class EmeraldToolMaterial implements Tier
{
	private int emeraldDurability = GeneralModConfig.EMERALD_TOOL_DURABILITY.get(); 
	private double emeraldEfficiency = GeneralModConfig.EMERALD_TOOL_EFFICIENCY.get();
	private double emeraldAttack = GeneralModConfig.EMERALD_TOOL_ATTACK.get();
	private int emeraldMiningLevel = GeneralModConfig.EMERALD_TOOL_MINING_LEVEL.get();
	private int emeraldEnchantability = GeneralModConfig.EMERALD_TOOL_ENCHANTABILITY.get();
    
	@Override
	public int getUses()
	{
		return emeraldDurability;
	}

	@Override
	public float getSpeed()
	{
		return 5.5f;
	}

	@Override
	public float getAttackDamageBonus()
	{
		return (float) emeraldAttack;
	}

	@Override
	public int getLevel()
	{
		return emeraldMiningLevel;
	}

	@Override
	public int getEnchantmentValue()
	{
		return emeraldEnchantability;
	}

	@Override
	public Ingredient getRepairIngredient()
	{
		return Ingredient.of(Items.EMERALD);
	}
}
