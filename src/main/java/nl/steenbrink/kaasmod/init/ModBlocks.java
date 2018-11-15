package nl.steenbrink.kaasmod.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import nl.steenbrink.kaasmod.block.BlockBasic;
import nl.steenbrink.kaasmod.block.BlockCheese;
import nl.steenbrink.kaasmod.block.BlockOre;
import nl.steenbrink.kaasmod.util.Names;

public class ModBlocks {

    //basic blocks & ores
    public static BlockOre saltOre = new BlockOre(Names.Blocks.SALT_ORE, Names.OreDict.SALT_ORE_ORENAME);
    public static BlockBasic cheeseBricks = new BlockBasic(Material.ROCK, Names.Blocks.CHEESE_BRICKS);
    public static BlockBasic smoothCheese = new BlockBasic(Material.ROCK, Names.Blocks.SMOOTH_CHEESE);
    public static BlockCheese cheese = new BlockCheese(Names.Blocks.CHEESE, false);
    public static BlockCheese youngCheese = new BlockCheese(Names.Blocks.YOUNG_CHEESE, true);


    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                saltOre,
                cheeseBricks,
                smoothCheese,
                cheese,
                youngCheese
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                saltOre.createItemBlock(),
                cheeseBricks.createItemBlock(),
                smoothCheese.createItemBlock(),
                cheese.createItemBlock(),
                youngCheese.createItemBlock()
        );
    }

    public static void registerModels() {
        saltOre.registerItemModel(Item.getItemFromBlock(saltOre));
        cheeseBricks.registerItemModel(Item.getItemFromBlock(cheeseBricks));
        smoothCheese.registerItemModel(Item.getItemFromBlock(smoothCheese));
        cheese.registerItemModel(Item.getItemFromBlock(cheese));
        youngCheese.registerItemModel(Item.getItemFromBlock(youngCheese));
    }
}
