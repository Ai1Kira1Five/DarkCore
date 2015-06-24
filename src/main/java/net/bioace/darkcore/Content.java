package net.bioace.darkcore;



import cpw.mods.fml.common.registry.GameRegistry;
import net.bioace.darkcore.TileEntity.TEGrinder;
import net.bioace.darkcore.block.BlockDC;
import net.bioace.darkcore.block.BlockGrinder;
import net.bioace.darkcore.block.Furnace;
import net.bioace.darkcore.gui.TEFurnace;
import net.bioace.darkcore.item.Artefact;
import net.bioace.darkcore.item.HungerAmulet;
import net.bioace.darkcore.item.ItemDC;
import net.bioace.darkcore.item.TestItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

import java.lang.reflect.Field;

public class Content {
    //Items
    public static ItemDC test;
    public static HungerAmulet HungerAmulet;

    //block
    public static BlockDC tblock;
    public static Block BlockGrinderIdle;
    public static Block BlockGrinderActive;
    public static Artefact testArt;
    public static Block Furnace;

public static void init(){

//Items
 test = new TestItem("test");
 testArt = new Artefact("test2",0);
 HungerAmulet = new net.bioace.darkcore.item.HungerAmulet("HungerAmulet");
   // testArt = new Artefact("test2",1);
   // testArt = new Artefact("test2",2);
   // testArt = new Artefact("test2",3);

//Block
    Furnace = new Furnace("Furnace"); GameRegistry.registerBlock(Furnace,"DarkFurnace");
    tblock = new BlockDC("Grinder", Material.iron);
BlockGrinderIdle = new BlockGrinder(false).setBlockName("GrinderIdle").setCreativeTab(DarkCore.tab).setHardness(3.5F);
BlockGrinderActive = new BlockGrinder(true).setBlockName("GrinderActive").setHardness(3.5F);

    GameRegistry.registerBlock(BlockGrinderIdle, "BlockGrinderIdle");
    GameRegistry.registerBlock(BlockGrinderActive, "BlockGrinderActive");
    //TileEntities
    GameRegistry.registerTileEntity(TEGrinder.class, "Grinder");
    GameRegistry.registerTileEntity(TEFurnace.class, "DarkFurnace");
    }

/**
 public static void init(){
        for (Field field : Content.class.getFields()) {
         try {
             Object inst = field.get(null);
             if(inst instanceof ItemDC){
                 ItemDC item = (ItemDC)inst;
                 GameRegistry.registerItem(item, item.getNameForRegistry());
             }else if(inst instanceof BlockDC){
                 BlockDC block =(BlockDC)inst;
                 GameRegistry.registerBlock(block, block.getItemBlockClass(), block.getNameForRegistry());
             }
         } catch (IllegalAccessException e) {
             Log.error("Failed o register" + field.getName() + "!");
             e.printStackTrace();
         }
     }




 }
 */
}
