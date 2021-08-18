package com.kwpugh.easy_emerald.items.tools.base;

import com.kwpugh.easy_emerald.init.TagInit;

import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Tier;

public class ModPaxel extends PaxelBase
{
    public ModPaxel(float attackDamageIn, float attackSpeedIn, Tier tier, Tag<Block> mineable,
                        Properties builder)
    {
        super(attackDamageIn, attackSpeedIn, tier, TagInit.PAXEL_MINEABLE, builder);
    }
}