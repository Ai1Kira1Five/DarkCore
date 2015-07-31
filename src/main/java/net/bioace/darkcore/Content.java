package net.bioace.darkcore;



import cpw.mods.fml.common.registry.GameRegistry;
import net.bioace.darkcore.TestEnergy.DebugEnergy;
import net.bioace.darkcore.TestEnergy.MagicBlock;
import net.bioace.darkcore.TestEnergy.TEMagicBlock;
import net.bioace.darkcore.TileEntity.TEGrinder;
import net.bioace.darkcore.TileEntity.TEPedestal;
import net.bioace.darkcore.block.BlockDC;
import net.bioace.darkcore.block.BlockGrinder;
import net.bioace.darkcore.block.Furnace;
import net.bioace.darkcore.block.Pedestal;
import net.bioace.darkcore.gui.TEFurnace;
import net.bioace.darkcore.item.*;
import net.bioace.darkcore.item.Ring.RingHPRegen;
import net.bioace.darkcore.item.Ring.RingOfPower;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityList;

public class Content {
    //Items
    public static ItemDC test;
    public static HungerAmulet HungerAmulet;
    public static ItemDC RingHPRegen;
    public static ItemDC RingOfPower;
    public static ItemDC DebugEnergy;
    public static ItemDC DebugWorldGen;

    //block
    public static BlockDC tblock;
    public static Block BlockGrinderIdle;
    public static Block BlockGrinderActive;
    public static Artefact testArt;
    public static Block Furnace;
    public static Block Pedestal;
    public static Block MagicBlock;
public static void init(){

//Items
 test = new TestItem("test");
 testArt = new Artefact("test2",0);
 HungerAmulet = new HungerAmulet("HungerAmulet");
 RingHPRegen = new RingHPRegen("RingHPRegen");
 RingOfPower = new RingOfPower("RingOfPower");
 DebugEnergy = new DebugEnergy("DebugEnergy");
 DebugWorldGen = new DebugWorldGen("DebugWorldGen");
   // testArt = new Artefact("test2",1);
   // testArt = new Artefact("test2",2);
   // testArt = new Artefact("test2",3);

//Block
    MagicBlock = new MagicBlock("MagicBlock"); GameRegistry.registerBlock(MagicBlock,"MagicBlock");
    Furnace = new Furnace("Furnace"); GameRegistry.registerBlock(Furnace,"DarkFurnace");
    Pedestal = new Pedestal("Pedestal", Material.rock);
    tblock = new BlockDC("Grinder", Material.iron);
BlockGrinderIdle = new BlockGrinder(false).setBlockName("GrinderIdle").setCreativeTab(DarkCore.tab).setHardness(3.5F);
BlockGrinderActive = new BlockGrinder(true).setBlockName("GrinderActive").setHardness(3.5F);


    //Entity
    EntityList.addMapping(Golem.class, "Golem", 111, 0x0033FF, 0x00CCFF);

    GameRegistry.registerBlock(BlockGrinderIdle, "BlockGrinderIdle");
    GameRegistry.registerBlock(BlockGrinderActive, "BlockGrinderActive");
    //TileEntities
    GameRegistry.registerTileEntity(TEMagicBlock.class, "MagicBlock");
    GameRegistry.registerTileEntity(TEGrinder.class, "Grinder");
    GameRegistry.registerTileEntity(TEFurnace.class, "DarkFurnace");
    GameRegistry.registerTileEntity(TEPedestal.class, "Pedestal");

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
