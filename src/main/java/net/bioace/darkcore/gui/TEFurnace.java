package net.bioace.darkcore.gui;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by BIOACE on 09.05.2015.
 */
public class TEFurnace extends TileEntity implements ISidedInventory, IEnergyHandler {

    public EnergyStorage storage = new EnergyStorage(32000,256,32000);
    private ItemStack[] slots = new ItemStack[4];


    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return this.isItemValidForSlot(i, itemstack);
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemStack, int j) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return this.slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.slots[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.slots[i] != null){
            ItemStack itemstack;

            if (this.slots[i].stackSize <= j){
                itemstack = this.slots[i];
                this.slots[i] = null;
                return itemstack;
            }else{
                itemstack = this.slots[i].splitStack(j);

                if (this.slots[i].stackSize == 0){
                    this.slots[i] = null;
                }
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.slots[i]!= null){
            ItemStack itemstack = this.slots[i];
            this.slots[i] = null;
            return itemstack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        this.slots[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
            itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
     return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        NBTTagList list = nbt.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < list.tagCount(); ++i){
            NBTTagCompound compound = list.getCompoundTagAt(i);
            byte b = compound.getByte("Slot");

            if (b >= 0 && b < this.slots.length){
                this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
            }
        }
        storage.readFromNBT(nbt);

    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList list = new NBTTagList();

        for (int i = 0; i < this.slots.length; ++i){
            if (this.slots[i] != null){
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte)i);
                this.slots[i].writeToNBT(compound);
                list.appendTag(compound);
            }
        }

        nbt.setTag("Items", list);
        storage.writeToNBT(nbt);


    }

    /* IEnergyConnection */
    @Override
    public boolean canConnectEnergy(ForgeDirection from) {

        return true;
    }

    /* IEnergyReceiver */
    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {

        return storage.receiveEnergy(maxReceive, simulate);
    }

    /* IEnergyProvider */
    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {

        return storage.extractEnergy(maxExtract, simulate);
    }

    /* IEnergyReceiver and IEnergyProvider */
    @Override
    public int getEnergyStored(ForgeDirection from) {

        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {

        return storage.getMaxEnergyStored();
    }
}
