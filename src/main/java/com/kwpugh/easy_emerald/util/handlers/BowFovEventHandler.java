package com.kwpugh.easy_emerald.util.handlers;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.items.tools.ModBow;
import com.kwpugh.easy_emerald.util.BowUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid= EasyEmerald.modid, bus=EventBusSubscriber.Bus.FORGE, value=Dist.CLIENT)
public class BowFovEventHandler
{
    static double zoom = GeneralModConfig.BOW_ZOOM.get();

    @SubscribeEvent
    public static void onFovEvent(ComputeFovModifierEvent event)
    {
        BowUtils.setupBowFov(event, p -> p instanceof ModBow, (float) zoom);
    }
}
