package net.bioace.darkcore.util;

import org.apache.logging.log4j.Level;

import net.bioace.darkcore.DarkCore;

import cpw.mods.fml.common.FMLLog;

public class Log{
	public static void Log(Level lvl, Object obj){
		FMLLog.log(DarkCore.MOD_ID, lvl, String.valueOf(obj)) ;
 }
  public static void fatal(Object obj) {
	  Log(Level.FATAL, obj);
  }
  
  public static void error(Object obj) {
	  Log(Level.ERROR, obj);
  }
  
  public static void warn(Object obj) {
	  Log(Level.WARN, obj);
  }
  public static void info(Object obj) {
	  Log(Level.INFO, obj);
  }
  public static void debug(Object obj) {
	  Log(Level.DEBUG, obj);
  }
  public static void trace(Object obj) {
	  Log(Level.TRACE, obj);
  }
   
}
