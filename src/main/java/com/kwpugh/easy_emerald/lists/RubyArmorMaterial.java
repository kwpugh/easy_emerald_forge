package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.init.ItemInit;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class RubyArmorMaterial implements ArmorMaterial
{	
	private static int durabilityMultiplier = GeneralModConfig.RUBY_ARMOR_DURABILITY_MULTIPLIER.get();
	private static int enchantability = GeneralModConfig.RUBY_ARMOR_ENCHANTABILITY.get();	
	private static double toughness = GeneralModConfig.RUBY_ARMOR_TOUGHNESS.get();
	private static double knochback = GeneralModConfig.RUBY_ARMOR_KNOCKBACK_RESISTANCE.get();

	private static int rubyHead = GeneralModConfig.RUBY_ARMOR_PROTECTION_HEAD.get();
	private static int rubyBody = GeneralModConfig.RUBY_ARMOR_PROTECTION_BODY.get();
	private static int rubyLeggings = GeneralModConfig.RUBY_ARMOR_PROTECTION_LEGGINGS.get();
	private static int rubyFeet = GeneralModConfig.RUBY_ARMOR_PROTECTION_FEET.get();

	private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_AMOUNT = new int[]{rubyHead, rubyLeggings, rubyBody, rubyFeet};
    
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
		return Ingredient.of(ItemInit.RUBY.get());
	}

	@Override
	public String getName()
	{
		return EasyEmerald.modid + ":" + "ruby";
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