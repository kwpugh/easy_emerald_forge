package com.kwpugh.easy_emerald.items.tools.base;

import com.google.common.collect.ImmutableSet;
import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.items.tools.util.HammerUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
 * This is the base class for all types of Hammers
 * 
 */

public class HammerBase extends PickaxeItem
{
	int blocksBroken = 0;

	public static final Set<BlockBehaviour.Properties> EFFECTIVE_MATERIALS =
			ImmutableSet.of(
					BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM), // STONE
					BlockBehaviour.Properties.of().mapColor(MapColor.METAL), // METAL
					BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT), // GLASS
					BlockBehaviour.Properties.of().mapColor(MapColor.ICE), // ICE, ICE_SOLID
					BlockBehaviour.Properties.of().mapColor(MapColor.METAL).pushReaction(PushReaction.BLOCK) // HEAVY_METAL
			);

	public HammerBase(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity)
	{
		stack.hurt(1, world.random, null);

		if(entity instanceof Player player)
		{
			Block block = state.getBlock();
			boolean isWithinHarvestLevel = player.getMainHandItem().isCorrectToolForDrops(state);  //added to ensure each block in the breaking is harvestable with this tool material
			boolean isHarvestable = block.canHarvestBlock(state, world, pos, player);  // added in case a block overrides canHarvestBlock to false at block level

			if(isHarvestable && isWithinHarvestLevel)
			{
				blocksBroken = HammerUtil.attemptBreakNeighbors(world, pos, player, EFFECTIVE_MATERIALS);

				if(GeneralModConfig.FULL_DAMAGE.get())
				{
					stack.hurtAndBreak(blocksBroken, player, (e) -> {
						e.broadcastBreakEvent(EquipmentSlot.MAINHAND);
					});
				}
			}
		}

		return super.mineBlock(stack, world, state, pos, entity);
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
		tooltip.add((Component.translatable("item.easy_emerald.hammer.tip1").withStyle(ChatFormatting.GREEN)));
	}
}
