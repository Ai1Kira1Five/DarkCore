package net.bioace.darkcore.Api.MagicEnergy;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by BIOACE on 08.07.2015.
 */
public class ItemMagicEnergy extends Item {
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public ItemMagicEnergy(){

    }
    public ItemMagicEnergy(int capacity){
        this.capacity=capacity;
    }

    public ItemMagicEnergy setCapacity(int capacity) {

        this.capacity = capacity;
        return this;
    }

    public void modifyEnergy(ItemStack container, int modify){
        if (container.stackTagCompound == null) {
            container.stackTagCompound = new NBTTagCompound();
        }
        int energy = container.stackTagCompound.getInteger("MagicEnergy");
        energy +=modify;
        if (energy > capacity) {
            energy = capacity;
        } else if (energy < 0) {
            energy = 0;
        }
        container.stackTagCompound.setInteger("MagicEnergy", energy);

      }

    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

        if (container.stackTagCompound == null) {
            container.stackTagCompound = new NBTTagCompound();
        }
        int energy = container.stackTagCompound.getInteger("MagicEnergy");
        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

        if (!simulate) {
            energy += energyReceived;
            container.stackTagCompound.setInteger("MagicEnergy", energy);
        }
        return energyReceived;
    }


    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {

        if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("MagicEnergy")) {
            return 0;
        }
        int energy = container.stackTagCompound.getInteger("MagicEnergy");
        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));

        if (!simulate) {
            energy -= energyExtracted;
            container.stackTagCompound.setInteger("MagicEnergy", energy);
        }
        return energyExtracted;
    }

    public int getEnergyStored(ItemStack container) {

        if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("MagicEnergy")) {
            return 0;
        }
        return container.stackTagCompound.getInteger("MagicEnergy");
    }

    public int getMaxEnergyStored(ItemStack container) {

        return capacity;
    }
    public void setEnergy(ItemStack container,int energy){
        if (container.stackTagCompound == null) {
            container.stackTagCompound = new NBTTagCompound();
        }

        if (energy > capacity) {
            energy = capacity;
        } else if (energy < 0) {
            energy = 0;
        }
        container.stackTagCompound.setInteger("MagicEnergy", energy);
    }
}
