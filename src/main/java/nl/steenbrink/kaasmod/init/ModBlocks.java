package nl.steenbrink.kaasmod.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import nl.steenbrink.kaasmod.block.BlockBasic;
import nl.steenbrink.kaasmod.block.BlockBasicStairs;
import nl.steenbrink.kaasmod.block.BlockCheese;
import nl.steenbrink.kaasmod.block.BlockOre;
import nl.steenbrink.kaasmod.block.fluid.*;
import nl.steenbrink.kaasmod.block.tile.BlockToaster;
import nl.steenbrink.kaasmod.util.Names;

public class ModBlocks {

    //basic blocks & ores
    public static BlockOre saltOre = new BlockOre(Names.Blocks.SALT_ORE, Names.OreDict.SALT_ORE_ORENAME);
    public static BlockBasic cheeseBricks = new BlockBasic(Material.ROCK, Names.Blocks.CHEESE_BRICKS);
    public static BlockBasic smoothCheese = new BlockBasic(Material.ROCK, Names.Blocks.SMOOTH_CHEESE);
    public static BlockCheese cheese = new BlockCheese(Names.Blocks.CHEESE, false);
    public static BlockCheese youngCheese = new BlockCheese(Names.Blocks.YOUNG_CHEESE, true);

    //fluidblocks
    public static final BlockFluidBasic blockCurd = new BlockFluidBasic(ModFluids.fluidCurd, 1600);
    public static final BlockFluidBasic blockCurdledMilk = new BlockFluidBasic(ModFluids.fluidCurdledMilk);
    public static final BlockFluidBasic blockLacticAcid = new BlockFluidBasic(ModFluids.fluidLacticAcid);
    public static final BlockFluidBasic blockFreshMilk = new BlockFluidBasic(ModFluids.fluidFreshMilk);
    public static final BlockFluidBasic blockRennet = new BlockFluidBasic(ModFluids.fluidRennet);
    public static final BlockFluidBasic blockSaltWater = new BlockFluidBasic(ModFluids.fluidSaltWater);
    public static final BlockFluidBasic blockVinegar = new BlockFluidBasic(ModFluids.fluidVinegar);

    //stairs
    //public static final BlockBasicStairs cheeseBrickStairs = new BlockBasicStairs(cheeseBricks.getDefaultState());

    //tileentities
    public static BlockToaster toaster = new BlockToaster();

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                saltOre,
                cheeseBricks,
                smoothCheese,
                cheese,
                youngCheese,
                blockCurd,
                blockCurdledMilk,
                blockRennet,
                blockLacticAcid,
                blockVinegar,
                blockFreshMilk,
                blockSaltWater,
                //cheeseBrickStairs,
                toaster
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                saltOre.createItemBlock(),
                cheeseBricks.createItemBlock(),
                smoothCheese.createItemBlock(),
                cheese.createItemBlock(),
                youngCheese.createItemBlock(),
                blockCurd.createItemBlock(),
                blockCurdledMilk.createItemBlock(),
                blockRennet.createItemBlock(),
                blockLacticAcid.createItemBlock(),
                blockVinegar.createItemBlock(),
                blockFreshMilk.createItemBlock(),
                blockSaltWater.createItemBlock(),
                //cheeseBrickStairs.createItemBlock(),
                toaster.createItemBlock()
        );
    }

    public static void registerModels() {
        saltOre.registerItemModel(Item.getItemFromBlock(saltOre));
        cheeseBricks.registerItemModel(Item.getItemFromBlock(cheeseBricks));
        smoothCheese.registerItemModel(Item.getItemFromBlock(smoothCheese));
        cheese.registerItemModel(Item.getItemFromBlock(cheese));
        youngCheese.registerItemModel(Item.getItemFromBlock(youngCheese));
        blockCurd.registerItemModel(Item.getItemFromBlock(blockCurd));
        blockCurdledMilk.registerItemModel(Item.getItemFromBlock(blockCurdledMilk));
        blockRennet.registerItemModel(Item.getItemFromBlock(blockCurdledMilk));
        blockLacticAcid.registerItemModel(Item.getItemFromBlock(blockLacticAcid));
        blockVinegar.registerItemModel(Item.getItemFromBlock(blockVinegar));
        blockFreshMilk.registerItemModel(Item.getItemFromBlock(blockFreshMilk));
        blockSaltWater.registerItemModel(Item.getItemFromBlock(blockSaltWater));
        //cheeseBrickStairs.registerItemModel(Item.getItemFromBlock(cheeseBrickStairs));
        toaster.registerItemModel(Item.getItemFromBlock(toaster));
    }

    public static void render(){
        blockCurd.render();
        blockCurdledMilk.render();
        blockLacticAcid.render();
        blockFreshMilk.render();
        blockRennet.render();
        blockSaltWater.render();
        blockVinegar.render();
    }
}
