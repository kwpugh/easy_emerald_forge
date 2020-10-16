package com.kwpugh.easy_emerald.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class EmeraldPotato extends Item
{
	public EmeraldPotato(Properties properties)
	{
		super(properties);
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
	{
		PlayerEntity player = (PlayerEntity) (entityLiving);
		
		ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);

		player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 300, 0, false, false));
		player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 300, 1, false, false));
		player.addPotionEffect(new EffectInstance(Effects.SATURATION, 300, 1, false, false));

		return itemstack;
	}	   

	public UseAction getUseAction(ItemStack stack)
	{
		return UseAction.EAT;
	}
	
}