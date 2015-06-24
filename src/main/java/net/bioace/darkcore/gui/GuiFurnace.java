package net.bioace.darkcore.gui;

import net.bioace.darkcore.Container.ContainerFurnace;
import net.bioace.darkcore.Container.ContainerGrinder;
import net.bioace.darkcore.DarkCore;
import net.bioace.darkcore.TileEntity.TEGrinder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by BIOACE on 09.05.2015.
 */
public class GuiFurnace  extends GuiContainer {
    public static final ResourceLocation bground = new ResourceLocation(DarkCore.MOD_ID+ ":" + "textures/gui/GuiBase.png");
    public TEFurnace furnace;


    String name = "Название Механизма";
    public GuiFurnace(InventoryPlayer inventoryPlayer, TEFurnace entity) {
        super(new ContainerFurnace(inventoryPlayer, entity));
        this.furnace=entity;

        this.xSize = 176;
        this.ySize = 166;
    }




    public void drawGuiContainerForegroundLayer(int mx, int my){

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("oven", new Object[0]), 118, this.ySize - 96 + 2, 4210752);
        fontRendererObj.drawString(" "+furnace.storage.getEnergyStored(), this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 20, 4210752);
        ArrayList<String> tooltip = null;
        if(mx>guiLeft+157&&mx<guiLeft+164 && my>guiTop+22&&my<guiTop+68)
        {
            tooltip = new ArrayList<String>();
            tooltip.add(mx+"/"+my+" "+furnace.getEnergyStored(ForgeDirection.UP)+"/"+furnace.storage.getMaxEnergyStored()+" RF");
        }
        if(tooltip!=null)
        {
            this.drawHoveringText(tooltip, mx-guiLeft, my-guiTop, fontRendererObj);
            RenderHelper.enableGUIStandardItemLighting();
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);



    }


}
