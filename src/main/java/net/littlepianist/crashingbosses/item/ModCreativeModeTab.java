package net.littlepianist.crashingbosses.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CRASHING_BOSSES_TAB = new CreativeModeTab("crashing_bossestab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FIREY_INGOT.get());
        }
    };
}
