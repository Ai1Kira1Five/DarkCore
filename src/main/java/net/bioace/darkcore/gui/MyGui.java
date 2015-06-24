package net.bioace.darkcore.gui;

import net.bioace.darkcore.DarkCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.swing.text.html.parser.Entity;
import java.awt.Color;
/**
 * Created by BIOACE on 20.09.2014.
 */
public class MyGui extends GuiScreen
{
        ResourceLocation texture = new ResourceLocation(DarkCore.MOD_ID.toLowerCase(), "textures/gui/background.png");
        public  final  int xSizeOfTexure = 256;
        public  final  int ySizeOfTexure = 256;

    public MyGui(EntityPlayer player){

    }
    @Override
    public void initGui() {
        int posX = (this.width - xSizeOfTexure)/2;
        int posY = (this.height - ySizeOfTexure)/2;
        this.buttonList.add(new GuiButton(0, posX + 40, posY +40, 100, 20, "Закрыть"));
    }

    @Override
    public void drawScreen(int x, int y, float f) {
      //drawDefaultBackground();
        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        int posX = (this.width - xSizeOfTexure)/2;
        int posY = (this.height - ySizeOfTexure)/2;
        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexure, ySizeOfTexure);

        super.drawScreen(x, y, f);
    }

     public void  actionPerformed(GuiButton button){
         switch (button.id){
         case 0: Minecraft.getMinecraft().thePlayer.closeScreen();
         break;
         default:
         }
     }

    public boolean doesGuiPauseGame()
    {
        return false;
    }
}
