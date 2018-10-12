package nl.steenbrink.kaasmod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nl.steenbrink.kaasmod.block.ModBlocks;
import nl.steenbrink.kaasmod.item.ModItems;
import nl.steenbrink.kaasmod.proxy.CommonProxy;
import nl.steenbrink.kaasmod.util.CreativeTab;
import nl.steenbrink.kaasmod.util.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class Kaasmod {
    @Mod.Instance(Reference.MOD_ID)
    public static Kaasmod instance;

    @SidedProxy(clientSide = Reference.CLASS_PROXY_CLIENT, serverSide = Reference.CLASS_PROXY_SERVER)
    public static CommonProxy proxy;

    public static final CreativeTab creativeTab = new CreativeTab();
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

    @Mod.EventBusSubscriber
    public static class RegistrationHandler{

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event){
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event){
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event){
            ModItems.registerModels();
            ModBlocks.registerModels();
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Initialize the items, fluids and blocks
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Register event handlers
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
