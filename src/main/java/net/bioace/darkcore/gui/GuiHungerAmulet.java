package net.bioace.darkcore.gui;

import net.bioace.darkcore.Container.ContainerHungerAmulet;
import net.bioace.darkcore.DarkCore;
import net.bioace.darkcore.item.HungerAmulet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by BIOACE on 22.06.2015.
 */
public class GuiHungerAmulet extends GuiContainer {
    public static final ResourceLocation bground = new ResourceLocation(DarkCore.MOD_ID+ ":" + "textures/gui/HungerAmulet.png");
    public GuiHungerAmulet(InventoryPlayer inventory) {
        super(new ContainerHungerAmulet(inventory));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mx, int my) {
        
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
