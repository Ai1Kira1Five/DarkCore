package net.bioace.darkcore.Inventory;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ReportedException;

import java.util.concurrent.Callable;

/**
 * Created by BIOACE on 01.07.2015.
 */
public class pedestalInventory implements IInventory {

    public ItemStack[] pedestalItem = new ItemStack[1];
    public EntityPlayer player;

    public boolean addItemStackToInventory(final ItemStack itemStack){
        if(itemStack != null && itemStack.stackSize != 0 && itemStack.getItem() != null){

            try{
                int i;
                if (itemStack.isItemDamaged()){
                    i = this.getFirstEmptyStack();
                    if (i >= 0){
                        this.pedestalItem[i] = ItemStack.copyItemStack(itemStack);
                        this.pedestalItem[i].animationsToGo = 5;
                        itemStack.stackSize = 0;
                        return true;
                    } else if (this.player.capabilities.isCreativeMode){
                        itemStack.stackSize = 0;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    do{
                        i = itemStack.stackSize;
                        itemStack.stackSize = this.storePartialItemStack(itemStack);
                    } while (itemStack.stackSize > 0 && itemStack.stackSize < i);
                    if (itemStack.stackSize == i && this.player.capabilities.isCreativeMode){
                        itemStack.stackSize = 0;
                        return true;
                    } else {
                        return itemStack.stackSize < i;
                    }
                }
            }
            catch (Throwable throwable)
            {
                CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Adding item to inventory");
                CrashReportCategory crashreportcategory = crashreport.makeCategory("Item being added");
                crashreportcategory.addCrashSection("Item ID", Integer.valueOf(Item.getIdFromItem(itemStack.getItem())));
                crashreportcategory.addCrashSection("Item data", Integer.valueOf(itemStack.getItemDamage()));
                crashreportcategory.addCrashSectionCallable("Item name", new Callable()
                {
                    private static final String __OBFID = "CL_00001710";
                    public String call()
                    {
                        return itemStack.getDisplayName();
                    }
                });
                throw new ReportedException(crashreport);
            }
        }
        else
        {
            return false;
        }
    }
    private int storePartialItemStack(ItemStack itemStack)
    {
        Item item = itemStack.getItem();
        int i = itemStack.stackSize;
        int j;

        if (itemStack.getMaxStackSize() == 1)
        {
            j = this.getFirstEmptyStack();

            if (j < 0)
            {
                return i;
            }
            else
            {
                if (this.pedestalItem[j] == null)
                {
                    this.pedestalItem[j] = ItemStack.copyItemStack(itemStack);
                }

                return 0;
            }
        }
        else
        {
            j = this.storeItemStack(itemStack);

            if (j < 0)
            {
                j = this.getFirstEmptyStack();
            }

            if (j < 0)
            {
                return i;
            }
            else
            {
                if (this.pedestalItem[j] == null)
                {
                    this.pedestalItem[j] = new ItemStack(item, 0, itemStack.getItemDamage());

                    if (itemStack.hasTagCompound())
                    {
                        this.pedestalItem[j].setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
                    }
                }

                int k = i;

                if (i > this.pedestalItem[j].getMaxStackSize() - this.pedestalItem[j].stackSize)
                {
                    k = this.pedestalItem[j].getMaxStackSize() - this.pedestalItem[j].stackSize;
                }

                if (k > this.getInventoryStackLimit() - this.pedestalItem[j].stackSize)
                {
                    k = this.getInventoryStackLimit() - this.pedestalItem[j].stackSize;
                }

                if (k == 0)
                {
                    return i;
                }
                else
                {
                    i -= k;
                    this.pedestalItem[j].stackSize += k;
                    this.pedestalItem[j].animationsToGo = 5;
                    return i;
                }
            }
        }
    }

    private int storeItemStack(ItemStack itemStack)
    {
        for (int i = 0; i < this.pedestalItem.length; ++i)
        {
            if (this.pedestalItem[i] != null && this.pedestalItem[i].getItem() == itemStack.getItem() && this.pedestalItem[i].isStackable() && this.pedestalItem[i].stackSize < this.pedestalItem[i].getMaxStackSize() && this.pedestalItem[i].stackSize < this.getInventoryStackLimit() && (!this.pedestalItem[i].getHasSubtypes() || this.pedestalItem[i].getItemDamage() == itemStack.getItemDamage()) && ItemStack.areItemStackTagsEqual(this.pedestalItem[i], itemStack))
            {
                return i;
            }
        }

        return -1;
    }


    public int getFirstEmptyStack(){
        if (this.pedestalItem[0] == null){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int p_70301_1_) {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {

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
        return 0;
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }
}