package net.bioace.darkcore.TileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by BIOACE on 03.08.2015.
 */
public class TEHeater extends TileEntity {
    protected final ForgeDirection[] dirs = ForgeDirection.values();

    @Override
    public void updateEntity() {
        if(!this.worldObj.isRemote)
            for (int i = 0; i < 6; i++) {
                ForgeDirection dir = dirs[i];
                TileEntity te = this.getAdjacentTileEntity(dir);
                if (te instanceof TileEntityFurnace)
                    ((TileEntityFurnace) te).furnaceBurnTime=200;
            }

    }
    public final TileEntity getAdjacentTileEntity(ForgeDirection dir) {
        int dx = xCoord + dir.offsetX;
        int dy = yCoord + dir.offsetY;
        int dz = zCoord + dir.offsetZ;
        return worldObj.getTileEntity(dx, dy, dz);
    }
}
