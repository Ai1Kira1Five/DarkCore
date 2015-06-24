package net.bioace.darkcore.Container;

import net.bioace.darkcore.TileEntity.TEGrinder;
import net.bioace.darkcore.gui.TEFurnace;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

/**
 * Created by BIOACE on 09.05.2015.
 */
public class ContainerFurnace extends Container {
    TEFurnace furnace;
    public ContainerFurnace(InventoryPlayer inventory, TEFurnace tileentity){
        this.furnace=tileentity;
        this.addSlotToContainer(new Slot(tileentity, 0, 50, 35));
        this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 1, 116, 35));
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18));
            }
        }

        for (int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142));
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}
