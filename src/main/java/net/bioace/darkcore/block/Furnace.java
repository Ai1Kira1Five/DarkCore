package net.bioace.darkcore.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bioace.darkcore.DarkCore;
import net.bioace.darkcore.TileEntity.TEGrinder;
import net.bioace.darkcore.gui.TEFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import scala.tools.nsc.doc.model.Public;

/**
 * Created by BIOACE on 09.05.2015.
 */
public class Furnace extends BlockContainerBase {


    private boolean isActive = false;

    public Furnace(String name) {
        super(name);

    }


    public void onBlockAdded(World world, int x, int y, int z){
        super.onBlockAdded(world, x, y, z);
      }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
        TEFurnace te = (TEFurnace) world.getTileEntity(x,y,z);
        if(te==null)
            te = (TEFurnace) world.getTileEntity(x,y,z);
        if(!world.isRemote){

          player.openGui(DarkCore.instance, 2, world, te.xCoord, te.yCoord, te.zCoord);

           if (te != null) player.addChatMessage(new ChatComponentText(te.getEnergyStored(ForgeDirection.UP)+"/"+te.getMaxEnergyStored(ForgeDirection.UP)));
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TEFurnace();
    }
}
