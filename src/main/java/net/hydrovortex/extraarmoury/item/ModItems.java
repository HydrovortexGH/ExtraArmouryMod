package net.hydrovortex.extraarmoury.item;

import net.hydrovortex.extraarmoury.ExtraArmoury;
import net.hydrovortex.extraarmoury.item.custom.MaletItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExtraArmoury.MOD_ID);

    public static final RegistryObject<Item> ROSEGOLDINGOT = ITEMS.register("rosegold_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROSEGOLDUPGRADE = ITEMS.register("rosegold_upgrade_template",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUPERIORINGOT = ITEMS.register("superior_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMONDBASE = ITEMS.register("diamond_base",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNREFINEDSUPERIORINGOT = ITEMS.register("unrefined_superior_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BASICBLUEPRINT = ITEMS.register("basic_blueprint",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BASICINGOTBLURPRINT = ITEMS.register("basic_ingot_blueprint",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROSEGOLDMALET = ITEMS.register("rosegold_malet",
            () -> new MaletItem(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> SAPHIRE = ITEMS.register("saphire",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
