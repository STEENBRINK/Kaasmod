package nl.steenbrink.kaasmod.item;

import net.minecraftforge.oredict.OreDictionary;
import nl.steenbrink.kaasmod.item.ItemBasic;

public class ItemOre extends ItemBasic {
    private String oreName;

    public ItemOre(String name, String oreName) {
        super(name);
        this.oreName = oreName;
    }

    public void initOreDict(){
        OreDictionary.registerOre(oreName, this);
    }
}
