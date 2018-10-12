package nl.steenbrink.kaasmod.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;
import nl.steenbrink.kaasmod.Kaasmod;
import nl.steenbrink.kaasmod.util.Names;

import java.util.Set;

public class ItemCheeseSlicer extends ItemTool {

    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{Blocks.STONE});
    protected String name = Names.Items.CHEESE_SLICER;

    public ItemCheeseSlicer() {
        super(4.0f, 1, ToolMaterial.IRON, blocksEffectiveAgainst);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Kaasmod.creativeTab);
    }

    public void registerItemModel(){
        Kaasmod.proxy.registerItemRenderer(this, 0, name);
    }
}
