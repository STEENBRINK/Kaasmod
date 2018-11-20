package nl.steenbrink.kaasmod.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.UniversalBucket;
import nl.steenbrink.kaasmod.init.ModFluids;
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
        itemStacks.add(FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidCurd, Fluid.BUCKET_VOLUME)));
        itemStacks.add(FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidCurdledMilk, Fluid.BUCKET_VOLUME)));
        itemStacks.add(FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidRennet, Fluid.BUCKET_VOLUME)));
        itemStacks.add(FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidLacticAcid, Fluid.BUCKET_VOLUME)));
        itemStacks.add(FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidVinegar, Fluid.BUCKET_VOLUME)));
        itemStacks.add(FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidSaltWater, Fluid.BUCKET_VOLUME)));
        super.displayAllRelevantItems(itemStacks);
    }
}
