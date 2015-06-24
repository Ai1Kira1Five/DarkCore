package net.bioace.darkcore.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.bioace.darkcore.DarkCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

import java.util.Random;

/**
 * Created by BIOACE on 04.04.2015.
 */
public class BlockDC extends Block {
    private final String name;
    public BlockDC(String name, Material material){
        super(material);
        this.name = name;
        setCreativeTab(DarkCore.tab);
        setBlockTextureName(DarkCore.MOD_ID.toLowerCase()+":"+name);
        GameRegistry.registerBlock(this,name);
    }

    @Override
    public String getLocalizedName() {
        return StatCollector.translateToLocal(getUnlocalizedName());
    }

    @Override
    public String getUnlocalizedName() {
        return DarkCore.MOD_ID.toLowerCase()+".block."+name;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(this);
    }
}
