package com.kwpugh.easy_emerald.lists;

import net.minecraft.world.food.FoodProperties;

public class FoodList 
{	
	public static FoodProperties emerald_potato = (new FoodProperties.Builder()).nutrition(7).saturationMod(4).alwaysEat().fast().build();
	public static FoodProperties ruby_potato = (new FoodProperties.Builder()).nutrition(8).saturationMod(4).alwaysEat().fast().build();
	public static FoodProperties amethyst_potato = (new FoodProperties.Builder()).nutrition(9).saturationMod(5).alwaysEat().fast().build();
}
