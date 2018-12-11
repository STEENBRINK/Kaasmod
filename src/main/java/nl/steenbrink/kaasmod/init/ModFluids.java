package nl.steenbrink.kaasmod.init;

import net.minecraftforge.fluids.FluidRegistry;
import nl.steenbrink.kaasmod.fluid.FluidBasic;
import nl.steenbrink.kaasmod.fluid.FluidCrafting;
import nl.steenbrink.kaasmod.util.Names;

public class ModFluids {
    public static FluidBasic fluidSaltWater = new FluidBasic(Names.Fluids.SALT_WATER);
    public static FluidBasic fluidFreshMilk = new FluidBasic(Names.Fluids.FRESH_MILK);
    public static FluidBasic fluidVinegar = new FluidBasic(Names.Fluids.VINEGAR);
    public static FluidBasic fluidLacticAcid = new FluidBasic(Names.Fluids.LACTIC_ACID);
    public static FluidBasic fluidRennet = new FluidBasic(Names.Fluids.RENNET);
    public static FluidBasic fluidCurdledMilk = new FluidBasic(Names.Fluids.CURDLED_MILK);
    public static FluidBasic fluidCurd = new FluidBasic(Names.Fluids.CURD);
    public static FluidCrafting fluidCrafting = new FluidCrafting(Names.Fluids.CRAFTING_FLUID);

    public static void init() {
        FluidRegistry.registerFluid(fluidRennet);
        FluidRegistry.registerFluid(fluidFreshMilk);
        FluidRegistry.registerFluid(fluidVinegar);
        FluidRegistry.registerFluid(fluidLacticAcid);
        FluidRegistry.registerFluid(fluidSaltWater);
        FluidRegistry.registerFluid(fluidCurdledMilk);
        FluidRegistry.registerFluid(fluidCurd);
        FluidRegistry.registerFluid(fluidCrafting);
    }
}


