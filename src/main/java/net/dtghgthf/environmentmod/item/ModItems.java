package net.dtghgthf.environmentmod.item;

import net.dtghgthf.environmentmod.EnvironmentMod;
import net.dtghgthf.environmentmod.item.custom.EnvironmentInfoItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EnvironmentMod.MOD_ID);

    public static final RegistryObject<Item> EXAMPLE = ITEMS.register("example_item",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ENVORONMENT_MOD_TAB)));

    public static final RegistryObject<Item> ENVIRONMENT_INFO_ITEM = ITEMS.register("environment_info_item",
            () -> new EnvironmentInfoItem(new Item.Properties().tab(ModCreativeModeTab.ENVORONMENT_MOD_TAB).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
