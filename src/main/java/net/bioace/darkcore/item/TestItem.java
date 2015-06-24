package net.bioace.darkcore.item;

import net.bioace.darkcore.DarkCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by BIOACE on 04.04.2015.
 */
public class TestItem extends ItemDC {
    public TestItem(String name) {
        super(name);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        player.openGui(DarkCore.instance, 1, world,0,0,0);
        return super.onItemRightClick(stack, world, player);
    }

    @Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        return super.onItemUse(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
    }
}
