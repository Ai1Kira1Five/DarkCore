package net.bioace.darkcore.block;

import net.bioace.darkcore.DarkCore;
import net.bioace.darkcore.TileEntity.TEAccelerator;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by BIOACE on 03.08.2015.
 */
public class Accelerator extends BlockContainerDC {

    public Accelerator(String name, Material material) {
        super(name, material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TEAccelerator();
    }
}
