package net.bioace.darkcore.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Random;

/**
 * Created by BIOACE on 30.06.2015.
 */
public class MiscUtils {
    @SideOnly(Side.CLIENT)
    public static void renderItemStack_Full(ItemStack stk,double posX, double posY, double posZ, double screenPosX, double screenPosY, double screenPosZ, float rotation, float rotationZ, float colorRed, float colorGreen, float colorBlue, float offsetX, float offsetY, float offsetZ)
    {
        if(stk != null)
        {
            ItemStack itemstack = stk.copy();
            itemstack.stackSize = 1; //Doing this so no weird glitches occur.
            new ResourceLocation("textures/misc/enchanted_item_glint.png");
            RenderBlocks renderBlocksRi = new RenderBlocks();
            Random random = new Random();
            boolean renderWithColor = true;
            if (itemstack != null && itemstack.getItem() != null)
            {
                Minecraft.getMinecraft().renderEngine.bindTexture(Minecraft.getMinecraft().renderEngine.getResourceLocation(stk.getItemSpriteNumber()));
                TextureUtil.func_152777_a(false, false, 1.0F);
                random.setSeed(187L);
                GL11.glPushMatrix();
                float f2 = rotationZ;
                float f3 = rotation;
                byte b0 = 1;

                if (stk.stackSize > 1)
                {
                    b0 = 2;
                }

                if (stk.stackSize > 5)
                {
                    b0 = 3;
                }

                if (stk.stackSize > 20)
                {
                    b0 = 4;
                }

                if (stk.stackSize > 40)
                {
                    b0 = 5;
                }

                GL11.glTranslated((float)screenPosX+offsetX, (float)screenPosY+offsetY, (float)screenPosZ+offsetZ);
                GL11.glEnable(GL12.GL_RESCALE_NORMAL);
                float f6;
                float f7;
                int k;
                EntityItem fakeItem = new EntityItem(Minecraft.getMinecraft().theWorld, posX, posY, posZ, stk);
                GL11.glRotatef(f2, 0, 0, 1);
                if (ForgeHooksClient.renderEntityItem(fakeItem, itemstack, f2, f3, random, Minecraft.getMinecraft().renderEngine, renderBlocksRi, b0))
                {
                    ;
                }
                else if (itemstack.getItemSpriteNumber() == 0 && itemstack.getItem() instanceof ItemBlock && RenderBlocks.renderItemIn3d(Block.getBlockFromItem(itemstack.getItem()).getRenderType()))
                {
                    Block block = Block.getBlockFromItem(itemstack.getItem());
                    GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);
                    float f9 = 0.25F;
                    k = block.getRenderType();

                    if (k == 1 || k == 19 || k == 12 || k == 2)
                    {
                        f9 = 0.5F;
                    }

                    if (block.getRenderBlockPass() > 0)
                    {
                        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
                        GL11.glEnable(GL11.GL_BLEND);
                        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                    }

                    GL11.glScalef(f9, f9, f9);

                    for (int l = 0; l < b0; ++l)
                    {
                        GL11.glPushMatrix();

                        if (l > 0)
                        {
                            f6 = (random.nextFloat() * 2.0F - 1.0F) * 0.2F / f9;
                            f7 = (random.nextFloat() * 2.0F - 1.0F) * 0.2F / f9;
                            float f8 = (random.nextFloat() * 2.0F - 1.0F) * 0.2F / f9;
                            GL11.glTranslatef(f6, f7, f8);
                        }

                        renderBlocksRi.renderBlockAsItem(block, itemstack.getItemDamage(), 1.0F);
                        GL11.glPopMatrix();
                    }

                    if (block.getRenderBlockPass() > 0)
                    {
                        GL11.glDisable(GL11.GL_BLEND);
                    }
                }
                else
                {
                    if (itemstack.getItem().requiresMultipleRenderPasses())
                    {
                        GL11.glScalef(0.5F, 0.5F, 0.5F);
                        for (int j = 0; j < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); ++j)
                        {
                            random.setSeed(187L);
                            itemstack.getItem().getIcon(itemstack, j);
                            renderItemStack(stk, posX, posY, posZ, screenPosX, screenPosY, screenPosZ, rotation, colorRed, colorGreen, colorBlue, j, stk.stackSize);
                        }
                    }
                    else
                    {
                        if (itemstack != null && itemstack.getItem() instanceof ItemCloth)
                        {
                            GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
                            GL11.glEnable(GL11.GL_BLEND);
                            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                        }
                        GL11.glScalef(0.5F, 0.5F, 0.5F);
                        itemstack.getIconIndex();

                        if (renderWithColor)
                        {
                            renderItemStack(stk, posX, posY, posZ, screenPosX, screenPosY, screenPosZ, rotation, colorRed, colorGreen, colorBlue, 0, stk.stackSize);
                        }
                        if (itemstack != null && itemstack.getItem() instanceof ItemCloth)
                        {
                            GL11.glDisable(GL11.GL_BLEND);
                        }
                    }
                }
                fakeItem = null;
                GL11.glDisable(GL12.GL_RESCALE_NORMAL);
                GL11.glPopMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(Minecraft.getMinecraft().renderEngine.getResourceLocation(stk.getItemSpriteNumber()));
                TextureUtil.func_147945_b();
            }
            itemstack = null; //Again, there is a gc for that, but removing possible leaks is never a bad thing to do...
        }
    }

    /**
     * Sub-function to the first one. You shouldn't use this, however it is also possible.
     * @param stk - ItemStack you wish to render
     * @param posX - xCoord in the world
     * @param posY - yCoord in the world
     * @param posZ - zCoord in the world
     * @param screenPosX - x position on the screen(given by render)
     * @param screenPosY - y position on the screen(given by render)
     * @param screenPosZ - z position on the screen(given by render)
     * @param rotation - the X axis rotation
     * @param colorRed - red color index(0.0F is 0% and 1.0F is 100%)
     * @param colorGreen - green color index(0.0F is 0% and 1.0F is 100%)
     * @param colorBlue - blue color index(0.0F is 0% and 1.0F is 100%)
     * @param renderPass - the render pass of the ItemStack(is 0 for most of them, however may depend)
     * @param itemsAmount - the amount of items in the ItemStack(or actually ItemStack.stackSize)
     */

    @SideOnly(Side.CLIENT)
    public static void renderItemStack(ItemStack stk,double posX, double posY, double posZ, double screenPosX, double screenPosY, double screenPosZ, float rotation, float colorRed, float colorGreen, float colorBlue, int renderPass, int itemsAmount)
    {
        final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
        new RenderBlocks();
        Random random = new Random();
        IIcon p_77020_2_ = stk.getItem().getIcon(stk, renderPass);

        Tessellator tessellator = Tessellator.instance;

        if (p_77020_2_ == null)
        {
            TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
            ResourceLocation resourcelocation = texturemanager.getResourceLocation(stk.getItem().getSpriteNumber());
            p_77020_2_ = ((TextureMap)texturemanager.getTexture(resourcelocation)).getAtlasSprite("missingno");
        }

        float f14 = ((IIcon)p_77020_2_).getMinU();
        float f15 = ((IIcon)p_77020_2_).getMaxU();
        float f4 = ((IIcon)p_77020_2_).getMinV();
        float f5 = ((IIcon)p_77020_2_).getMaxV();
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.25F;
        float f10;

        if (Minecraft.getMinecraft().gameSettings.fancyGraphics)
        {
            GL11.glPushMatrix();
            GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
            float f9 = 0.0625F;
            f10 = 0.021875F;
            ItemStack itemstack = stk;
            int j = itemstack.stackSize;
            byte b0;

            if (j < 2)
            {
                b0 = 1;
            }
            else if (j < 16)
            {
                b0 = 2;
            }
            else if (j < 32)
            {
                b0 = 3;
            }
            else
            {
                b0 = 4;
            }

            GL11.glTranslatef(-f7, -f8, -((f9 + f10) * (float)b0 / 2.0F));

            for (int k = 0; k < b0; ++k)
            {
                if (k > 0)
                {
                    float x = (random.nextFloat() * 2.0F - 1.0F) * 0.3F / 0.5F;
                    float y = (random.nextFloat() * 2.0F - 1.0F) * 0.3F / 0.5F;
                    random.nextFloat();
                    GL11.glTranslatef(x, y, f9 + f10);
                }
                else
                {
                    GL11.glTranslatef(0f, 0f, f9 + f10);
                }

                if (itemstack.getItemSpriteNumber() == 0)
                {
                    Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
                }
                else
                {
                    Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
                }

                GL11.glColor4f(colorRed, colorGreen, colorBlue, 1.0F);
                ItemRenderer.renderItemIn2D(tessellator, f15, f4, f14, f5, ((IIcon)p_77020_2_).getIconWidth(), ((IIcon)p_77020_2_).getIconHeight(), f9);

                if (itemstack.hasEffect(renderPass))
                {
                    GL11.glDepthFunc(GL11.GL_EQUAL);
                    GL11.glDisable(GL11.GL_LIGHTING);
                    Minecraft.getMinecraft().renderEngine.bindTexture(RES_ITEM_GLINT);
                    GL11.glEnable(GL11.GL_BLEND);
                    GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
                    float f11 = 0.76F;
                    GL11.glColor4f(0.5F * f11, 0.25F * f11, 0.8F * f11, 1.0F);
                    GL11.glMatrixMode(GL11.GL_TEXTURE);
                    GL11.glPushMatrix();
                    float f12 = 0.125F;
                    GL11.glScalef(f12, f12, f12);
                    float f13 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
                    GL11.glTranslatef(f13, 0.0F, 0.0F);
                    GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
                    ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f9);
                    GL11.glPopMatrix();
                    GL11.glPushMatrix();
                    GL11.glScalef(f12, f12, f12);
                    f13 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
                    GL11.glTranslatef(-f13, 0.0F, 0.0F);
                    GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
                    ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f9);
                    GL11.glPopMatrix();
                    GL11.glMatrixMode(GL11.GL_MODELVIEW);
                    GL11.glDisable(GL11.GL_BLEND);
                    GL11.glEnable(GL11.GL_LIGHTING);
                    GL11.glDepthFunc(GL11.GL_LEQUAL);
                }
            }

            GL11.glPopMatrix();
        }
        else
        {
            for (int l = 0; l < itemsAmount; ++l)
            {
                GL11.glPushMatrix();

                if (l > 0)
                {
                    f10 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f16 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f17 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    GL11.glTranslatef(f10, f16, f17);
                }
                GL11.glColor4f(colorRed, colorGreen, colorBlue, 1.0F);
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 1.0F, 0.0F);
                tessellator.addVertexWithUV((double)(0.0F - f7), (double)(0.0F - f8), 0.0D, (double)f14, (double)f5);
                tessellator.addVertexWithUV((double)(f6 - f7), (double)(0.0F - f8), 0.0D, (double)f15, (double)f5);
                tessellator.addVertexWithUV((double)(f6 - f7), (double)(1.0F - f8), 0.0D, (double)f15, (double)f4);
                tessellator.addVertexWithUV((double)(0.0F - f7), (double)(1.0F - f8), 0.0D, (double)f14, (double)f4);
                tessellator.draw();
                GL11.glPopMatrix();
            }
        }
    }

    /**
     * Clones the given Entity, including it's full NBTTag
     * @param e - the entity to clone
     * @return The cloned entity
     */
    public static Entity cloneEntity(Entity e)
    {
        Entity retEntity = null;
        try
        {
            retEntity = e.getClass().getConstructor(World.class).newInstance(e.worldObj);
            retEntity.copyDataFrom(e, true);
        }
        catch(Exception exc)
        {
            return retEntity;
        }
        return retEntity;
    }

}
