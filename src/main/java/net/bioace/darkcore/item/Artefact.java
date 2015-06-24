package net.bioace.darkcore.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;


import java.awt.*;
import java.util.List;

/**
 * Created by BIOACE on 26.04.2015.
 */
public class Artefact extends ItemDC {
    int Rare;
    public Artefact(String name,int Rare) {
        super(name);
        this.Rare=Rare;
    }
    EnumChatFormatting color;
    EnumChatFormatting Rare(){
        if (Rare==0)
            color=EnumChatFormatting.WHITE;
        if (Rare==1)
            color=EnumChatFormatting.BLUE;
        if (Rare==2)
            color=EnumChatFormatting.YELLOW;
        if (Rare==3)
            color=EnumChatFormatting.GOLD;

    return color;
    }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
        Rare();
       list.add("Rarity: "+color+Rare);
    }

    @Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        Rare++;
        if (Rare>3) Rare=0;
        return false;
    }
}
