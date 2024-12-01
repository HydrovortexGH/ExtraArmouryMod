package net.hydrovortex.extraarmoury.item;

import net.hydrovortex.extraarmoury.ExtraArmoury;
import net.hydrovortex.extraarmoury.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModeCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExtraArmoury.MOD_ID);


    public static final RegistryObject<CreativeModeTab> EXTRA_ARMOURY_TAB = CREATIVE_MODE_TABS.register("extra_armoury_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.Rosegold_Block.get()))
                    .title(Component.translatable("creativetab.extraarmoury.extra_armoury_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ROSEGOLDINGOT.get());
                        output.accept(ModBlocks.Rosegold_Block.get());
                        output.accept(ModItems.ROSEGOLDUPGRADE.get());
                        output.accept(ModItems.SUPERIORINGOT.get());
                        output.accept(ModBlocks.Superior_Block.get());
                    }).build());

    public static void register (IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
