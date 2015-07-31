package net.bioace.darkcore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;



@Mod(modid = DarkCore.MOD_ID,version = DarkCore.VERSION)
public class DarkCore {
	
	public static final String MOD_ID = "darkcore";
	public static final String VERSION = "0.0.1";
    public static CreativeTabs tab = new CreativeTabs("DarkCore") {
        @Override
        public Item getTabIconItem() {
            return Items.saddle;
        }
    };



    @Mod.Instance
	public static DarkCore instance;
   // @SidedProxy(clientSide = "net.bioace.darkcore.ClientProxy", serverSide = "net.bioace.darkcore.CommonProxy")
   // public static CommonProxy proxy;


	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
      Content.init();

	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event){
        GameRegistry.registerWorldGenerator(new WorldGen(), 0);

	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){


	}

}
