package com.kwpugh.easy_emerald.init;

import com.kwpugh.easy_emerald.EasyEmerald;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EasyEmerald.modid);

	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.METAL)));	
}
