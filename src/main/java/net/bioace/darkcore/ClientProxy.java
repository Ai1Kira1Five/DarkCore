package net.bioace.darkcore;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.bioace.darkcore.Render.RenderCrystal;
import net.bioace.darkcore.Render.RenderItemCrystal;
import net.bioace.darkcore.TileEntity.TECrystal;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by BIOACE on 18.04.2015.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
        ClientRegistry.bindTileEntitySpecialRenderer(TECrystal.class, new RenderCrystal());
       MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Content.Crystal), new RenderItemCrystal());

    }
}
