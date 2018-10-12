package nl.steenbrink.kaasmod.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import nl.steenbrink.kaasmod.item.ModItems;

public class CreativeTab extends CreativeTabs {
    public CreativeTab(){
        super(Reference.MOD_ID);
    }
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.stomach);
    }
}
