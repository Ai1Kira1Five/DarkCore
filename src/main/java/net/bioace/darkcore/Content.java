package net.bioace.darkcore;


import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.bioace.darkcore.block.BlockDC;
import net.bioace.darkcore.block.TestBlock;
import net.bioace.darkcore.item.*;
import net.minecraft.block.material.Material;


public class Content {
    //Items

    public static ItemDC DebugWorldGen;
    public static ItemDC TestItem;
    //block

    public static BlockDC TestBlock;
    public static BlockDC magicrock;
    public static BlockDC magicplank;
    public static BlockDC magiclog;
    public static BlockDC magiclog_top;
public static void init(){

//Items
 TestItem = new ItemDC("TestItem");
 DebugWorldGen = new DebugWorldGen("DebugWorldGen");


//Block
 TestBlock = new TestBlock("TestBlock", Material.wood);
 magicrock = new TestBlock("magicrock", Material.wood);
 magicplank = new TestBlock("magicplank", Material.wood);
 magiclog = new TestBlock("magiclog", Material.wood);
 magiclog_top = new TestBlock("magiclog_top", Material.wood);
//Entity


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
