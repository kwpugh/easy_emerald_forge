package com.kwpugh.easy_emerald.util;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class GroupEasyEmerald extends ItemGroup
{
	public GroupEasyEmerald() 
	{
		super("easy_emerald");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(Items.EMERALD);
	}	
}
