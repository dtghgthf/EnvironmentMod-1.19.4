package net.dtghgthf.environmentmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab ENVORONMENT_MOD_TAB = new CreativeModeTab("environmentmodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.KNOWLEDGE_BOOK);
        }
    };
}
