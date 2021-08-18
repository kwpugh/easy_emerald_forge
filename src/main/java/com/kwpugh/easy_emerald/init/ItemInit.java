package com.kwpugh.easy_emerald.init;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.items.EmeraldJuju;
import com.kwpugh.easy_emerald.items.EmeraldPotato;
import com.kwpugh.easy_emerald.items.RubyJuju;
import com.kwpugh.easy_emerald.items.RubyPotato;
import com.kwpugh.easy_emerald.lists.*;

import com.kwpugh.easy_emerald.items.tools.base.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{
	public static final Tier EMERALD_TOOL_MATERIAL = new EmeraldToolMaterial();
	public static final Tier RUBY_TOOL_MATERIAL = new RubyToolMaterial();
	public static final Tier OBSIDIAN_TOOL_MATERIAL = new ObsidianToolMaterial();
	public static final Tier AMETHYST_TOOL_MATERIAL = new AmethystToolMaterial();

	public static final ArmorMaterial EMERALD_ARMOR_MATERIAL = new EmeraldArmorMaterial();
	public static final ArmorMaterial RUBY_ARMOR_MATERIAL = new RubyArmorMaterial();
	public static final ArmorMaterial OBSIDIAN_ARMOR_MATERIAL = new ObsidianArmorMaterial();
	public static final ArmorMaterial AMETHYST_ARMOR_MATERIAL = new AmethystArmorMaterial();

	static int emeraldDurability = GeneralModConfig.EMERALD_TOOL_DURABILITY.get();
	static int rubyDurability = GeneralModConfig.RUBY_TOOL_DURABILITY.get();
	static int obsidianDurability = GeneralModConfig.OBSIDIAN_TOOL_DURABILITY.get();
	static int amethystDurability = GeneralModConfig.AMETHYST_TOOL_DURABILITY.get();

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EasyEmerald.modid);
	
	public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new SwordItem(EMERALD_TOOL_MATERIAL, 2, -2.4f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_BOW = ITEMS.register("emerald_bow", () -> new ModBow((new Item.Properties()).stacksTo(1).tab(EasyEmerald.easy_emerald_group).durability(emeraldDurability)));
	public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new PickaxeItem(EMERALD_TOOL_MATERIAL, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new AxeItem(EMERALD_TOOL_MATERIAL, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ShovelItem(EMERALD_TOOL_MATERIAL, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new HoeItem(EMERALD_TOOL_MATERIAL, 0, -2.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_EXCAVATOR = ITEMS.register("emerald_excavator", () -> new ModExcavator(EMERALD_TOOL_MATERIAL, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_HAMMER = ITEMS.register("emerald_hammer", () -> new ModHammer(EMERALD_TOOL_MATERIAL, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_PAXEL = ITEMS.register("emerald_paxel", () -> new ModPaxel(4, -3.0f, EMERALD_TOOL_MATERIAL, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_TREEAXE = ITEMS.register("emerald_treeaxe", () -> new ModTreeAxe(EMERALD_TOOL_MATERIAL, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	
	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_BLOCK = ITEMS.register("ruby_block", () -> new BlockItem(BlockInit.RUBY_BLOCK.get(), new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	
	public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new SwordItem(RUBY_TOOL_MATERIAL, 2, -2.4f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_BOW = ITEMS.register("ruby_bow", () -> new ModBow((new Item.Properties()).stacksTo(1).tab(EasyEmerald.easy_emerald_group).durability(rubyDurability)));
	public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(RUBY_TOOL_MATERIAL, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new AxeItem(RUBY_TOOL_MATERIAL, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ShovelItem(RUBY_TOOL_MATERIAL, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new HoeItem(RUBY_TOOL_MATERIAL, 0, -2.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_EXCAVATOR = ITEMS.register("ruby_excavator", () -> new ModExcavator(RUBY_TOOL_MATERIAL, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_HAMMER = ITEMS.register("ruby_hammer", () -> new ModHammer(RUBY_TOOL_MATERIAL, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_PAXEL = ITEMS.register("ruby_paxel", () -> new ModPaxel(4, -3.0f, RUBY_TOOL_MATERIAL, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_TREEAXE = ITEMS.register("ruby_treeaxe", () -> new ModTreeAxe(RUBY_TOOL_MATERIAL, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	
	public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new SwordItem(OBSIDIAN_TOOL_MATERIAL, 2, -2.4f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_BOW = ITEMS.register("obsidian_bow", () -> new ModBow((new Item.Properties()).stacksTo(1).tab(EasyEmerald.easy_emerald_group).durability(obsidianDurability)));
	public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new PickaxeItem(OBSIDIAN_TOOL_MATERIAL, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () -> new AxeItem(OBSIDIAN_TOOL_MATERIAL, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () -> new ShovelItem(OBSIDIAN_TOOL_MATERIAL, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () -> new HoeItem(OBSIDIAN_TOOL_MATERIAL, 0, -2.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_EXCAVATOR = ITEMS.register("obsidian_excavator", () -> new ModExcavator(OBSIDIAN_TOOL_MATERIAL, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_HAMMER = ITEMS.register("obsidian_hammer", () -> new ModHammer(OBSIDIAN_TOOL_MATERIAL, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_PAXEL = ITEMS.register("obsidian_paxel", () -> new ModPaxel(4, -3.0f, OBSIDIAN_TOOL_MATERIAL, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_TREEAXE = ITEMS.register("obsidian_treeaxe", () -> new ModTreeAxe(OBSIDIAN_TOOL_MATERIAL, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword", () -> new SwordItem(AMETHYST_TOOL_MATERIAL, 2, -2.4f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_BOW = ITEMS.register("amethyst_bow", () -> new ModBow((new Item.Properties()).stacksTo(1).tab(EasyEmerald.easy_emerald_group).durability(amethystDurability)));
	public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe", () -> new PickaxeItem(AMETHYST_TOOL_MATERIAL, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe", () -> new AxeItem(AMETHYST_TOOL_MATERIAL, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel", () -> new ShovelItem(AMETHYST_TOOL_MATERIAL, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe", () -> new HoeItem(AMETHYST_TOOL_MATERIAL, 0, -2.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_EXCAVATOR = ITEMS.register("amethyst_excavator", () -> new ModExcavator(AMETHYST_TOOL_MATERIAL, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_HAMMER = ITEMS.register("amethyst_hammer", () -> new ModHammer(AMETHYST_TOOL_MATERIAL, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_PAXEL = ITEMS.register("amethyst_paxel", () -> new ModPaxel(4, -3.0f, AMETHYST_TOOL_MATERIAL, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_TREEAXE = ITEMS.register("amethyst_treeaxe", () -> new ModTreeAxe(AMETHYST_TOOL_MATERIAL, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> ARMOR_EMERALD_HEAD = ITEMS.register("emerald_head", () -> new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_EMERALD_BODY = ITEMS.register("emerald_body", () -> new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new ArmorItem(EMERALD_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> ARMOR_RUBY_HEAD = ITEMS.register("ruby_head", () -> new ArmorItem(RUBY_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_RUBY_BODY = ITEMS.register("ruby_body", () -> new ArmorItem(RUBY_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new ArmorItem(RUBY_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new ArmorItem(RUBY_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> ARMOR_OBSIDIAN_HEAD = ITEMS.register("obsidian_head", () -> new ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_OBSIDIAN_BODY = ITEMS.register("obsidian_body", () -> new ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> ARMOR_AMETHYST_HEAD = ITEMS.register("amethyst_head", () -> new ArmorItem(AMETHYST_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_AMETHYST_BODY = ITEMS.register("amethyst_body", () -> new ArmorItem(AMETHYST_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings", () -> new ArmorItem(AMETHYST_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_AMETHYST_BOOTS = ITEMS.register("amethyst_boots", () -> new ArmorItem(AMETHYST_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> EMERALD_POTATO = ITEMS.register("emerald_potato", () -> new EmeraldPotato(new Item.Properties().food(FoodList.emerald_potato).tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_POTATO = ITEMS.register("ruby_potato", () -> new RubyPotato(new Item.Properties().food(FoodList.ruby_potato).tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> EMERALD_JUJU = ITEMS.register("emerald_juju", () -> new EmeraldJuju(new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_JUJU = ITEMS.register("ruby_juju", () -> new RubyJuju(new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
}
