package net.bioace.darkcore.Render;

import net.bioace.darkcore.DarkCore;
import net.bioace.darkcore.TileEntity.TECrystal;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by BIOACE on 05.08.2015.
 */
public class RenderCrystal extends TileEntitySpecialRenderer {

    public static final IModelCustom model =
            AdvancedModelLoader.loadModel(new ResourceLocation(DarkCore.MOD_ID, "obj/сrystal.obj"));
    public static final ResourceLocation texture = new ResourceLocation(DarkCore.MOD_ID, "textures/blocks/Crystal.png");
    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
        render((TECrystal)tile,x,y,z,f);
    }
    private void render(TECrystal tile, double x, double y, double z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        GL11.glTranslatef(0.5F, 0.0F, 0.5F);
       // GL11.glRotatef(270, 1F, 0F, 0F);

        bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();
    }
}
