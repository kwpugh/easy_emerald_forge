package com.kwpugh.easy_emerald.items.tools;

import com.kwpugh.easy_emerald.items.tools.base.HammerBase;
import net.minecraft.world.item.Tier;

public class ModHammer extends HammerBase
{
    public ModHammer(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}