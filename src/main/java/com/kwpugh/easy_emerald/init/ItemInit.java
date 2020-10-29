package com.kwpugh.easy_emerald.init;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.items.EmeraldBow;
import com.kwpugh.easy_emerald.items.EmeraldJuju;
import com.kwpugh.easy_emerald.items.EmeraldPotato;
import com.kwpugh.easy_emerald.items.ObsidianArmor;
import com.kwpugh.easy_emerald.items.ObsidianBow;
import com.kwpugh.easy_emerald.items.RubyArmor;
import com.kwpugh.easy_emerald.items.RubyBow;
import com.kwpugh.easy_emerald.items.RubyJuju;
import com.kwpugh.easy_emerald.items.RubyPotato;
import com.kwpugh.easy_emerald.lists.ArmorMaterialList;
import com.kwpugh.easy_emerald.lists.FoodList;
import com.kwpugh.easy_emerald.lists.ToolMaterialList;
import com.kwpugh.easy_emerald.tools.EmeraldExcavator;
import com.kwpugh.easy_emerald.tools.EmeraldHammer;
import com.kwpugh.easy_emerald.tools.EmeraldPaxel;
import com.kwpugh.easy_emerald.tools.EmeraldTreeAxe;
import com.kwpugh.easy_emerald.tools.ObsidianExcavator;
import com.kwpugh.easy_emerald.tools.ObsidianHammer;
import com.kwpugh.easy_emerald.tools.ObsidianPaxel;
import com.kwpugh.easy_emerald.tools.ObsidianTreeAxe;
import com.kwpugh.easy_emerald.tools.RubyExcavator;
import com.kwpugh.easy_emerald.tools.RubyHammer;
import com.kwpugh.easy_emerald.tools.RubyPaxel;
import com.kwpugh.easy_emerald.tools.RubyTreeAxe;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EasyEmerald.modid);
	
	public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new SwordItem(ToolMaterialList.EMERALD, 2, -2.4f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_BOW = ITEMS.register("emerald_bow", () -> new EmeraldBow((new Item.Properties()).maxStackSize(1).group(EasyEmerald.easy_emerald_group).maxDamage(700)));
	public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new PickaxeItem(ToolMaterialList.EMERALD, 0, -2.8f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new AxeItem(ToolMaterialList.EMERALD, 4, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ShovelItem(ToolMaterialList.EMERALD, 0, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new HoeItem(ToolMaterialList.EMERALD, 0, -2.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_EXCAVATOR = ITEMS.register("emerald_excavator", () -> new EmeraldExcavator(ToolMaterialList.EMERALD, 0, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_HAMMER = ITEMS.register("emerald_hammer", () -> new EmeraldHammer(ToolMaterialList.EMERALD, 0, -2.8f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_PAXEL = ITEMS.register("emerald_paxel", () -> new EmeraldPaxel(4, -3.0f, ToolMaterialList.EMERALD, null, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_TREEAXE = ITEMS.register("emerald_treeaxe", () -> new EmeraldTreeAxe(ToolMaterialList.EMERALD, 4, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	
	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_BLOCK = ITEMS.register("ruby_block", () -> new BlockItem(BlockInit.RUBY_BLOCK.get(), new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	
	public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new SwordItem(ToolMaterialList.RUBY, 2, -2.4f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_BOW = ITEMS.register("ruby_bow", () -> new RubyBow((new Item.Properties()).maxStackSize(1).group(EasyEmerald.easy_emerald_group).maxDamage(1050)));
	public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ToolMaterialList.RUBY, 0, -2.8f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new AxeItem(ToolMaterialList.RUBY, 4, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ShovelItem(ToolMaterialList.RUBY, 0, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new HoeItem(ToolMaterialList.RUBY, 0, -2.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_EXCAVATOR = ITEMS.register("ruby_excavator", () -> new RubyExcavator(ToolMaterialList.RUBY, 0, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_HAMMER = ITEMS.register("ruby_hammer", () -> new RubyHammer(ToolMaterialList.RUBY, 0, -2.8f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_PAXEL = ITEMS.register("ruby_paxel", () -> new RubyPaxel(4, -3.0f, ToolMaterialList.RUBY, null, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_TREEAXE = ITEMS.register("ruby_treeaxe", () -> new RubyTreeAxe(ToolMaterialList.RUBY, 4, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	
	public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new SwordItem(ToolMaterialList.OBSIDIAN, 2, -2.4f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_BOW = ITEMS.register("obsidian_bow", () -> new ObsidianBow((new Item.Properties()).maxStackSize(1).group(EasyEmerald.easy_emerald_group).maxDamage(525)));
	public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new PickaxeItem(ToolMaterialList.OBSIDIAN, 0, -2.8f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () -> new AxeItem(ToolMaterialList.OBSIDIAN, 4, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () -> new ShovelItem(ToolMaterialList.OBSIDIAN, 0, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () -> new HoeItem(ToolMaterialList.OBSIDIAN, 0, -2.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_EXCAVATOR = ITEMS.register("obsidian_excavator", () -> new ObsidianExcavator(ToolMaterialList.OBSIDIAN, 0, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_HAMMER = ITEMS.register("obsidian_hammer", () -> new ObsidianHammer(ToolMaterialList.OBSIDIAN, 0, -2.8f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_PAXEL = ITEMS.register("obsidian_paxel", () -> new ObsidianPaxel(4, -3.0f, ToolMaterialList.OBSIDIAN, null, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_TREEAXE = ITEMS.register("obsidian_treeaxe", () -> new ObsidianTreeAxe(ToolMaterialList.OBSIDIAN, 4, -3.0f, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	
	public static final RegistryObject<Item> ARMOR_EMERALD_HEAD = ITEMS.register("emerald_head", () -> new ArmorItem(ArmorMaterialList.EMERALD, EquipmentSlotType.HEAD, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_EMERALD_BODY = ITEMS.register("emerald_body", () -> new ArmorItem(ArmorMaterialList.EMERALD, EquipmentSlotType.CHEST, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new ArmorItem(ArmorMaterialList.EMERALD, EquipmentSlotType.LEGS, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new ArmorItem(ArmorMaterialList.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> ARMOR_RUBY_HEAD = ITEMS.register("ruby_head", () -> new RubyArmor(ArmorMaterialList.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_RUBY_BODY = ITEMS.register("ruby_body", () -> new RubyArmor(ArmorMaterialList.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new RubyArmor(ArmorMaterialList.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new RubyArmor(ArmorMaterialList.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(EasyEmerald.easy_emerald_group)));	

	public static final RegistryObject<Item> ARMOR_OBSIDIAN_HEAD = ITEMS.register("obsidian_head", () -> new ObsidianArmor(ArmorMaterialList.OBSIDIAN, EquipmentSlotType.HEAD, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_OBSIDIAN_BODY = ITEMS.register("obsidian_body", () -> new ObsidianArmor(ArmorMaterialList.OBSIDIAN, EquipmentSlotType.CHEST, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ObsidianArmor(ArmorMaterialList.OBSIDIAN, EquipmentSlotType.LEGS, new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ObsidianArmor(ArmorMaterialList.OBSIDIAN, EquipmentSlotType.FEET, new Item.Properties().group(EasyEmerald.easy_emerald_group)));	

	public static final RegistryObject<Item> EMERALD_POTATO = ITEMS.register("emerald_potato", () -> new EmeraldPotato(new Item.Properties().food(FoodList.emerald_potato).group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_POTATO = ITEMS.register("ruby_potato", () -> new RubyPotato(new Item.Properties().food(FoodList.ruby_potato).group(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> EMERALD_JUJU = ITEMS.register("emerald_juju", () -> new EmeraldJuju(new Item.Properties().group(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_JUJU = ITEMS.register("ruby_juju", () -> new RubyJuju(new Item.Properties().group(EasyEmerald.easy_emerald_group)));
}
