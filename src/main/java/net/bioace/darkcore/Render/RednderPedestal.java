package net.bioace.darkcore.Render;

import net.bioace.darkcore.TileEntity.TEPedestal;
import net.bioace.darkcore.util.MiscUtils;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by BIOACE on 30.06.2015.
 */
public class RednderPedestal extends TileEntitySpecialRenderer {
    @Override
    public void renderTileEntityAt(TileEntity tile, double screenX,	double screenY, double screenZ, float partialTicks) {
        TEPedestal pedestal = (TEPedestal) tile;
        if(pedestal.inventory != null)
        {
            GL11.glPushMatrix();

            MiscUtils.renderItemStack_Full(pedestal.inventory, 0, 0, 0, screenX, screenY, screenZ, tile.getWorldObj().getWorldTime() % 360, 0, 1, 1, 1, 0.5F, 0.9F, 0.5F);

            GL11.glPopMatrix();
        }
    }
}
