package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.init.ItemInit;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class AmethystToolMaterial implements Tier
{
    private int amethystDurability = GeneralModConfig.AMETHYST_TOOL_DURABILITY.get();
    private double amethystEfficiency = GeneralModConfig.AMETHYST_TOOL_EFFICIENCY.get();
    private double amethystAttack = GeneralModConfig.AMETHYST_TOOL_ATTACK.get();
    private int amethystMiningLevel = GeneralModConfig.AMETHYST_TOOL_MINING_LEVEL.get();
    private int amethystEnchantability = GeneralModConfig.AMETHYST_TOOL_ENCHANTABILITY.get();

    @Override
    public int getUses()
    {
        return amethystDurability;
    }

    @Override
    public float getSpeed()
    {
        return (float) amethystEfficiency;
    }

    @Override
    public float getAttackDamageBonus()
    {
        return (float) amethystAttack;
    }

    @Override
    public int getLevel()
    {
        return amethystMiningLevel;
    }

    @Override
    public int getEnchantmentValue()
    {
        return amethystEnchantability;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(Items.AMETHYST_SHARD);
    }

}