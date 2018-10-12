package nl.steenbrink.kaasmod.item;
import net.minecraft.item.Item;
import nl.steenbrink.kaasmod.Kaasmod;

public class ItemBasic extends Item {
    protected String name;
    public ItemBasic(String name){
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Kaasmod.creativeTab);
    }

    public void registerItemModel(){
        Kaasmod.proxy.registerItemRenderer(this, 0, name);
    }
}
