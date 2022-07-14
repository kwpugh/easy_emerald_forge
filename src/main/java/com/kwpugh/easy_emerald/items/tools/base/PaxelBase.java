package com.kwpugh.easy_emerald.items.tools.base;

import com.kwpugh.easy_emerald.init.TagInit;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

/*
 * This is the base class for all types of Paxels
 *
 */
public class PaxelBase extends DiggerItem
{
    public PaxelBase(float attackDamageIn, float attackSpeedIn, Tier tier, TagKey<Block> mineable, Properties builder)
    {
        super(attackDamageIn, attackSpeedIn, tier, TagInit.PAXEL_MINEABLE, builder);
    }

    /*
        Code adapted from vanilla
        ShovelItem and AxeItem
        and combined

        Should with both vanilla and properly
        coded modded logs and paths
     */
    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        // Log-stripping logic
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(context, ToolActions.AXE_STRIP, false));
        Optional<BlockState> optional1 = Optional.ofNullable(blockstate.getToolModifiedState(context, ToolActions.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = Optional.ofNullable(blockstate.getToolModifiedState(context, ToolActions.AXE_WAX_OFF, false));
        ItemStack itemstack = context.getItemInHand();
        Optional<BlockState> optional3 = Optional.empty();
        if (optional.isPresent())
        {
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            optional3 = optional;
        }
        else if (optional1.isPresent())
        {
            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3005, blockpos, 0);
            optional3 = optional1;
        }
        else if (optional2.isPresent())
        {
            level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3004, blockpos, 0);
            optional3 = optional2;
        }

        if (optional3.isPresent())
        {
            if (player instanceof ServerPlayer)
            {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
            }

            level.setBlock(blockpos, optional3.get(), 11);

            if (player != null)
            {
                itemstack.hurtAndBreak(1, player, (p_150686_) -> {
                    p_150686_.broadcastBreakEvent(context.getHand());
                });
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        else
        {
            // shovel logic
            if (context.getClickedFace() == Direction.DOWN)
            {
                return InteractionResult.PASS;
            }
            else
            {
                BlockState blockstate1 = blockstate.getToolModifiedState(context, ToolActions.SHOVEL_FLATTEN, false);
                BlockState blockstate2 = null;
                if (blockstate1 != null && level.isEmptyBlock(blockpos.above()))
                {
                    level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                    blockstate2 = blockstate1;
                }
                else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT))
                {
                    if (!level.isClientSide())
                    {
                        level.levelEvent((Player)null, 1009, blockpos, 0);
                    }

                    CampfireBlock.dowse(context.getPlayer(), level, blockpos, blockstate);
                    blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
                }

                if (blockstate2 != null)
                {
                    if (!level.isClientSide)
                    {
                        level.setBlock(blockpos, blockstate2, 11);
                        if (player != null)
                        {
                            context.getItemInHand().hurtAndBreak(1, player, (p_43122_) ->
                            {
                                p_43122_.broadcastBreakEvent(context.getHand());
                            });
                        }
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state)
    {
        if (state.is(BlockTags.MINEABLE_WITH_AXE)) return speed;
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) return speed;
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) return speed;
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction)
    {
        boolean actionTest = false;
        if(ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) ||
                ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction))
        {
            actionTest = true;
        }

        return actionTest;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book)
    {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add((Component.translatable("item.easy_emerald.paxel.tip1").withStyle(ChatFormatting.GREEN)));
    }
}