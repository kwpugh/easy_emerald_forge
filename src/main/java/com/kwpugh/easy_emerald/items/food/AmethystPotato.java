package com.kwpugh.easy_emerald.items.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;

public class AmethystPotato extends Item
{
    public AmethystPotato(Properties properties)
    {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving)
    {
        Player player = (Player) (entityLiving);

        ItemStack itemstack = super.finishUsingItem(stack, worldIn, entityLiving);

        player.addEffect(new MobEffectInstance(MobEffects.LUCK, 600, 4, false, false));

        return itemstack;
    }

    public UseAnim getUseAnimation(ItemStack stack)
    {
        return UseAnim.EAT;
    }

}