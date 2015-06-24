package net.bioace.darkcore.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bioace.darkcore.DarkCore;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by BIOACE on 11.05.2015.
 */
public class BlockContainerBase extends BlockContainer {
    @SideOnly(Side.CLIENT)
    private IIcon iconFront;
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconSide;
    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;
    private String name;
    private boolean isActive=true;

    protected BlockContainerBase(String name) {
        super(Material.iron);
        this.name=name;
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.iconSide = iconRegister.registerIcon(DarkCore.MOD_ID + ":" +name+"Side");
        this.iconFront = iconRegister.registerIcon(DarkCore.MOD_ID + ":"+name+(this.isActive ? "FrontOn" : "FrontOff"));
        this.iconTop = iconRegister.registerIcon(DarkCore.MOD_ID + ":" +name+ "Top");
        this.iconBottom = iconRegister.registerIcon(DarkCore.MOD_ID + ":" +name+ "Bottom");

    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata){
        return side == 1 ? this.iconTop :
                (side == 0 ? this.iconBottom :
                        (side != metadata ? this.iconSide : this.iconFront));
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack){
        int l = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.F) + 0.5D) & 3;

        if(l == 0){
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if(l == 1){
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if(l == 2){
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if(l == 3){
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return null;
    }
}
