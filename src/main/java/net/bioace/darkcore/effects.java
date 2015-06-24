package net.bioace.darkcore;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Created by BIOACE on 02.10.2014.
 */
public class effects {
    public static final int ID_HP_REGEN = 1;
    public static final int ID_POWER = 2;
    public static final int ID_MP_REGEN = 4;

    public static void effect (int id,ItemStack stack, EntityLivingBase player) {
        float maxHealth = player.getMaxHealth();
        switch (id){
        case 1:
             if (stack.getItemDamage()==0 && !player.isPotionActive(Potion.regeneration) && player.getHealth()!=player.getMaxHealth()) {
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id,40,1,true));
             }; break;
        case 2:
            if (stack.getItemDamage()==0 && !player.isPotionActive(Potion.damageBoost)) {
            player.addPotionEffect(new PotionEffect(Potion.damageBoost.id,40,0,true));
        }; break;
        case 3:
            if (stack.getItemDamage()==0 && !player.isPotionActive(Potion.invisibility)) {
            player.addPotionEffect(new PotionEffect(Potion.invisibility.id,40,0,true));
         }; break;
        default:;

        }}
}
