package net.bioace.darkcore.item.Amulet;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.bioace.darkcore.item.ItemDC;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Created by BIOACE on 28.06.2015.
 */
public class InfectedAmulet extends ItemDC implements IBauble {
    public InfectedAmulet(String name) {
        super(name);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if(player.isPotionActive(Potion.moveSlowdown)) {
            PotionEffect effect = player.getActivePotionEffect(Potion.moveSlowdown);
            int level = effect.getAmplifier();
            int potionid = effect.getPotionID();
            int duration = effect.getDuration();
        }
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return false;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return false;
    }
}
