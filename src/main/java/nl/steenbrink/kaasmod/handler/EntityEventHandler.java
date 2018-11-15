package nl.steenbrink.kaasmod.handler;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nl.steenbrink.kaasmod.init.ModItems;

public class EntityEventHandler {

    @SubscribeEvent
    public void onLivingDropsEvent(LivingDropsEvent event){
        if (event.getEntityLiving() instanceof EntityCow && event.getEntityLiving().isChild()) {
            EntityCow entityCow = (EntityCow) event.getEntityLiving();
            EntityItem itemEntity = new EntityItem(entityCow.world, entityCow.posX, entityCow.posY, entityCow.posZ, new ItemStack(ModItems.stomach));
            event.getDrops().add(itemEntity);
        }
    }
}
