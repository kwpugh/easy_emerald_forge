package com.kwpugh.easy_emerald.items.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;

public class EmeraldPotato extends Item
{
	public EmeraldPotato(Properties properties)
	{
		super(properties);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving)
	{
		Player player = (Player) (entityLiving);
		
		ItemStack itemstack = super.finishUsingItem(stack, worldIn, entityLiving);

		player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false));
		player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1, false, false));
		player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 300, 1, false, false));

		return itemstack;
	}	   

	public UseAnim getUseAnimation(ItemStack stack)
	{
		return UseAnim.EAT;
	}
	
}