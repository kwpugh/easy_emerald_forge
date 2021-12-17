package com.kwpugh.easy_emerald.init;

import com.kwpugh.easy_emerald.EasyEmerald;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class TierInit
{
    public static void onCommonSetup()
    {
        TierSortingRegistry.registerTier(ItemInit.COPPER_TOOL_MATERIAL, new ResourceLocation(EasyEmerald.modid, "amethyst_tool_material"), List.of(Tiers.IRON), List.of());
        TierSortingRegistry.registerTier(ItemInit.OBSIDIAN_TOOL_MATERIAL, new ResourceLocation(EasyEmerald.modid, "obsidian_tool_material"), List.of(Tiers.IRON), List.of());
        TierSortingRegistry.registerTier(ItemInit.EMERALD_TOOL_MATERIAL, new ResourceLocation(EasyEmerald.modid, "emerald_tool_material"), List.of(Tiers.DIAMOND), List.of());
        TierSortingRegistry.registerTier(ItemInit.RUBY_TOOL_MATERIAL, new ResourceLocation(EasyEmerald.modid, "ruby_tool_material"), List.of(Tiers.DIAMOND), List.of());
        TierSortingRegistry.registerTier(ItemInit.AMETHYST_TOOL_MATERIAL, new ResourceLocation(EasyEmerald.modid, "amethyst_tool_material"), List.of(Tiers.DIAMOND), List.of());
    }
}
