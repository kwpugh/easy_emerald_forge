package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
	
public enum ArmorMaterialList implements IArmorMaterial
{
	//Armor order: helmet, leggings, chestplate, boots
	EMERALD("emerald_", 1, new int[] {3, 6, 8, 3}, 15, Items.EMERALD, "entity.ender_wolf.growl", 0.0F, 0.0F),
	
	RUBY("ruby_", 5, new int[] {3, 6, 8, 3}, 15, ItemInit.RUBY.get(), "entity.ender_wolf.growl", 0.5F, 0.1F),
	
	OBSIDIAN("obsidian", 1, new int[] {3, 6, 8, 3}, 15, Items.OBSIDIAN, "entity.ender_wolf.growl", 0.0F, 0.0F);
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	
	private String name, equipSound;
	private int durability;
	private int enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	private final float knockbackResistance;
	
	//Config values
	private int armorDurabilityAddition = GeneralModConfig.ARMOR_DURABILITY_ADDITION.get();
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness, float knockbackResistance) 
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability + armorDurabilityAddition;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		
		for (int i = 0; i < damageReductionAmounts.length; i++)
		{
			damageReductionAmounts[i] = damageReductionAmounts[i];
		}
		
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return EasyEmerald.modid + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance()
	{
		return this.knockbackResistance;
	}
}
