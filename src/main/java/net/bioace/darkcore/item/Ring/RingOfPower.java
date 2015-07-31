package net.bioace.darkcore.item.Ring;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.bioace.darkcore.Api.MagicEnergy.ItemMagicEnergy;
import net.bioace.darkcore.Api.MagicEnergy.MagicEnergy;
import net.bioace.darkcore.item.ItemDC;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

/**
 * Created by BIOACE on 27.06.2015.
 */
public class RingOfPower extends ItemDC implements IBauble {
    private ItemMagicEnergy me = new ItemMagicEnergy(25);
    public RingOfPower(String name) {
        super(name);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
        super.addInformation(stack, player, list, b);
        list.add(me.getEnergyStored(stack) + "/" + me.getMaxEnergyStored(stack));
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float p1, float p2, float p3) {
        me.modifyEnergy(stack,-1);
        return super.onItemUse(stack, player, world, x, y, z, i, p1, p2, p3);

    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
       // player.setInvisible(true);


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
