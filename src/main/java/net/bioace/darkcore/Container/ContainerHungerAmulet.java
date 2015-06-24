package net.bioace.darkcore.Container;

import net.bioace.darkcore.Content;
import net.bioace.darkcore.item.HungerAmulet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by BIOACE on 22.06.2015.
 */
public class ContainerHungerAmulet extends Container {
    HungerAmulet amulet= Content.HungerAmulet;
    public ContainerHungerAmulet(InventoryPlayer inventory){
        this.addSlotToContainer(new Slot(amulet, 0, 72, 31));
        this.addSlotToContainer(new Slot(amulet, 1, 93, 31));
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
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }
}
