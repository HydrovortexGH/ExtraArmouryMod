package net.hydrovortex.extraarmoury;

import com.mojang.logging.LogUtils;
import net.hydrovortex.extraarmoury.block.ModBlocks;
import net.hydrovortex.extraarmoury.item.ModItems;
import net.hydrovortex.extraarmoury.item.ModeCreativeModeTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExtraArmoury.MOD_ID)
public class ExtraArmoury
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "extraarmoury";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();



    public ExtraArmoury()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModeCreativeModeTabs.register(modEventBus);


        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.ROSEGOLDINGOT);
            event.accept(ModItems.SUPERIORINGOT);
            event.accept(ModItems.ROSEGOLDUPGRADE);
            event.accept(ModItems.DIAMONDBASE);
            event.accept(ModItems.UNREFINEDSUPERIORINGOT);
            event.accept(ModItems.BASICBLUEPRINT);
            event.accept(ModItems.BASICINGOTBLURPRINT);
            event.accept(ModItems.SAPHIRE);

        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.Rosegold_Block);
            event.accept(ModBlocks.Superior_Block);
            event.accept(ModBlocks.Unrefined_Superior_Block);
            event.accept(ModBlocks.Saphire_Block);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.ROSEGOLDMALET);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
