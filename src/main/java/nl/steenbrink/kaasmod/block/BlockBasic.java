package nl.steenbrink.kaasmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import nl.steenbrink.kaasmod.Kaasmod;
import nl.steenbrink.kaasmod.util.Names;

public class BlockBasic extends Block {
    protected String name;

    public BlockBasic(Material material, String name){
        super(material);
        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Kaasmod.creativeTab);
    }

    public void registerItemModel(Item itemBlock) {
        Kaasmod.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock(){
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
