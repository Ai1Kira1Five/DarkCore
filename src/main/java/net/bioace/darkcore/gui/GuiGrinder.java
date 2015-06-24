package net.bioace.darkcore.gui;

import net.bioace.darkcore.Container.ContainerGrinder;
import net.bioace.darkcore.DarkCore;
import net.bioace.darkcore.TileEntity.TEGrinder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by BIOACE on 11.04.2015.
 */
public class GuiGrinder extends GuiContainer {

    public static final ResourceLocation bground = new ResourceLocation(DarkCore.MOD_ID+ ":" + "textures/gui/GuiAlabasterOven.png");

    public TEGrinder grinder;

    public GuiGrinder (InventoryPlayer inventoryPlayer, TEGrinder entity) {
        super(new ContainerGrinder(inventoryPlayer, entity));

        this.grinder = entity;

        this.xSize = 176;
        this.ySize = 166;
    }


    public void drawGuiContainerForegroundLayer(int par1, int par2){
        String name = "Alabaster Oven";

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("Container.inventory", new Object[0]), 118, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if (this.grinder.isBurning()){
            int k = this.grinder.getBurnTimeRemainingScaled(40);
            int j = 40 - k;
            drawTexturedModalRect(guiLeft + 29, guiTop + 65, 176, 0, 40 - j, 10);
        }

        int k = this.grinder.getCookProgressScaled(24);
        drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 10, k + 1, 16);
    }


}