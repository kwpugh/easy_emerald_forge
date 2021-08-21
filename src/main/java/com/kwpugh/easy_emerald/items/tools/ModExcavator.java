package com.kwpugh.easy_emerald.items.tools;

import com.kwpugh.easy_emerald.items.tools.base.ExcavatorBase;
import net.minecraft.world.item.Tier;

public class ModExcavator extends ExcavatorBase
{
    public ModExcavator(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}