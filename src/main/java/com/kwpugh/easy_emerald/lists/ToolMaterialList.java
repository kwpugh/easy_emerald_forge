package com.kwpugh.easy_emerald.lists;

import java.util.function.Supplier;

import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

//Something in Forge seems to add 1 to whatever attack damage you give it
public enum ToolMaterialList implements IItemTier
{  	
    EMERALD(0.0F, 0.0F, 100, 2, 21, () -> {
        return Ingredient.fromItems(Items.EMERALD);
    }),
    
    RUBY(1.0F, 1.0f, 150, 3, 25, () -> {
            return Ingredient.fromItems(ItemInit.RUBY.get());
    });

	private float attackDamage;
	private float efficiency;
	private int durability;
	private int harvestLevel, enchantability;
	final LazyValue<Ingredient> repairMaterial;
	
	//Config values
	private int durabilityMultiplier = GeneralModConfig.DURABILITY_MULTIPLIER.get();
	private int attackAddition = GeneralModConfig.ATTACK_DAMAGE_ADDITION.get();
	private int toolEfficiency = GeneralModConfig.TOOL_EFFICIENCY.get();
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Supplier<Ingredient> repairMaterial)
	{
		this.attackDamage = attackDamage + attackAddition;
		this.efficiency = efficiency + toolEfficiency;
		this.durability = durability * durabilityMultiplier;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = new LazyValue<>(repairMaterial);
	}
	
	@Override
	public float getAttackDamage() 
	{
		return this.attackDamage;
	}

	@Override
	public float getEfficiency() 
	{
		return this.efficiency;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public int getHarvestLevel()
	{
		return this.harvestLevel;
	}

	@Override
	public int getMaxUses() 
	{
		return this.durability;
	}
	   
	@Override
	public Ingredient getRepairMaterial() 
	{
		return this.repairMaterial.getValue();
	}
}
