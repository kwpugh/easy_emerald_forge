package com.kwpugh.easy_emerald.items.tools;

import com.kwpugh.easy_emerald.init.TagInit;
import com.kwpugh.easy_emerald.items.tools.base.PaxelBase;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;

public class ModPaxel extends PaxelBase
{
    public ModPaxel(float attackDamageIn, float attackSpeedIn, Tier tier, TagKey<Block> mineable, Properties builder)
    {
        super(attackDamageIn, attackSpeedIn, tier, TagInit.PAXEL_MINEABLE, builder);
    }
}