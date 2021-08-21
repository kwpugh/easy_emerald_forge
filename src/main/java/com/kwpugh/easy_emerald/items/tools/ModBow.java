package com.kwpugh.easy_emerald.items.tools;

import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;

public class ModBow extends BowItem
{
    Random random = new Random();

    public ModBow(Item.Properties builder)
    {
        super(builder);
    }

    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft)
    {
        if (entityLiving instanceof Player)
        {
            Player playerentity = (Player)entityLiving;
            boolean flag = playerentity.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
            ItemStack itemstack = playerentity.getProjectile(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, !itemstack.isEmpty() || flag);

            if (i < 0) return;

            if (!itemstack.isEmpty() || flag)
            {
                if (itemstack.isEmpty())
                {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getArrowVelocity(i);
                if (!((double)f < 0.1D))
                {
                    boolean flag1 = playerentity.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
                    if (!worldIn.isClientSide)
                    {
                        ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrow abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
                        abstractarrowentity = customeArrow(abstractarrowentity);
                        abstractarrowentity.shootFromRotation(playerentity, playerentity.xRotO, playerentity.yRotO, 0.0F, f * 4.5F, 1.0F);
                        if (f == 1.0F)
                        {
                            abstractarrowentity.setCritArrow(true);
                        }

                        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
                        if (j > 0)
                        {
                            abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + (double)j * 0.75D + 0.75D);
                        }

                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
                        if (k > 0)
                        {
                            abstractarrowentity.setKnockback(k);
                        }

                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0)
                        {
                            abstractarrowentity.setSecondsOnFire(100);
                        }

                        stack.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
                        });
                        if (flag1 || playerentity.getAbilities().instabuild && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW))
                        {
                            abstractarrowentity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        worldIn.addFreshEntity(abstractarrowentity);
                    }

                    worldIn.playSound((Player)null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !playerentity.getAbilities().instabuild)
                    {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty())
                        {
                            playerentity.getInventory().removeItem(itemstack);
                        }
                    }

                    playerentity.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getArrowVelocity(int charge)
    {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F)
        {
            f = 1.0F;
        }

        return f;
    }

    public int getUseDuration(ItemStack stack)
    {
        return 54000;
    }

    public UseAnim getUseAnimation(ItemStack stack)
    {
        return UseAnim.BOW;
    }

    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn)
    {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        boolean flag = !playerIn.getProjectile(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
        if (ret != null) return ret;

        if (!playerIn.getAbilities().instabuild && !flag)
        {
            return InteractionResultHolder.fail(itemstack);
        }
        else
        {
            playerIn.startUsingItem(handIn);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public AbstractArrow customeArrow(AbstractArrow arrow) {
        return arrow;
    }
}