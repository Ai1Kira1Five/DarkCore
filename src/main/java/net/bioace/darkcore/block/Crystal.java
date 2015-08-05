package net.bioace.darkcore.block;

import net.bioace.darkcore.TileEntity.TECrystal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by BIOACE on 05.08.2015.
 */
public class Crystal extends BlockDC implements ITileEntityProvider {
    public Crystal(String name, Material material) {
        super(name, material);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TECrystal();
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }
}
