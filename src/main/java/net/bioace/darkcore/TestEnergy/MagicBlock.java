package net.bioace.darkcore.TestEnergy;

import net.bioace.darkcore.DarkCore;
import net.bioace.darkcore.TileEntity.TEPedestal;
import net.bioace.darkcore.block.BlockContainerBase;
import net.bioace.darkcore.block.BlockDC;
import net.bioace.darkcore.gui.TEFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by BIOACE on 10.07.2015.
 */
public class MagicBlock extends BlockContainerBase {
    public MagicBlock(String name) {
        super(name);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
        TEMagicBlock te = (TEMagicBlock) world.getTileEntity(x,y,z);
        if(te==null)
            te = (TEMagicBlock) world.getTileEntity(x,y,z);
        if(!world.isRemote){

           player.openGui(DarkCore.instance, 4, world, te.xCoord, te.yCoord, te.zCoord);
           // te.storage.modifyEnergyStored(10);
            if (te != null) player.addChatMessage(new ChatComponentText(te.storage.getEnergyStored()+"/"+te.storage.getMaxEnergyStored()));
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TEMagicBlock();
    }
}
