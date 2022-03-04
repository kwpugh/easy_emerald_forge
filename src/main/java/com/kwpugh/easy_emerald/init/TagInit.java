package com.kwpugh.easy_emerald.init;

import com.kwpugh.easy_emerald.EasyEmerald;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TagInit
{
    public static final TagKey<Block> PAXEL_MINEABLE = TagKey.create(Registry.BLOCK_REGISTRY,
            new ResourceLocation(EasyEmerald.modid, "paxel_mineable"));
}
