package nl.steenbrink.kaasmod.block.tile;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nl.steenbrink.kaasmod.init.ModItems;
import nl.steenbrink.kaasmod.tileentity.TileEntityToaster;
import nl.steenbrink.kaasmod.util.Names;

import javax.annotation.Nullable;

public class BlockToaster extends BlockBasicTile<TileEntityToaster> {
    public BlockToaster() {
        super(Material.IRON, Names.Blocks.TOASTER);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (player == null) {
            return false;
        }

        TileEntityToaster tileEntityToaster = (TileEntityToaster) world.getTileEntity(pos);
        if (tileEntityToaster == null) {
            return false;
        }

        if (player.isSneaking()) {
            if (player.getHeldItemMainhand().isEmpty() && tileEntityToaster.getStackInSlot(0) != null && tileEntityToaster.canExtractItem(0, null, side)) {
                if (player.inventory.addItemStackToInventory(tileEntityToaster.getStackInSlot(0))) {
                    tileEntityToaster.setInventorySlotContents(0, null);
                }
            }
            return true;
        }
        if (!player.getHeldItemMainhand().isEmpty()) {
            if (player.getHeldItemMainhand().getUnlocalizedName().equals(ModItems.cheeseBaconBread.getUnlocalizedName())) {
                //System.out.println("CheeseBaconBread!");
                ItemStack equipedItem = player.getHeldItemMainhand();
                if (tileEntityToaster.getStackInSlot(0) == null) {
                    tileEntityToaster.setInventorySlotContents(0, equipedItem.splitStack(1));
                }
            } //else {
            //System.out.println("false :(");
            //System.out.println(entityPlayer.getCurrentEquippedItem().getUnlocalizedName());
            //}
        }

        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityToaster tileentityfurnace = (TileEntityToaster) world.getTileEntity(pos);

        if (tileentityfurnace != null) {
            for (int i1 = 0; i1 < tileentityfurnace.getSizeInventory(); ++i1) {
                ItemStack itemstack = tileentityfurnace.getStackInSlot(i1);

                if (itemstack != null) {
                    float f = world.rand.nextFloat() * 0.8F + 0.1F;
                    float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                    float f2 = world.rand.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.getCount() > 0) {
                        int j1 = world.rand.nextInt(21) + 10;

                        if (j1 > itemstack.getCount()) {
                            j1 = itemstack.getCount();
                        }

                        itemstack.setCount(itemstack.getCount() - j1);
                        EntityItem entityitem = new EntityItem(world, (double) ((float) pos.getX() + f), (double) ((float) pos.getY() + f1), (double) ((float) pos.getZ() + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                        float f3 = 0.05F;
                        entityitem.motionX = (double) ((float) world.rand.nextGaussian() * f3);
                        entityitem.motionY = (double) ((float) world.rand.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double) ((float) world.rand.nextGaussian() * f3);
                        world.spawnEntity(entityitem);
                    }
                }
            }

            world.isBlockTickPending(pos, state.getBlock());
        }

        super.breakBlock(world, pos, state);
    }

    @Override
    public Class<TileEntityToaster> getTileEntityClass() {
        return TileEntityToaster.class;
    }

    @Nullable
    @Override
    public TileEntityToaster createTileEntity(World world, IBlockState state) {
        return new TileEntityToaster();
    }
}
