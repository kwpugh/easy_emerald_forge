package com.kwpugh.easy_emerald.init;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.items.food.AmethystPotato;
import com.kwpugh.easy_emerald.items.food.EmeraldPotato;
import com.kwpugh.easy_emerald.items.food.RubyPotato;
import com.kwpugh.easy_emerald.items.juju.AmethystJuju;
import com.kwpugh.easy_emerald.items.juju.EmeraldJuju;
import com.kwpugh.easy_emerald.items.juju.RubyJuju;
import com.kwpugh.easy_emerald.items.tools.*;
import com.kwpugh.easy_emerald.lists.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit
{
	public static final ArmorMaterial EMERALD_ARMOR_MATERIAL = new EmeraldArmorMaterial();
	public static final ArmorMaterial RUBY_ARMOR_MATERIAL = new RubyArmorMaterial();
	public static final ArmorMaterial OBSIDIAN_ARMOR_MATERIAL = new ObsidianArmorMaterial();
	public static final ArmorMaterial AMETHYST_ARMOR_MATERIAL = new AmethystArmorMaterial();
	public static final ArmorMaterial COPPER_ARMOR_MATERIAL = new CopperArmorMaterial();

	static int emeraldDurability = GeneralModConfig.EMERALD_TOOL_DURABILITY.get();
	static int rubyDurability = GeneralModConfig.RUBY_TOOL_DURABILITY.get();
	static int obsidianDurability = GeneralModConfig.OBSIDIAN_TOOL_DURABILITY.get();
	static int amethystDurability = GeneralModConfig.AMETHYST_TOOL_DURABILITY.get();
	static int copperDurability = GeneralModConfig.COPPER_TOOL_DURABILITY.get();

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EasyEmerald.modid);
	
	public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new SwordItem(ToolMaterialTiers.EMERALD, 2, -2.4f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_BOW = ITEMS.register("emerald_bow", () -> new ModBow((new Item.Properties()).stacksTo(1).tab(EasyEmerald.easy_emerald_group).durability(emeraldDurability)));
	public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new PickaxeItem(ToolMaterialTiers.EMERALD, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new AxeItem(ToolMaterialTiers.EMERALD, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ShovelItem(ToolMaterialTiers.EMERALD, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new HoeItem(ToolMaterialTiers.EMERALD, 0, -2.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_EXCAVATOR = ITEMS.register("emerald_excavator", () -> new ModExcavator(ToolMaterialTiers.EMERALD, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_HAMMER = ITEMS.register("emerald_hammer", () -> new ModHammer(ToolMaterialTiers.EMERALD, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_PAXEL = ITEMS.register("emerald_paxel", () -> new ModPaxel(4, -3.0f, ToolMaterialTiers.EMERALD, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> EMERALD_TREEAXE = ITEMS.register("emerald_treeaxe", () -> new ModTreeAxe(ToolMaterialTiers.EMERALD, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	
	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_BLOCK = ITEMS.register("ruby_block", () -> new BlockItem(BlockInit.RUBY_BLOCK.get(), new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	
	public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new SwordItem(ToolMaterialTiers.RUBY, 2, -2.4f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_BOW = ITEMS.register("ruby_bow", () -> new ModBow((new Item.Properties()).stacksTo(1).tab(EasyEmerald.easy_emerald_group).durability(rubyDurability)));
	public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ToolMaterialTiers.RUBY, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new AxeItem(ToolMaterialTiers.RUBY, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ShovelItem(ToolMaterialTiers.RUBY, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new HoeItem(ToolMaterialTiers.RUBY, 0, -2.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_EXCAVATOR = ITEMS.register("ruby_excavator", () -> new ModExcavator(ToolMaterialTiers.RUBY, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_HAMMER = ITEMS.register("ruby_hammer", () -> new ModHammer(ToolMaterialTiers.RUBY, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_PAXEL = ITEMS.register("ruby_paxel", () -> new ModPaxel(4, -3.0f, ToolMaterialTiers.RUBY, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_TREEAXE = ITEMS.register("ruby_treeaxe", () -> new ModTreeAxe(ToolMaterialTiers.RUBY, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	
	public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new SwordItem(ToolMaterialTiers.OBSIDIAN, 2, -2.4f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_BOW = ITEMS.register("obsidian_bow", () -> new ModBow((new Item.Properties()).stacksTo(1).tab(EasyEmerald.easy_emerald_group).durability(obsidianDurability)));
	public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new PickaxeItem(ToolMaterialTiers.OBSIDIAN, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () -> new AxeItem(ToolMaterialTiers.OBSIDIAN, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () -> new ShovelItem(ToolMaterialTiers.OBSIDIAN, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () -> new HoeItem(ToolMaterialTiers.OBSIDIAN, 0, -2.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_EXCAVATOR = ITEMS.register("obsidian_excavator", () -> new ModExcavator(ToolMaterialTiers.OBSIDIAN, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_HAMMER = ITEMS.register("obsidian_hammer", () -> new ModHammer(ToolMaterialTiers.OBSIDIAN, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_PAXEL = ITEMS.register("obsidian_paxel", () -> new ModPaxel(4, -3.0f, ToolMaterialTiers.OBSIDIAN, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> OBSIDIAN_TREEAXE = ITEMS.register("obsidian_treeaxe", () -> new ModTreeAxe(ToolMaterialTiers.OBSIDIAN, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(ToolMaterialTiers.COPPER, 2, -2.4f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> COPPER_BOW = ITEMS.register("copper_bow", () -> new ModBow((new Item.Properties()).stacksTo(1).tab(EasyEmerald.easy_emerald_group).durability(copperDurability)));
	public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ToolMaterialTiers.COPPER, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(ToolMaterialTiers.COPPER, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(ToolMaterialTiers.COPPER, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(ToolMaterialTiers.COPPER, 0, -2.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> COPPER_EXCAVATOR = ITEMS.register("copper_excavator", () -> new ModExcavator(ToolMaterialTiers.COPPER, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> COPPER_HAMMER = ITEMS.register("copper_hammer", () -> new ModHammer(ToolMaterialTiers.COPPER, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> COPPER_PAXEL = ITEMS.register("copper_paxel", () -> new ModPaxel(4, -3.0f, ToolMaterialTiers.COPPER, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> COPPER_TREEAXE = ITEMS.register("copper_treeaxe", () -> new ModTreeAxe(ToolMaterialTiers.COPPER, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword", () -> new SwordItem(ToolMaterialTiers.AMETHYST, 2, -2.4f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_BOW = ITEMS.register("amethyst_bow", () -> new ModBow((new Item.Properties()).stacksTo(1).tab(EasyEmerald.easy_emerald_group).durability(amethystDurability)));
	public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe", () -> new PickaxeItem(ToolMaterialTiers.AMETHYST, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe", () -> new AxeItem(ToolMaterialTiers.AMETHYST, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel", () -> new ShovelItem(ToolMaterialTiers.AMETHYST, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe", () -> new HoeItem(ToolMaterialTiers.AMETHYST, 0, -2.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_EXCAVATOR = ITEMS.register("amethyst_excavator", () -> new ModExcavator(ToolMaterialTiers.AMETHYST, 0, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_HAMMER = ITEMS.register("amethyst_hammer", () -> new ModHammer(ToolMaterialTiers.AMETHYST, 0, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_PAXEL = ITEMS.register("amethyst_paxel", () -> new ModPaxel(4, -3.0f, ToolMaterialTiers.AMETHYST, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_TREEAXE = ITEMS.register("amethyst_treeaxe", () -> new ModTreeAxe(ToolMaterialTiers.AMETHYST, 4, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> WOODEN_EXCAVATOR = ITEMS.register("wooden_excavator", () -> new ModExcavator(Tiers.WOOD, 1, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer", () -> new ModHammer(Tiers.WOOD, 1, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> WOODEN_PAXEL = ITEMS.register("wooden_paxel", () -> new ModPaxel(1, -2.8f, Tiers.WOOD, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> WOODEN_TREEAXE = ITEMS.register("wooden_treeaxe", () -> new ModTreeAxe(Tiers.WOOD, 6, -3.2f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> IRON_EXCAVATOR = ITEMS.register("iron_excavator", () -> new ModExcavator(Tiers.IRON, 1, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer", () -> new ModHammer(Tiers.IRON, 1, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> IRON_PAXEL = ITEMS.register("iron_paxel", () -> new ModPaxel(1, -2.8f, Tiers.IRON, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> IRON_TREEAXE = ITEMS.register("iron_treeaxe", () -> new ModTreeAxe(Tiers.IRON, 6, -3.1f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> GOLD_EXCAVATOR = ITEMS.register("gold_excavator", () -> new ModExcavator(Tiers.GOLD, 1, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> GOLD_HAMMER = ITEMS.register("gold_hammer", () -> new ModHammer(Tiers.GOLD, 1, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> GOLD_PAXEL = ITEMS.register("gold_paxel", () -> new ModPaxel(1, -2.8f, Tiers.GOLD, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> GOLD_TREEAXE = ITEMS.register("gold_treeaxe", () -> new ModTreeAxe(Tiers.GOLD, 6, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> DIAMOND_EXCAVATOR = ITEMS.register("diamond_excavator", () -> new ModExcavator(Tiers.DIAMOND, 1, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () -> new ModHammer(Tiers.DIAMOND, 1, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> DIAMOND_PAXEL = ITEMS.register("diamond_paxel", () -> new ModPaxel(1, -2.8f, Tiers.DIAMOND, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> DIAMOND_TREEAXE = ITEMS.register("diamond_treeaxe", () -> new ModTreeAxe(Tiers.DIAMOND, 5, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> NETHERITE_EXCAVATOR = ITEMS.register("netherite_excavator", () -> new ModExcavator(Tiers.NETHERITE, 1, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer", () -> new ModHammer(Tiers.NETHERITE, 1, -2.8f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> NETHERITE_PAXEL = ITEMS.register("netherite_paxel", () -> new ModPaxel(1, -2.8f, Tiers.NETHERITE, null, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> NETHERITE_TREEAXE = ITEMS.register("netherite_treeaxe", () -> new ModTreeAxe(Tiers.NETHERITE, 5, -3.0f, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

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

	public static final RegistryObject<Item> ARMOR_COPPER_HEAD = ITEMS.register("copper_head", () -> new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_COPPER_BODY = ITEMS.register("copper_body", () -> new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> ARMOR_AMETHYST_HEAD = ITEMS.register("amethyst_head", () -> new ArmorItem(AMETHYST_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_AMETHYST_BODY = ITEMS.register("amethyst_body", () -> new ArmorItem(AMETHYST_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings", () -> new ArmorItem(AMETHYST_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> ARMOR_AMETHYST_BOOTS = ITEMS.register("amethyst_boots", () -> new ArmorItem(AMETHYST_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> EMERALD_POTATO = ITEMS.register("emerald_potato", () -> new EmeraldPotato(new Item.Properties().food(FoodList.emerald_potato).tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_POTATO = ITEMS.register("ruby_potato", () -> new RubyPotato(new Item.Properties().food(FoodList.ruby_potato).tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_POTATO = ITEMS.register("amethyst_potato", () -> new AmethystPotato(new Item.Properties().food(FoodList.amethyst_potato).tab(EasyEmerald.easy_emerald_group)));

	public static final RegistryObject<Item> EMERALD_JUJU = ITEMS.register("emerald_juju", () -> new EmeraldJuju(new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> RUBY_JUJU = ITEMS.register("ruby_juju", () -> new RubyJuju(new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
	public static final RegistryObject<Item> AMETHYST_JUJU = ITEMS.register("amethyst_juju", () -> new AmethystJuju(new Item.Properties().tab(EasyEmerald.easy_emerald_group)));
}
