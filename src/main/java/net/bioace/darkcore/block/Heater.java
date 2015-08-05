package net.bioace.darkcore.block;

import net.bioace.darkcore.TileEntity.TEHeater;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by BIOACE on 03.08.2015.
 */
public class Heater extends BlockContainerDC {
    public Heater(String name, Material material) {
        super(name, material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TEHeater();
    }

}
