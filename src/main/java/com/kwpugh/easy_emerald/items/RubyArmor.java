package com.kwpugh.easy_emerald.items;

import com.kwpugh.easy_emerald.init.ItemInit;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class RubyArmor extends ArmorItem
{
	public RubyArmor(ArmorMaterial materialIn, EquipmentSlot slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}	
	
	public void onArmorTick(final ItemStack stack, final Level world, final Player player)
	{
		if(player instanceof Player)
		{
			ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
			ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
			ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
		    ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);
		    
		    //Full Set
	    	if(head.getItem() == ItemInit.ARMOR_RUBY_HEAD.get() && 
	    			chest.getItem() == ItemInit.ARMOR_RUBY_BODY.get() && 
	    			legs.getItem() == ItemInit.ARMOR_RUBY_LEGGINGS.get() && 
	    			feet.getItem() == ItemInit.ARMOR_RUBY_BOOTS.get())
	    	{
//				player.removeActivePotionEffect(Effects.POISON);
	    	}	
		    
		    //Helmet
		    if(head.getItem() == ItemInit.ARMOR_RUBY_HEAD.get())
			{
//				int newfoodlevel = 1;
//				float newsatlevel = 0.25F;
//				PlayerSpecialAbilities.giveRegenffect(world, player, stack, newfoodlevel, newsatlevel);	
			}
			else
			{
				//something
			}
		    
		    //Chestplate
		    if(chest.getItem() == ItemInit.ARMOR_RUBY_BODY.get())
			{
		    	//Something
			}
		    
		    //Leggings
		    if(legs.getItem() == ItemInit.ARMOR_RUBY_LEGGINGS.get())
			{
		    	//something
			}
			else
			{
				//something
			}
		    
		    //Boots
		    if(feet.getItem() == ItemInit.ARMOR_RUBY_BOOTS.get())
			{
		    	//something - maybe Speed?
			}
			else
			{
				//something
			}		    	
		}
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemInit.RUBY.get();
	}
}
