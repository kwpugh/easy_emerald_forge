package com.kwpugh.easy_emerald.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class GeneralModConfig
{ 
	public static ForgeConfigSpec.IntValue DURABILITY_MULTIPLIER;
	public static ForgeConfigSpec.IntValue ATTACK_DAMAGE_ADDITION;
	public static ForgeConfigSpec.IntValue TOOL_EFFICIENCY;
	public static ForgeConfigSpec.IntValue ARMOR_DURABILITY_ADDITION;
	
    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER)
    {          	
        SERVER_BUILDER.comment("Tool Settings").push("tool_settings");

        DURABILITY_MULTIPLIER = SERVER_BUILDER.comment("Durability multiplier [1-40, default: 7]").defineInRange("durabilityMultiplier", 7, 0, 40);
        ATTACK_DAMAGE_ADDITION = SERVER_BUILDER.comment("Attack damage addtion [1-40, default: 3]").defineInRange("attackDamageAddition", 3, 0, 40);
        TOOL_EFFICIENCY = SERVER_BUILDER.comment("Tool efficiency [1-16, default: 7]").defineInRange("toolEfficiency", 7, 0, 16);
        ARMOR_DURABILITY_ADDITION = SERVER_BUILDER.comment("Armor durability addition [1-50, default: 25]").defineInRange("armorDurabilityAddition", 25, 0, 50);
        
        SERVER_BUILDER.pop();
    }
}