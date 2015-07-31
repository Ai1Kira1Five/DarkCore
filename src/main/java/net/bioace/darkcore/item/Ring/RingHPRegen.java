package net.bioace.darkcore.item.Ring;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.bioace.darkcore.item.ItemDC;
import net.bioace.darkcore.util.Log;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import java.util.List;

/**
 * Created by BIOACE on 27.06.2015.
 */
public class RingHPRegen extends ItemDC implements IBauble {
    private int cld=0;
    public RingHPRegen(String name) {
        super(name);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer entityPlayer, List list, boolean b) {
        super.addInformation(stack, entityPlayer, list, b);
        list.add("RingHPRegen.list");
        list.add("RingHPRegen.cld "+cld);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
       // Log.info("heal");

        if((player.getHealth()<player.getMaxHealth()/2)&&(cld==0)) {
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 2, true));
          cld=1000;
        }
        if(cld>0)
            cld--;
      }


    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}
