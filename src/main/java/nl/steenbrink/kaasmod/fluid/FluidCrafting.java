package nl.steenbrink.kaasmod.fluid;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import nl.steenbrink.kaasmod.init.ModFluids;
import nl.steenbrink.kaasmod.util.Reference;

public class FluidCrafting extends Fluid {
    public FluidCrafting(String fluidName) {
        super(fluidName, new ResourceLocation(Reference.PATH_FLUIDS), new ResourceLocation(Reference.PATH_FLUIDS));
    }

    public static ResourceLocation getResourcelocations(FluidStack stack) {
        NBTTagCompound nbtTagCompound = stack.tag;
        if (nbtTagCompound.hasKey("FluidPrimary")) {
            FluidStack primaryFluid = FluidStack.loadFluidStackFromNBT(nbtTagCompound.getCompoundTag("FluidPrimary"));
            if (primaryFluid == null) return null;
            return primaryFluid.getFluid().getStill(primaryFluid);
        }
        return null;
    }

    public static FluidStack createCraftingFluid(FluidStack primaryFluid, FluidStack secondaryFluid) {
        FluidStack outputFluid = new FluidStack(ModFluids.fluidCrafting, primaryFluid.amount);
        outputFluid.tag = new NBTTagCompound();

        NBTTagCompound primaryFluidTagCompound = new NBTTagCompound();
        primaryFluid.writeToNBT(primaryFluidTagCompound);
        outputFluid.tag.setTag("FluidPrimary", primaryFluidTagCompound);

        NBTTagCompound secondaryFluidTagCompound = new NBTTagCompound();
        secondaryFluid.writeToNBT(secondaryFluidTagCompound);
        outputFluid.tag.setTag("FluidSecondary", secondaryFluidTagCompound);

        return outputFluid;
    }

    public static boolean compareCraftingFluid(FluidStack fluidStackA, FluidStack fluidStackB, boolean precise) {
        if (fluidStackA.getFluid() != ModFluids.fluidCrafting || fluidStackB.getFluid() != ModFluids.fluidCrafting) return false;

        FluidStack primaryFluidA = FluidStack.loadFluidStackFromNBT(fluidStackA.tag.getCompoundTag("FluidPrimary"));
        FluidStack secondaryFluidA = FluidStack.loadFluidStackFromNBT(fluidStackA.tag.getCompoundTag("FluidSecondary"));
        FluidStack primaryFluidB = FluidStack.loadFluidStackFromNBT(fluidStackB.tag.getCompoundTag("FluidPrimary"));
        FluidStack secondaryFluidB = FluidStack.loadFluidStackFromNBT(fluidStackB.tag.getCompoundTag("FluidSecondary"));

        if (primaryFluidA == null || secondaryFluidA == null || primaryFluidB == null || secondaryFluidB == null) return false;
        if (primaryFluidA.getFluid() != primaryFluidB.getFluid()) return false;
        if (secondaryFluidA.getFluid() != secondaryFluidB.getFluid()) return false;
        if (!precise) return true;

        if (primaryFluidA.amount != primaryFluidB.amount) return false;
        if (primaryFluidA.tag != null || primaryFluidB.tag != null) {
            if (!(primaryFluidA.tag != null && primaryFluidB.tag != null)) return false;
            if (!primaryFluidA.tag.equals(primaryFluidB.tag)) return false;
        }

        if (secondaryFluidA.amount != secondaryFluidB.amount) return false;
        if (secondaryFluidA.tag != null || secondaryFluidB.tag != null) {
            if (!(secondaryFluidA.tag != null && secondaryFluidB.tag != null)) return false;
            if (!secondaryFluidA.tag.equals(secondaryFluidB.tag)) return false;
        }

        return true;
    }
}