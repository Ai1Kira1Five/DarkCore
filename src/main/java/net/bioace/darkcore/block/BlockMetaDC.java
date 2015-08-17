package net.bioace.darkcore.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bioace.darkcore.DarkCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;

import java.util.List;

/**
 * Created by BIOACE on 12.08.2015.
 */
public class BlockMetaDC extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon[] texture;
    String[] subBlocks;
    String name;
    public static ResourceLocation link;

    public BlockMetaDC(String name, Material material, String... subBlocks) {
        super(material);
        this.subBlocks=subBlocks;
        this.name=name;
        this.setHardness(3.5F);
        this.setResistance(5.0F);
        setCreativeTab(DarkCore.tab);
        GameRegistry.registerBlock(this,ItemMetaBlock.class, name);


    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        texture = new IIcon[subBlocks.length];
        for (int i = 0; i < subBlocks.length; i++) {
            texture[i]= iconRegister.registerIcon(DarkCore.MOD_ID.toLowerCase()+":"+name+"_"+subBlocks[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return texture[meta];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item block, CreativeTabs tabs, List list) {
        for (int i = 0; i < subBlocks.length; i++) {
            list.add(new ItemStack(block,1,i));
        }
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public String getLocalizedName() {
        return StatCollector.translateToLocal(getUnlocalizedName());
    }





}
