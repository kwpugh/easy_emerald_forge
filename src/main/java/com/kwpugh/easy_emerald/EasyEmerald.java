package com.kwpugh.easy_emerald;

import java.util.stream.Collectors;

import com.kwpugh.easy_emerald.init.BlockInit;
import com.kwpugh.easy_emerald.init.ItemInit;
import com.kwpugh.easy_emerald.util.GroupEasyEmerald;

import com.kwpugh.easy_emerald.config.EmeraldModConfig;

import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("easy_emerald")
public class EasyEmerald
{
	public static final String modid = "easy_emerald";
	public static final Logger logger = LogManager.getLogger(modid);
	public static final CreativeModeTab easy_emerald_group = new GroupEasyEmerald();

    public EasyEmerald()
    {
    	EmeraldModConfig.loadConfig(EmeraldModConfig.CONFIG, FMLPaths.CONFIGDIR.get().resolve("easy-emerald-general.toml"));
    	BlockInit.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	ItemInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }
     
    private void setup(final FMLCommonSetupEvent event)
    {
        logger.info("EasyEmerald common setup");
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
    	logger.info("EasyEmerald client setup");
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("easy_emerald", "helloworld", () -> { logger.info("Hello world from EasyEmerald"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
    	logger.info("EasyEmerald IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {
    	logger.info("EasyEmerald server setup");
    }
}
