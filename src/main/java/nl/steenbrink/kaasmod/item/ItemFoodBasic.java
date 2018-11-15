package nl.steenbrink.kaasmod.item;

import net.minecraft.item.ItemFood;
import nl.steenbrink.kaasmod.Kaasmod;

public class ItemFoodBasic extends ItemFood {

    protected String name;

    public ItemFoodBasic(String name, int food_bars, float saturation, boolean isWolfsFood){
        super(food_bars, saturation, isWolfsFood);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Kaasmod.creativeTab);
    }

    public void registerItemModel(){
        Kaasmod.proxy.registerItemRenderer(this, 0, name);
    }
}
