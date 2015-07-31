package net.bioace.darkcore;

import cpw.mods.fml.common.Mod;
import net.bioace.darkcore.util.Log;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

/**
 * Created by BIOACE on 28.06.2015.
 */
public class Event_Handler {

  //  @Mod.EventHandler
    public void LivingHurtEvent(LivingHurtEvent event){
        Log.info("Attack Event");
      event.ammount=event.ammount+10;

    }
}
