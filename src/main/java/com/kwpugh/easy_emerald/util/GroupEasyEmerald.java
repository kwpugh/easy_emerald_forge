package com.kwpugh.easy_emerald.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class GroupEasyEmerald extends CreativeModeTab
{
	public GroupEasyEmerald() 
	{
		super("easy_emerald");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return new ItemStack(Items.EMERALD);
	}	
}
