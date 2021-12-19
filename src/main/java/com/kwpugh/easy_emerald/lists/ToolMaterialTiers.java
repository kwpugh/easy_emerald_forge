package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.init.ItemInit;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ToolMaterialTiers
{
    private static int copperDurability = GeneralModConfig.COPPER_TOOL_DURABILITY.get();
    private static double copperEfficiency = GeneralModConfig.COPPER_TOOL_EFFICIENCY.get();
    private static double copperAttack = GeneralModConfig.COPPER_TOOL_ATTACK.get();
    private static int copperMiningLevel = 2;
    private static int copperEnchantability = GeneralModConfig.COPPER_TOOL_ENCHANTABILITY.get();

    private static int obsidianDurability = GeneralModConfig.OBSIDIAN_TOOL_DURABILITY.get();
    private static double obsidianEfficiency = GeneralModConfig.OBSIDIAN_TOOL_EFFICIENCY.get();
    private static double obsidianAttack = GeneralModConfig.OBSIDIAN_TOOL_ATTACK.get();
    private static int obsidianMiningLevel = 2;
    private static int obsidianEnchantability = GeneralModConfig.OBSIDIAN_TOOL_ENCHANTABILITY.get();

    private static int emeraldDurability = GeneralModConfig.EMERALD_TOOL_DURABILITY.get();
    private static double emeraldEfficiency = GeneralModConfig.EMERALD_TOOL_EFFICIENCY.get();
    private static double emeraldAttack = GeneralModConfig.EMERALD_TOOL_ATTACK.get();
    private static int emeraldMiningLevel = 3;
    private static int emeraldEnchantability = GeneralModConfig.EMERALD_TOOL_ENCHANTABILITY.get();

    private static int amethystDurability = GeneralModConfig.AMETHYST_TOOL_DURABILITY.get();
    private static double amethystEfficiency = GeneralModConfig.AMETHYST_TOOL_EFFICIENCY.get();
    private static double amethystAttack = GeneralModConfig.AMETHYST_TOOL_ATTACK.get();
    private static int amethystMiningLevel = 3;
    private static int amethystEnchantability = GeneralModConfig.AMETHYST_TOOL_ENCHANTABILITY.get();

    private static int rubyDurability = GeneralModConfig.RUBY_TOOL_DURABILITY.get();
    private static double rubyEfficiency = GeneralModConfig.RUBY_TOOL_EFFICIENCY.get();
    private static double rubyAttack = GeneralModConfig.RUBY_TOOL_ATTACK.get();
    private static int rubyMiningLevel = 3;
    private static int rubyEnchantability = GeneralModConfig.RUBY_TOOL_ENCHANTABILITY.get();


    public static final Tier COPPER = new ForgeTier(copperMiningLevel, copperDurability, (float) copperEfficiency, (float) copperAttack, copperEnchantability,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.COPPER_INGOT));

    public static final Tier OBSIDIAN = new ForgeTier(obsidianMiningLevel, obsidianDurability, (float) obsidianEfficiency, (float) obsidianAttack, obsidianEnchantability,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.OBSIDIAN));

    public static final Tier EMERALD = new ForgeTier(emeraldMiningLevel, emeraldDurability, (float) emeraldEfficiency, (float) emeraldAttack, emeraldEnchantability,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(Items.EMERALD));

    public static final Tier AMETHYST = new ForgeTier(amethystMiningLevel, amethystDurability, (float) amethystEfficiency, (float) amethystAttack, amethystEnchantability,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(Items.AMETHYST_SHARD));

    public static final Tier RUBY = new ForgeTier(rubyMiningLevel, rubyDurability, (float) rubyEfficiency, (float) rubyAttack, rubyEnchantability,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ItemInit.RUBY.get()));
}