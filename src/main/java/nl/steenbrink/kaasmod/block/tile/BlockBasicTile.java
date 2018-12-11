package nl.steenbrink.kaasmod.block.tile;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nl.steenbrink.kaasmod.Kaasmod;
import nl.steenbrink.kaasmod.block.BlockBasic;

import javax.annotation.Nullable;

public abstract class BlockBasicTile<TE extends TileEntity> extends BlockBasic {

        public BlockBasicTile(Material material, String name) {
            super(material, name);
            setCreativeTab(Kaasmod.creativeTab);
        }

        public abstract Class<TE> getTileEntityClass();

        public TE getTileEntity(IBlockAccess world, BlockPos pos) {
            return (TE)world.getTileEntity(pos);
        }

        @Override
        public boolean hasTileEntity(IBlockState state) {
            return true;
        }

        @Nullable
        @Override
        public abstract TE createTileEntity(World world, IBlockState state);


}