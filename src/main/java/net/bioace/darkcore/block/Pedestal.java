package net.bioace.darkcore.block;

import net.bioace.darkcore.TileEntity.TEPedestal;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by BIOACE on 30.06.2015.
 */
public class Pedestal extends BlockDC {
    public Pedestal(String name, Material material) {
        super(name, material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int side, float hitX, float hitY, float hitZ) {
        TEPedestal pedestal = (TEPedestal) world.getTileEntity(x,y,z);
        if(!world.isRemote){
            /*
            if (pedestal.inventory != null) {
                p.inventory.addItemStackToInventory(pedestal.inventory);
            } else
            if (p.inventory.getCurrentItem().stackSize!=0) {
                {
                p.inventory.getCurrentItem().stackSize--;

            }
//p.inventory.getItemStack()
        } */
         
        }
        return super.onBlockActivated(world, x, y, z, p, side, hitX, hitY, hitZ);
    }


    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TEPedestal();
    }
}
