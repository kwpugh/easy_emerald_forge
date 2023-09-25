package com.kwpugh.easy_emerald.util.handlers;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.config.GeneralModConfig;

import com.kwpugh.easy_emerald.util.PlayerEquipUtil;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = EasyEmerald.Modid, bus = EventBusSubscriber.Bus.FORGE )
public final class AbilityEventHandler
{
    static boolean enableRubySwordLoot = GeneralModConfig.RUBY_SWORD_PERKS.get();

	//Protects the player from various forms of damage
    @SubscribeEvent
    public static void onLivingHurtEvent(LivingAttackEvent event)
    {
        if (event.getEntity() instanceof Player player)
        {
            //Fall Damage
            if ((event.getSource().is(DamageTypes.FALL)) &&
                PlayerEquipUtil.isPlayerGotFallProtection(player))
            {
                if (event.isCancelable()) event.setCanceled(true);
            }

            //Fire & Lava
            if ((event.getSource().is(DamageTypes.IN_FIRE)) ||
                    (event.getSource().is(DamageTypes.ON_FIRE)) ||
                    (event.getSource().is(DamageTypes.HOT_FLOOR)) ||
                    (event.getSource().is(DamageTypes.LAVA)))
            {
                if(PlayerEquipUtil.isPlayerGotFireProtection(player))
                {
                    if (event.isCancelable()) event.setCanceled(true);
                }
            }
            
            //Drowning
            if ((event.getSource().is(DamageTypes.DROWN)) &&
                    PlayerEquipUtil.isPlayerGotWaterBreathing(player))
            {
            	if (event.isCancelable()) event.setCanceled(true);
            }
        } 
    }

    //Gives extra loot drops when killing a mob
    @SubscribeEvent
    public static void extraLootingEvent(LootingLevelEvent event)
    {
        if(!enableRubySwordLoot) return;

    	if(event.getDamageSource() !=null && event.getDamageSource().getEntity() !=null)
    	{	
			if(event.getEntity() instanceof Mob && event.getDamageSource().getEntity() instanceof Player playerEntity)
			{
                if (PlayerEquipUtil.isPlayerGotRubySwordInHand(playerEntity))
	            {
	                event.setLootingLevel(event.getLootingLevel()+9);
	            }
			
			}
    	} 	
    }
}
 