package nl.steenbrink.kaasmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){
        //smelting
        GameRegistry.addSmelting(ModItems.cheeseSlice, new ItemStack(ModItems.cheeseBrick), 0.7f);

        //oredict
        ModBlocks.saltOre.initOreDict();
        ModItems.cleanSalt.initOreDict();
    }
}
