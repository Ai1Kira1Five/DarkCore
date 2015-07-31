package net.bioace.darkcore.Api.MagicEnergy;

import cofh.api.energy.EnergyStorage;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by BIOACE on 08.07.2015.
 */
public class MagicEnergy {

    protected int energy;
    protected int capacity;

    public MagicEnergy(int capacity){
        this.capacity=capacity;
    }


    public MagicEnergy readFromNBT(NBTTagCompound nbt) {

        this.energy = nbt.getInteger("MagicEnergy");

        if (energy > capacity) {
            energy = capacity;
        }
        return this;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

        if (energy < 0) {
            energy = 0;
        }
        nbt.setInteger("MagicEnergy", energy);
        return nbt;
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;

        if (energy > capacity) {
            energy = capacity;
        }
    }

    public void setEnergy(int energy) {

        this.energy = energy;

        if (energy > capacity) {
            this.energy = capacity;
        }
    }

    public void modifyEnergyStored(int energy) {

        this.energy += energy;

        if (this.energy > capacity) {
            this.energy = capacity;
        } else if (this.energy < 0) {
            this.energy = 0;
        }
    }

    public int getEnergyStored() {

        return energy;
    }


    public int getMaxEnergyStored() {

        return capacity;
    }
}
