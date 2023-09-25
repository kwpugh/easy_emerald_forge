package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.config.GeneralModConfig;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;

public class CopperArmorMaterial implements ArmorMaterial
{
    private static int copperDurabilityMultiplier = GeneralModConfig.COPPER_ARMOR_DURABILITY_MULTIPLIER.get();
    private static int copperEnchantability = GeneralModConfig.COPPER_ARMOR_ENCHANTABILITY.get();
    private static double copperToughness = GeneralModConfig.COPPER_ARMOR_TOUGHNESS.get();
    private static double copperKnochback = GeneralModConfig.COPPER_ARMOR_KNOCKBACK_RESISTANCE.get();

    private static int copperHead = GeneralModConfig.COPPER_ARMOR_PROTECTION_HEAD.get();
    private static int copperBody = GeneralModConfig.COPPER_ARMOR_PROTECTION_BODY.get();
    private static int copperLeggings = GeneralModConfig.COPPER_ARMOR_PROTECTION_LEGGINGS.get();
    private static int copperFeet = GeneralModConfig.COPPER_ARMOR_PROTECTION_FEET.get();

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_AMOUNT = new int[]{copperHead, copperLeggings, copperBody, copperFeet};

    public int getDefenseForSlot(EquipmentSlot slot)
    {
        return PROTECTION_AMOUNT[slot.getIndex()];
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type p_266807_) {
        return BASE_DURABILITY[p_266807_.getSlot().getIndex()] * copperDurabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type p_267168_) {
        return PROTECTION_AMOUNT[p_267168_.getSlot().getIndex()];
    }

    @Override
    public int getEnchantmentValue()
    {
        return copperEnchantability;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(Items.COPPER_INGOT);
    }

    @Override
    public String getName()
    {
        return EasyEmerald.Modid + ":" + "copper";
    }

    @Override
    public float getToughness()
    {
        return (float) copperToughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return (float) copperKnochback;
    }
}