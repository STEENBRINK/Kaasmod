package nl.steenbrink.kaasmod.block.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.steenbrink.kaasmod.Kaasmod;

public class BlockFluidBasic extends BlockFluidClassic {

    protected static Fluid fluid;

    public BlockFluidBasic(Fluid fluid, int density){
        super(fluid, Material.WATER);
        super.displacements.put(this, false);
        setRegistryName(this.fluidName);
        setUnlocalizedName(this.fluidName);
        setDensity(density);
    }

    public BlockFluidBasic(Fluid fluid){
        super(fluid, Material.WATER);
        super.displacements.put(this, false);
        setRegistryName(this.fluidName);
        setUnlocalizedName(this.fluidName);
    }

    public void registerItemModel(Item itemBlock) {
        Kaasmod.proxy.registerItemRenderer(itemBlock, 0, this.fluidName);
    }

    public Item createItemBlock(){
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public void render() {
        ModelLoader.setCustomStateMapper(this, new StateMap.Builder().ignore(LEVEL).build());
    }
}
