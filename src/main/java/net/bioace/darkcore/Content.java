package net.bioace.darkcore;


import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.bioace.darkcore.TileEntity.TEAccelerator;
import net.bioace.darkcore.TileEntity.TEHeater;
import net.bioace.darkcore.block.Accelerator;
import net.bioace.darkcore.block.BlockDC;
import net.bioace.darkcore.block.Heater;
import net.bioace.darkcore.block.TestBlock;
import net.bioace.darkcore.item.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class Content {
    //Items

    public static ItemDC DebugWorldGen;
    public static ItemDC TestItem;
    public static ItemDC magickiron_ingot;
    //block

    public static BlockDC TestBlock;
    public static BlockDC magicrock_old;
    public static BlockDC magicplank_old;
    public static BlockDC magiclog_old;
    public static BlockDC magiclog_top_old;

    public static BlockDC magicrock;
    public static BlockDC magicplank;
    public static BlockDC magiclog;
    public static BlockDC magiclog_top;
    public static BlockDC magicmetal;

    public static BlockDC Accelerator;
    public static BlockDC Heater;
public static void init(){

//Items
 DebugWorldGen = new DebugWorldGen("DebugWorldGen");
 TestItem = new ItemDC("TestItem");
 magickiron_ingot = new ItemDC("magickiron_ingot");


//Block
 TestBlock = new TestBlock("TestBlock", Material.wood);
 magicrock_old = new TestBlock("magicrock_old", Material.wood);
 magicplank_old = new TestBlock("magicplank_old", Material.wood);
 magiclog_old = new TestBlock("magiclog_old", Material.wood);
 magiclog_top_old = new TestBlock("magiclog_top_old", Material.wood);

magicrock = new TestBlock("magicrock", Material.wood);
magicplank = new TestBlock("magicplank", Material.wood);
magiclog = new TestBlock("magiclog", Material.wood);
magiclog_top = new TestBlock("magiclog_top", Material.wood);
magicmetal = new TestBlock("magicmetal", Material.wood);
Accelerator = new Accelerator("Accelerator",Material.wood);
Heater = new Heater("Heater",Material.wood);


//TileEntity
    GameRegistry.registerTileEntity(TEAccelerator.class,"Accelerator");
    GameRegistry.registerTileEntity(TEHeater.class,"Heater");
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
