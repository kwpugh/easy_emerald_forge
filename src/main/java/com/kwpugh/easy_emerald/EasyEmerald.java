package com.kwpugh.easy_emerald;

import java.util.Collection;
import java.util.stream.Collectors;

import com.kwpugh.easy_emerald.init.BlockInit;
import com.kwpugh.easy_emerald.init.ItemInit;

import com.kwpugh.easy_emerald.config.EmeraldModConfig;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

@Mod(EasyEmerald.Modid)
public class EasyEmerald
{
	public static final String Modid = "easy_emerald";
	public static final Logger logger = LogManager.getLogger(Modid);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Modid);

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    static final ForgeConfigSpec SPEC = BUILDER.build();

    // Build special CreativeTab for this mod
    public static final RegistryObject<CreativeModeTab> EASY_EMERALD_TAB = CREATIVE_MODE_TABS.register("easy_emerald_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> new ItemStack(Items.EMERALD))
            .displayItems((parameters, output) -> {
                for (var item: ItemInit.ITEMS.getEntries()) {
                    output.accept(item.get());
                }
            }).title(Component.translatable("itemGroup.easy_emerald"))
            .build());

    public EasyEmerald()
    {
        var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	EmeraldModConfig.loadConfig(EmeraldModConfig.CONFIG, FMLPaths.CONFIGDIR.get().resolve("easy-emerald-general.toml"));

    	modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        modEventBus.addListener(this::clientSetup);

        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        //modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC);
    }
     
    private void setup(final FMLCommonSetupEvent event)
    {
        logger.info("EasyEmerald common setup");
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
    	logger.info("EasyEmerald client setup");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.COMBAT){
            //event.accept(ItemInit.EMERALD_SWORD);
            for (var item: ItemInit.ITEMS.getEntries()) {
                event.accept(item);
            }
        }
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("easy_emerald", "hello world", () -> { logger.info("Hello world from EasyEmerald"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
    	logger.info("EasyEmerald IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    	logger.info("EasyEmerald server setup");
    }
}
