package com.kwpugh.easy_emerald.items;

import com.kwpugh.easy_emerald.init.ItemInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RubyArmor extends ArmorItem
{
	public RubyArmor(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}	
	
	public void onArmorTick(final ItemStack stack, final World world, final PlayerEntity player)
	{
		if(player instanceof PlayerEntity)
		{
			ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
			ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
			ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
		    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
		    
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
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemInit.RUBY.get();
	}
}
