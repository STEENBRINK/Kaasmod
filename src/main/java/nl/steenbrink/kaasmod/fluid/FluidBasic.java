package nl.steenbrink.kaasmod.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import nl.steenbrink.kaasmod.util.Reference;

import java.awt.*;

public class FluidBasic extends Fluid {
    /**
     * Instantiates a new mod fluid.
     *
     * @param fluidName the fluid name
     */

    public FluidBasic(String fluidName) {
        super(fluidName, new ResourceLocation(Reference.MOD_ID, Reference.PATH_FLUIDS + fluidName + "_still"), new ResourceLocation(Reference.MOD_ID, Reference.PATH_FLUIDS + fluidName + "_flow"));
        FluidRegistry.addBucketForFluid(this);
    }
}
