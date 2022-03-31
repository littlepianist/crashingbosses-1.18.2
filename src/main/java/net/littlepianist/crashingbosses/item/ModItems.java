package net.littlepianist.crashingbosses.item;

import net.littlepianist.crashingbosses.CrashingBosses;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CrashingBosses.MOD_ID);

    public static final RegistryObject<Item> FIREY_INGOT = ITEMS.register("firey_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CRASHING_BOSSES_TAB)));

    public static final RegistryObject<Item> FIREY_NUGGET = ITEMS.register("firey_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CRASHING_BOSSES_TAB)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
