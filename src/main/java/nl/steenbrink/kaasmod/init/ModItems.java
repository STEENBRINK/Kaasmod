package nl.steenbrink.kaasmod.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmorStand;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.registries.IForgeRegistry;
import nl.steenbrink.kaasmod.item.*;
import nl.steenbrink.kaasmod.util.Names;

public class ModItems {

    //register basic items
    public static ItemBasic stomach = new ItemBasic(Names.Items.STOMACH);
    public static ItemOre cleanSalt = new ItemOre(Names.Items.CLEAN_SALT, Names.OreDict.SALT_ITEM_ORENAME);
    public static ItemBasic dirtySalt = new ItemBasic(Names.Items.DIRTY_SALT);
    public static ItemBasic stomachSlice = new ItemBasic(Names.Items.STOMACH_SLICE);
    public static ItemBasic cheeseBrick = new ItemBasic(Names.Items.CHEESE_BRICK);
    public static ItemBasic starter = new ItemBasic(Names.Items.STARTER);

    //register foods
    public static ItemFoodBasic breadSlice = new ItemFoodBasic(Names.Items.BREAD_SLICE, 1, 0.2f, false);
    public static ItemFoodBasic cheeseSlice = new ItemFoodBasic(Names.Items.CHEESE_SLICE, 2, 0.2f, false);
    public static ItemFoodBasic cheeseBaconBread = new ItemFoodBasic(Names.Items.CHEESE_BACON_BREAD, 12, 1.5f, false);
    public static ItemFoodBasic cheeseBread = new ItemFoodBasic(Names.Items.CHEESE_BREAD, 6, 1.4f, false);
    public static ItemFoodBasic tosti = new ItemFoodBasic(Names.Items.TOSTI, 20, 1.8f, false);

    //register buckets
    public static ItemStack curdBucket = FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidCurd, Fluid.BUCKET_VOLUME));
    public static ItemStack curdledMilkBucket = FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidCurdledMilk, Fluid.BUCKET_VOLUME));
    public static ItemStack freshMilkBucket = FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidFreshMilk, Fluid.BUCKET_VOLUME));
    public static ItemStack lacticAcidBucket = FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidLacticAcid, Fluid.BUCKET_VOLUME));
    public static ItemStack rennetBucket = FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidRennet, Fluid.BUCKET_VOLUME));
    public static ItemStack saltWaterBucket = FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidSaltWater, Fluid.BUCKET_VOLUME));
    public static ItemStack vinegarBucket = FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidVinegar, Fluid.BUCKET_VOLUME));

    //register tools
    public static ItemCheeseSlicer cheeseSlicer = new ItemCheeseSlicer();
    public static ItemKnife knife = new ItemKnife();

    public static void register(IForgeRegistry<Item> registry){
        registry.registerAll(
                stomach,
                cleanSalt,
                dirtySalt,
                stomachSlice,
                cheeseBrick,
                starter,
                breadSlice,
                cheeseSlice,
                cheeseBaconBread,
                cheeseBread,
                tosti,
                cheeseSlicer,
                knife
        );
    }
    public static void registerModels(){
        stomach.registerItemModel();
        cleanSalt.registerItemModel();
        dirtySalt.registerItemModel();
        stomachSlice.registerItemModel();
        cheeseBrick.registerItemModel();
        starter.registerItemModel();
        breadSlice.registerItemModel();
        cheeseSlice.registerItemModel();
        cheeseBaconBread.registerItemModel();
        cheeseBread.registerItemModel();
        tosti.registerItemModel();
        cheeseSlicer.registerItemModel();
        knife.registerItemModel();
    }
}
