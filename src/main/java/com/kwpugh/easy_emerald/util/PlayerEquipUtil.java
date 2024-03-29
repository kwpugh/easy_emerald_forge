package com.kwpugh.easy_emerald.util;

import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.init.ItemInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public final class PlayerEquipUtil
{	   
    @Nonnull
    //@SuppressWarnings("ConstantConditions")
    public static <T> T _null() 
    {
        return null;
    }
  
    public static boolean isPlayerGotFallProtection(Player player)
    {
    	if(GeneralModConfig.AMETHYST_NO_FALL_DAMAGE.get())
		{
			ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
			ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
			ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
			ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

			//Full Set or token
			if(		(head.getItem() == ItemInit.ARMOR_AMETHYST_HEAD.get() &&
					chest.getItem() == ItemInit.ARMOR_AMETHYST_BODY.get() &&
					legs.getItem() == ItemInit.ARMOR_AMETHYST_LEGGINGS.get() &&
					feet.getItem() == ItemInit.ARMOR_AMETHYST_BOOTS.get())    )
			{
				return true;
			}
		}

		return false;
    } 
    
    public static boolean isPlayerGotFireProtection(Player player)
    {
    	if(GeneralModConfig.RUBY_FIRE_PROTECTION.get())
		{
			ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
			ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
			ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
			ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

			//Full armor or Token
			if(		((head.getItem() == ItemInit.ARMOR_RUBY_HEAD.get() &&
					chest.getItem() == ItemInit.ARMOR_RUBY_BODY.get() &&
					legs.getItem() == ItemInit.ARMOR_RUBY_LEGGINGS.get() &&
					feet.getItem() == ItemInit.ARMOR_RUBY_BOOTS.get()))      )
			{
				return true;
			}
		}
      		
        return false;
    }
    
    public static boolean isPlayerGotWaterBreathing(Player player)
    {
    	if(GeneralModConfig.EMERAALD_WATER_BREATHING.get())
		{
			ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
			ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
			ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
			ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

			//Full armor or Token
			if(		((head.getItem() == ItemInit.ARMOR_EMERALD_HEAD.get() &&
					chest.getItem() == ItemInit.ARMOR_EMERALD_BODY.get() &&
					legs.getItem() == ItemInit.ARMOR_EMERALD_LEGGINGS.get() &&
					feet.getItem() == ItemInit.ARMOR_EMERALD_BOOTS.get()))      )
			{
				return true;
			}
		}

        return false;
    }
    
    public static boolean isPlayerGotRubySwordInHand(Player player)
    { 	    
    	ItemStack mainHand = player.getMainHandItem();
    	
    	if(mainHand.getItem() == ItemInit.RUBY_SWORD.get())
      	{
      		return true;  		
      	} 
		
        return false;
    }

	public static boolean hasArrowInInventory(Player player)
	{
		Inventory inv = player.getInventory();
		for (int slot = 0; slot < inv.getContainerSize(); slot++)
		{
			ItemStack stack = inv.getItem(slot);
			if (stack.getItem() instanceof ArrowItem)
			{
				return true;
			}
		}

		return false;
	}

	public static boolean hasItemInInventory(Player player, Item item)
	{
		Inventory inv = player.getInventory();
		for (int slot = 0; slot < inv.getContainerSize(); slot++)
		{
			ItemStack stack = inv.getItem(slot);
			if (stack.getItem() == item)
			{
				return true;
			}
		}

		return false;
	}

	public static ItemStack getItemInInventory(Player player, Item item)
	{
		Inventory inv = player.getInventory();
		for (int slot = 0; slot < inv.getContainerSize(); slot++)
		{
			ItemStack stack = inv.getItem(slot);
			if (stack.getItem() == item)
			{
				return stack;
			}
		}

		return ItemStack.EMPTY;
	}

	public static boolean hasItemInEnderchest(Player player, Item item)
	{
		PlayerEnderChestContainer end_inv = player.getEnderChestInventory();
		for (int slot = 0; slot < end_inv.getContainerSize(); slot++)
		{
			ItemStack stack = end_inv.getItem(slot);
			if (stack.getItem() == item)
			{
				return true;
			}
		}

		return false;
	}

	public static ItemStack getItemInEnderchest(Player player, Item item)
	{
		PlayerEnderChestContainer end_inv = player.getEnderChestInventory();
		for (int slot = 0; slot < end_inv.getContainerSize(); slot++)
		{
			ItemStack stack = end_inv.getItem(slot);
			if (stack.getItem() == item)
			{
				return stack;
			}
		}

		return ItemStack.EMPTY;
	}
} 