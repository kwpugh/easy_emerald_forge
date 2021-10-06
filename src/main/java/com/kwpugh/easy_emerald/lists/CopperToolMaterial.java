package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.config.GeneralModConfig;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class CopperToolMaterial implements Tier
{
    private int copperDurability = GeneralModConfig.COPPER_TOOL_DURABILITY.get();
    private double copperEfficiency = GeneralModConfig.COPPER_TOOL_EFFICIENCY.get();
    private double copperAttack = GeneralModConfig.COPPER_TOOL_ATTACK.get();
    private int copperMiningLevel = GeneralModConfig.COPPER_TOOL_MINING_LEVEL.get();
    private int copperEnchantability = GeneralModConfig.COPPER_TOOL_ENCHANTABILITY.get();

    @Override
    public int getUses()
    {
        return copperDurability;
    }

    @Override
    public float getSpeed()
    {
        return (float) copperEfficiency;
    }

    @Override
    public float getAttackDamageBonus()
    {
        return (float) copperAttack;
    }

    @Override
    public int getLevel()
    {
        return copperMiningLevel;
    }

    @Override
    public int getEnchantmentValue()
    {
        return copperEnchantability;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(Items.COPPER_INGOT);
    }

}