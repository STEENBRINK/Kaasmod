package nl.steenbrink.kaasmod.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nl.steenbrink.kaasmod.init.ModItems;

public class EntityEventHandler {
    private boolean isReady = false;

    @SubscribeEvent
    public void onLivingDropsEvent(LivingDropsEvent event){
        if (event.getEntityLiving() instanceof EntityCow && event.getEntityLiving().isChild()) {
            EntityCow entityCow = (EntityCow) event.getEntityLiving();
            EntityItem itemEntity = new EntityItem(entityCow.world, entityCow.posX, entityCow.posY, entityCow.posZ, new ItemStack(ModItems.stomach));
            event.getDrops().add(itemEntity);
        }
    }

    @SubscribeEvent
    public void onPlayerInteractEvent(PlayerInteractEvent.EntityInteractSpecific event){
        if (!isReady) {
            isReady = true;
        }else{
            EntityPlayer player = event.getEntityPlayer();
            ItemStack itemStack = player.getHeldItemMainhand();
            EnumHand hand = event.getHand();
            Entity target = event.getTarget();
            if (target instanceof EntityCow && !(((EntityCow) target).isChild())) {
                if (player.getHeldItemMainhand().getItem() == Items.BUCKET) {
                    itemStack.shrink(1);

                    if (itemStack.isEmpty()) {
                        player.setHeldItem(hand, new ItemStack(Items.MILK_BUCKET));
                    } else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.MILK_BUCKET))) {
                        player.dropItem(new ItemStack(Items.MILK_BUCKET), false);
                    }
                }
            }
            isReady = false;
        }
    }

}
