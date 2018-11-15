package nl.steenbrink.kaasmod.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

public class BlockOre extends BlockBasic {

    private String oreName;

    public BlockOre(String name, String oreName) {
        super(Material.ROCK, name);

        setHardness(3f);
        setResistance(5f);
    }

    public void initOreDict(){
        OreDictionary.registerOre(oreName, this);
    }

}
