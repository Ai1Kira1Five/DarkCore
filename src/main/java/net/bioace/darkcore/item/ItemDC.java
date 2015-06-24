package net.bioace.darkcore.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.bioace.darkcore.DarkCore;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**
 * Created by BIOACE on 04.04.2015.
 */
public class ItemDC extends Item {
    private final String name;

    public ItemDC(String name) {
        this.name = name;
        setCreativeTab(DarkCore.tab);
        setTextureName(DarkCore.MOD_ID.toLowerCase()+":"+name);
        GameRegistry.registerItem(this, name);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return StatCollector.translateToLocal(DarkCore.MOD_ID.toLowerCase()+"."+name);
    }
}
