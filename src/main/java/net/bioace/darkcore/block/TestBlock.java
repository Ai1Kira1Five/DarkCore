package net.bioace.darkcore.block;

import net.bioace.darkcore.util.Log;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * Created by BIOACE on 01.08.2015.
 */
public class TestBlock extends BlockDC {
    public TestBlock(String name, Material material) {
        super(name, material);
    }



    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return super.getRenderType();
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess p1, int x, int y, int z, int side) {
       if (p1.getBlock(x,y,z)==p1.getBlock(x,y+1,z)&&side==0)
           return false;

       if (p1.getBlock(x,y,z)==p1.getBlock(x,y-1,z)&&side==1)
            return false;

       if (p1.getBlock(x,y,z)==p1.getBlock(x,y,z+1)&&side==2)
            return false;

       if (p1.getBlock(x,y,z)==p1.getBlock(x,y,z-1)&&side==3)
            return false;

       if (p1.getBlock(x,y,z)==p1.getBlock(x+1,y,z)&&side==4)
            return false;

       if (p1.getBlock(x,y,z)==p1.getBlock(x-1,y,z)&&side==5)
            return false;


        return super.shouldSideBeRendered(p1, x, y, z, side);
    }
}
