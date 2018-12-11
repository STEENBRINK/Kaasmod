package nl.steenbrink.kaasmod.block;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import nl.steenbrink.kaasmod.Kaasmod;

public class BlockBasicStairs extends BlockStairs {

    private IBlockState state;

    public BlockBasicStairs(IBlockState modelState) {
        super(modelState);
        this.state = modelState;

        setUnlocalizedName(modelState.getBlock().getUnlocalizedName());
        setRegistryName(modelState.getBlock().getUnlocalizedName());
    }

    public void registerItemModel(Item itemBlock) {
        Kaasmod.proxy.registerItemRenderer(itemBlock, 0, state.getBlock().getUnlocalizedName());
    }

    public Item createItemBlock(){
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
