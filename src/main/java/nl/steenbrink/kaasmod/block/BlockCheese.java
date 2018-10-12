package nl.steenbrink.kaasmod.block;

import net.minecraft.block.BlockCake;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.steenbrink.kaasmod.Kaasmod;
import nl.steenbrink.kaasmod.item.ModItems;

public class BlockCheese extends BlockCake {

    //variables
    protected String name;
    protected boolean isYoungCheese;
    public static final PropertyInteger BITES = PropertyInteger.create("bites", 0, 6);

    public BlockCheese(String name, boolean isYoung) {
        this.name = name;
        this.isYoungCheese = isYoung;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Kaasmod.creativeTab);
    }

    public void registerItemModel(Item itemBlock) {
        Kaasmod.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    public void setYoung(boolean isYoung) {
        isYoungCheese = isYoung;
    }

    public boolean getYoung(){
        return isYoungCheese;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
        String currentEquiped = FMLClientHandler.instance().getClient().player.getHeldItem(EnumHand.MAIN_HAND).getUnlocalizedName();
        int meta = state.getBlock().getMetaFromState(state);
        if (isYoungCheese) {
            if (!world.isRemote) {
                EntityItem k = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModBlocks.youngCheese));
                k.setVelocity(0, 0.2, 0);
                world.spawnEntity(k);
            }
        } else {
            if (!world.isRemote && meta < 6) {
                if (currentEquiped.equals(ModItems.cheeseSlicer.getUnlocalizedName())) {
                    EntityItem k = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.cheeseSlice, 6 - meta));
                    k.setVelocity(0, 0.2, 0);
                    world.spawnEntity(k);
                } else {
                    EntityItem k = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModBlocks.cheese));
                    k.setVelocity(0, 0.2, 0);
                    world.spawnEntity(k);
                }
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            return this.onEat(world, pos, state, player);
        } else {
            ItemStack itemstack = player.getHeldItem(hand);
            return this.onEat(world, pos, state, player) || itemstack.isEmpty();
        }
    }

    private boolean onEat(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (!player.canEat(false) && !isYoungCheese) {
            return false;
        } else {
            player.getFoodStats().addStats(2, 0.2F);
            int i = ((Integer) state.getValue(BITES)).intValue();

            if (i < 6) {
                worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                worldIn.setBlockToAir(pos);
            }

            return true;
        }
    }


}
