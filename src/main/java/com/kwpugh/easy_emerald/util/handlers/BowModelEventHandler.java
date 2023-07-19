package com.kwpugh.easy_emerald.util.handlers;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.init.ItemInit;
import com.kwpugh.easy_emerald.util.BowUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EasyEmerald.Modid, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BowModelEventHandler
{
    @SubscribeEvent
    public static void setModelProperties(FMLClientSetupEvent event)
    {
        BowUtils.setupBowModelProperties(ItemInit.COPPER_BOW.get());
        BowUtils.setupBowModelProperties(ItemInit.OBSIDIAN_BOW.get());
        BowUtils.setupBowModelProperties(ItemInit.EMERALD_BOW.get());
        BowUtils.setupBowModelProperties(ItemInit.AMETHYST_BOW.get());
        BowUtils.setupBowModelProperties(ItemInit.RUBY_BOW.get());
    }
}
