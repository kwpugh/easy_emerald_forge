package com.kwpugh.easy_emerald.util;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.config.GeneralModConfig;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = EasyEmerald.modid, bus = EventBusSubscriber.Bus.FORGE )
public final class ForgeEventSubscriber
{	
	//Protects the player from various forms of damage
    @SubscribeEvent
    public static void onLivingHurtEvent(LivingAttackEvent event)
    {
        if (event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            //Fall Damage
            if ((event.getSource() == DamageSource.FALL) &&
                PlayerEquipUtil.isPlayerGotFallProtection(player))
            {
                if (event.isCancelable()) event.setCanceled(true);
            } 
            
            //Fire & Lava
            if (((event.getSource() == DamageSource.IN_FIRE) ||
            		(event.getSource() == DamageSource.ON_FIRE) || 
            		(event.getSource() == DamageSource.LAVA)) && 
            		PlayerEquipUtil.isPlayerGotFireProtection(player))
            {
                if (event.isCancelable()) event.setCanceled(true);
            }
            
            //Drowning
            if ((event.getSource() == DamageSource.DROWN) &&
                    PlayerEquipUtil.isPlayerGotWaterBreathing(player))
            {
            	if (event.isCancelable()) event.setCanceled(true);
            }
        } 
    }
    
    @SubscribeEvent
    public static void extraLootingEvent(LootingLevelEvent event)
    {    	
    	if (event.getDamageSource().getTrueSource() instanceof PlayerEntity)
        {
    		PlayerEntity playerEntity = (PlayerEntity) event.getDamageSource().getTrueSource();
			
    		if (PlayerEquipUtil.isPlayerGotRubySwordInHand(playerEntity))
            {
                event.setLootingLevel(event.getLootingLevel()+9);
            }
        }
    }
    
    @SubscribeEvent
    public static void onKillingExpDropEvent(LivingExperienceDropEvent event)
    {
    	int killingExp = GeneralModConfig.KILLING_EXP.get();
    	
    	if (event.getAttackingPlayer() instanceof PlayerEntity && event.getEntityLiving()instanceof MobEntity)
    	{
    		PlayerEntity player = (PlayerEntity) event.getAttackingPlayer();
    		
    		if (PlayerEquipUtil.isPlayerGotRubySwordInHand(player))
    		{
    			int orgExp = event.getOriginalExperience();
    			int newExp = orgExp * killingExp;
    			event.setDroppedExperience(newExp);
    		} 
    	}
    }
}
 