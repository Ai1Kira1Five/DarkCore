package net.bioace.darkcore.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.bioace.darkcore.DarkCore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by BIOACE on 22.06.2015.
 */
public class HungerAmulet extends ItemDC implements IBauble, IInventory {
    public    EntityPlayer player;
    private ItemStack[] slots = new ItemStack[2];

    public HungerAmulet(String name) {
        super(name);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
        super.addInformation(stack, player, list, b);
        this.player=player;
        list.add("Запас еды: "+player.getFoodStats().getFoodLevel());
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par1, int par2, int par3, int par4, float f1, float f2, float f3) {

        if(!world.isRemote)
        player.openGui(DarkCore.instance, 3, world, 0, 0, 0);
            return super.onItemUse(stack, player, world, par1, par2, par3, par4, f1, f2, f3);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player1) {

        if(player.getFoodStats().getFoodLevel()<20)
      this.player.getFoodStats().setFoodLevel(20);
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
    public void markDirty() {

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack stack) {
        return false;
    }
}
