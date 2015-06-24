package net.bioace.darkcore.gui;

import cpw.mods.fml.common.network.IGuiHandler;

//import net.bioace.darkcore.TileEntity.TileEntityGrinder;
import net.bioace.darkcore.Container.ContainerFurnace;
import net.bioace.darkcore.Container.ContainerGrinder;
import net.bioace.darkcore.Container.ContainerHungerAmulet;
import net.bioace.darkcore.TileEntity.TEGrinder;
import net.bioace.darkcore.item.HungerAmulet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by BIOACE on 20.09.2014.
 */
public class GuiHandler implements IGuiHandler {
   // HungerAmulet amulet;
    @Override
    public Object getServerGuiElement(int guiID, EntityPlayer player, World world, int x, int y, int z){
        TileEntity entity = world.getTileEntity(x, y, z);
       // if (entity != null) {

        switch(guiID){
            case 0:
              // if (entity instanceof TEGrinder) {
            //       return new ContainerGrinder(player.inventory, (TEGrinder) entity);
           //     }
            case 2:
                if (world.getTileEntity(x, y, z) instanceof TEFurnace) {
                    return new ContainerFurnace(player.inventory, (TEFurnace) entity);
                }
            case 3: return new ContainerHungerAmulet(player.inventory);
            default:
                return null;
        }

    }

    @Override
    public Object getClientGuiElement(int guiID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        switch(guiID){
           // case 0:
           //     if (entity instanceof TEGrinder) {
            //       return new GuiGrinder(player.inventory, (TEGrinder) entity);
           //     }


            case 2:
                if (world.getTileEntity(x, y, z) instanceof TEFurnace) {
                    return new GuiFurnace(player.inventory, (TEFurnace) entity);
                }
            case 3: return new GuiHungerAmulet(player.inventory);

            default:
               return null;
        }
    }
}