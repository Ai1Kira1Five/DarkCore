package net.bioace.darkcore.TestEnergy;

import net.bioace.darkcore.Api.MagicEnergy.ItemMagicEnergy;
import net.bioace.darkcore.item.ItemDC;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by BIOACE on 22.07.2015.
 */
public class DebugEnergy extends ItemDC{
    public DebugEnergy(String name) {
        super(name);
        setMaxStackSize(1);

    }
    private ItemMagicEnergy me = new ItemMagicEnergy(1000);

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
        super.addInformation(stack, player, list, b);
        me.setEnergy(stack,1000);
        list.add(me.getEnergyStored(stack) + "/" + me.getMaxEnergyStored(stack));
    }
}
