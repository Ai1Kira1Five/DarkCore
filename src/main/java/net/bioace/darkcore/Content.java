package net.bioace.darkcore;


import net.bioace.darkcore.item.*;


public class Content {
    //Items

    public static ItemDC DebugWorldGen;

    //block

public static void init(){

//Items

 DebugWorldGen = new DebugWorldGen("DebugWorldGen");


//Block



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
