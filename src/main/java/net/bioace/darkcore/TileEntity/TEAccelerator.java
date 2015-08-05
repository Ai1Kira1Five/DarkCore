package net.bioace.darkcore.TileEntity;

import net.bioace.darkcore.util.Log;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by BIOACE on 03.08.2015.
 */
public class TEAccelerator extends TileEntity {
    protected final ForgeDirection[] dirs = ForgeDirection.values();
    int max = 127;

    @Override
    public void updateEntity() {
        if(!this.worldObj.isRemote)
        for (int i = 0; i < 6; i++) {
            ForgeDirection dir = dirs[i];
            TileEntity te = this.getAdjacentTileEntity(dir);
         //   Log.info(te);
           if (te!=null&&!(te instanceof TEAccelerator))
            for (int k = 0; k < max; k++)
               te.updateEntity();

        }
    }

    public final TileEntity getAdjacentTileEntity(ForgeDirection dir) {
        int dx = xCoord + dir.offsetX;
        int dy = yCoord + dir.offsetY;
        int dz = zCoord + dir.offsetZ;
        return worldObj.getTileEntity(dx, dy, dz);
    }
}
