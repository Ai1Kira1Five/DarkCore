package net.bioace.darkcore.TestEnergy;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

/**
 * Created by BIOACE on 10.07.2015.
 */
public class ContainerMagicBlock extends Container {
    TEMagicBlock MagicBlock;
    public ContainerMagicBlock(InventoryPlayer inventory, TEMagicBlock entity){
        this.MagicBlock=entity;
        this.addSlotToContainer(new Slot(entity, 0, 50, 35));

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
