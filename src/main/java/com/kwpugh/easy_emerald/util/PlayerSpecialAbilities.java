package com.kwpugh.easy_emerald.util;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerSpecialAbilities
{	
	//Set player health to max on tick update
	public static void giveHealthEffect(Level world, Player player, ItemStack itemstack)
	{
    	player.setHealth(20);
		return;
	}
	
	//Increases the player's food level to max on tick update, based on inputs
	public static void giveRegenffect(Level world, Player player, ItemStack itemstack, int newfoodlevel, float newsatlevel)
	{
		player.getFoodData().eat(newfoodlevel, newsatlevel);
    	return;
	}
		
	//Set player saturation level to max on tick update
	public static void giveSaturationEffect(Level world, Player player, ItemStack itemstack)
	{
		player.getFoodData().setSaturation(7.0F);
    	return;
	}
		
	//Slower increase of yellow hearts on tick update
	public static void giveExtraHearts(Level world, LivingEntity player, ItemStack itemstack)
	{
		float current = player.getAbsorptionAmount();
		
		if(player.getHealth() < 20 || current >= 10)
		{
			return;
		}
		
		if(current >= 9)
		{
			if (player.tickCount % 180 == 0)
			{
				player.setAbsorptionAmount(10);
			} 
			return;
		}
		if(current < 9)
		{
			if (player.tickCount % 180 == 0)
			{
				player.setAbsorptionAmount(current + 0.33F);
			} 
			return;
		}
		
    	return;
	}

	//Faster increase of yellow hearts on tick update
	public static void giveGreaterExtraHearts(Level world, LivingEntity player, ItemStack itemstack)
	{
		float current = player.getAbsorptionAmount();
		
		if(player.getHealth() < 20 || current >= 20)
		{
			return;
		}
		
		if(current >= 19)
		{
			if (player.tickCount % 180 == 0)
			{
				player.setAbsorptionAmount(20);
			} 
			return;
		}
		if(current < 19)
		{
			if (player.tickCount % 180 == 0)
			{
				player.setAbsorptionAmount(current + 1.0F);
			} 
			return;
		}
		
    	return;
	}
	
	//Set player yellow hearts to none on tick update
	public static void giveNoExtraHearts(Level world, Player player, ItemStack itemstack)
	{
		player.setAbsorptionAmount(0);
    	return;
	}
	
	//	//Set player oxygen to max on tick update
	public static void giveBreathing(Level world, Player player, ItemStack itemstack)
	{
		player.setAirSupply(300);
    	return;
	}

	//Gives player Conduit Effect
	public static void giveDolphinEffect(Level world, Player player, ItemStack itemstack)
	{
		if (player.tickCount % 180 == 0 && player.isInWater())
		{
			player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 260, 0, false, false));
		} 
	}
	
	//Gives player Conduit Effect
	public static void giveConduitEffect(Level world, Player player, ItemStack itemstack)
	{
		if (player.tickCount % 180 == 0 && player.isInWater())
		{
			player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 260, 2, false, false));
		} 
	}
}
