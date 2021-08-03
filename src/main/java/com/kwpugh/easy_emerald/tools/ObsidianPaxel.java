package com.kwpugh.easy_emerald.tools;

import com.kwpugh.easy_emerald.init.TagInit;
import com.kwpugh.easy_emerald.tools.base.PaxelBase;

import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ObsidianPaxel extends PaxelBase
{	
	public ObsidianPaxel(float attackDamageIn, float attackSpeedIn, Tier tier, Tag<Block> mineable,
			Properties builder)
	{
		super(attackDamageIn, attackSpeedIn, tier, TagInit.PAXEL_MINEABLE, builder);
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == Items.OBSIDIAN;
	}
}