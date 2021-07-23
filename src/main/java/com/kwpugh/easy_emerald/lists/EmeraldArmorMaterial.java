package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.config.GeneralModConfig;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class EmeraldArmorMaterial implements ArmorMaterial
{	
	private static int durabilityMultiplier = GeneralModConfig.EMERALD_ARMOR_DURABILITY_MULTIPLIER.get();
	private static int enchantability = GeneralModConfig.EMERALD_ARMOR_ENCHANTABILITY.get();	
	private static double toughness = GeneralModConfig.EMERALD_ARMOR_TOUGHNESS.get();
	private static double knochback = GeneralModConfig.EMERALD_ARMOR_KNOCKBACK_RESISTANCE.get();
				
	private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_AMOUNT = new int[]{3, 6, 8, 3};
    
	@Override
	public int getDurabilityForSlot(EquipmentSlot slot)
	{
		return BASE_DURABILITY[slot.getIndex()] * durabilityMultiplier;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot slot)
	{
		return PROTECTION_AMOUNT[slot.getIndex()];
	}

	@Override
	public int getEnchantmentValue()
	{
		return enchantability;
	}

	@Override
	public SoundEvent getEquipSound()
	{
		return new SoundEvent(new ResourceLocation("item.armor.equip_diamond"));
	}

	@Override
	public Ingredient getRepairIngredient()
	{
		return Ingredient.of(Items.EMERALD);
	}

	@Override
	public String getName()
	{
		return EasyEmerald.modid + ":" + "emerald";
	}

	@Override
	public float getToughness()
	{
		return (float) toughness;
	}

	@Override
	public float getKnockbackResistance()
	{
		return (float) knochback;
	}
}
