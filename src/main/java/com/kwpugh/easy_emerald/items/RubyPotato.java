package com.kwpugh.easy_emerald.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class RubyPotato extends Item
{
	public RubyPotato(Properties properties)
	{
		super(properties);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving)
	{
		Player player = (Player) (entityLiving);
		
		ItemStack itemstack = super.finishUsingItem(stack, worldIn, entityLiving);

		player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 1, false, false));
		player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 1, false, false));
		player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0, false, false));

		return itemstack;
	}	   

	public UseAnim getUseAnimation(ItemStack stack)
	{
		return UseAnim.EAT;
	}
	
}