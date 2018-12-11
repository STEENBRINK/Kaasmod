package nl.steenbrink.kaasmod.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import nl.steenbrink.kaasmod.init.ModItems;

public class CreativeTab extends CreativeTabs {
    public CreativeTab(){
        super(Reference.MOD_ID);
    }
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.stomach);
    }

    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> itemStacks) {
        super.displayAllRelevantItems(itemStacks);
        itemStacks.add(ModItems.curdBucket);
        itemStacks.add(ModItems.curdledMilkBucket);
        itemStacks.add(ModItems.freshMilkBucket);
        itemStacks.add(ModItems.lacticAcidBucket);
        itemStacks.add(ModItems.rennetBucket);
        itemStacks.add(ModItems.saltWaterBucket);
        itemStacks.add(ModItems.vinegarBucket);
    }
}
