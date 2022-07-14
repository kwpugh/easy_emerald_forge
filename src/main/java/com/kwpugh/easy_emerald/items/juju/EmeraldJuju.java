package com.kwpugh.easy_emerald.items.juju;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class EmeraldJuju extends Item
{
	public EmeraldJuju(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected)
	{
		MobEffectInstance effect = new MobEffectInstance(MobEffects.WATER_BREATHING, 8, 0, false, false);
		LivingEntity player = (LivingEntity) entity;
		{
			player.addEffect(effect);
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add((Component.translatable("item.easy_emerald.emerald_juju.line1").withStyle(ChatFormatting.GREEN)));
	}     
}
