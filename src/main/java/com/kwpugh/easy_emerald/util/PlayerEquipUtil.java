package com.kwpugh.easy_emerald.util;

import javax.annotation.Nonnull;

import com.kwpugh.easy_emerald.init.ItemInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public final class PlayerEquipUtil
{	   
    @Nonnull
    //@SuppressWarnings("ConstantConditions")
    public static <T> T _null() 
    {
        return null;
    }
  
    public static boolean isPlayerGotFallProtection(PlayerEntity player)
    { 
    	ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
	    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
			
	    //Full Set or token
    	if(		(head.getItem() == ItemInit.ARMOR_RUBY_HEAD.get() && 
    			chest.getItem() == ItemInit.ARMOR_RUBY_BODY.get() && 
    			legs.getItem() == ItemInit.ARMOR_RUBY_LEGGINGS.get() && 
    			feet.getItem() == ItemInit.ARMOR_RUBY_BOOTS.get())    )
	      	{
	      		return true;  		
	      	}
		return false;
    } 
    
    public static boolean isPlayerGotFireProtection(PlayerEntity player)
    {
    	ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
	    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
	    
	    //Full armor or Token
    	if(		((head.getItem() == ItemInit.ARMOR_RUBY_HEAD.get() && 
    			chest.getItem() == ItemInit.ARMOR_RUBY_BODY.get() && 
    			legs.getItem() == ItemInit.ARMOR_RUBY_LEGGINGS.get() && 
    			feet.getItem() == ItemInit.ARMOR_RUBY_BOOTS.get()))      )     
	      	{
	      		return true;  		
	      	}
      		
        return false;
    }
    
    public static boolean isPlayerGotWaterBreathing(PlayerEntity player)
    {
    	ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
	    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
	    
	    //Full armor or Token
    	if(		((head.getItem() == ItemInit.ARMOR_RUBY_HEAD.get() && 
    			chest.getItem() == ItemInit.ARMOR_RUBY_BODY.get() && 
    			legs.getItem() == ItemInit.ARMOR_RUBY_LEGGINGS.get() && 
    			feet.getItem() == ItemInit.ARMOR_RUBY_BOOTS.get()))      )     
	      	{
	      		return true;  		
	      	}
      		
        return false;
    }
} 