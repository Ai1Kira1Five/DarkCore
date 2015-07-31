package net.bioace.darkcore;

import cpw.mods.fml.common.IWorldGenerator;
import net.bioace.darkcore.util.Log;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Random;

/**
 * Created by BIOACE on 26.07.2015.
 */
public class WorldGen  implements IWorldGenerator {
    private static final String __OBFID = "CL_00000429";

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        //  random.nextInt(16)
        // Log.info(chunkX+"/"+chunkZ);

        BiomeGenBase b = world.getBiomeGenForCoords(chunkX*16, chunkZ*16);

        if(b.biomeName.equals("Ocean")||b.biomeName.equals("Deep Ocean")||b.biomeName.equals("Frozen Ocean"))
           for (int i=20; i<=30; i++){
               int CoordX = chunkX * 16 + random.nextInt(16);
               int CoordZ = chunkZ * 16 + random.nextInt(16);
               if(random.nextInt(10)==1)
                   if (can_gen(world, random, CoordX, i, CoordZ)==true){
                       world.setBlock(CoordX,i,CoordZ, Blocks.iron_block);
                       Log.info("Spawn Water Cristal: " + "X=" + (int)CoordX + "  Y=" + (int)i + "  Z=" + (int)CoordZ);
                   }
           }

        if(b.biomeName.equals("Desert")||b.biomeName.equals("Savanna")||b.biomeName.equals("Mesa"))
            for (int i=8; i<=20; i++){
                int CoordX = chunkX * 16 + random.nextInt(16);
                int CoordZ = chunkZ * 16 + random.nextInt(16);
                if(random.nextInt(10)==1)
                    if (can_gen(world, random, CoordX, i, CoordZ)==true){
                        world.setBlock(CoordX,i,CoordZ, Blocks.gold_block);
                        Log.info("Spawn Fire Cristal: " + "X=" + (int)CoordX + "  Y=" + (int)i + "  Z=" + (int)CoordZ);
                    }
            }

        if(b.biomeName.equals("Plains")||b.biomeName.equals("Sunflower Plains"))
            for (int i=30; i<=64; i++){
                int CoordX = chunkX * 16 + random.nextInt(16);
                int CoordZ = chunkZ * 16 + random.nextInt(16);
                if(random.nextInt(10)==1)
                    if (can_gen(world, random, CoordX, i, CoordZ)==true){
                        world.setBlock(CoordX,i,CoordZ, Blocks.diamond_block);
                        Log.info("Spawn Air Cristal: " + "X=" + (int)CoordX + "  Y=" + (int)i + "  Z=" + (int)CoordZ);
                    }
            }
        if(b.biomeName.equals("Extreme Hills")||b.biomeName.equals("Hills")||b.biomeName.equals("Extreme Hills Edge")||b.biomeName.equals("Extreme Hills+"))
            for (int i=64; i<=100; i++){
                int CoordX = chunkX * 16 + random.nextInt(16);
                int CoordZ = chunkZ * 16 + random.nextInt(16);
                if(random.nextInt(10)==1)
                    if (can_gen(world, random, CoordX, i, CoordZ)==true){
                        world.setBlock(CoordX,i,CoordZ, Blocks.emerald_block);
                        Log.info("Spawn Earth Cristal: " + "X=" + (int)CoordX + "  Y=" + (int)i + "  Z=" + (int)CoordZ);
                    }
            }
    }



    public boolean can_gen(World world, Random random, int x, int y, int z){
        if (world.getBlock(x-1,y,z).getMaterial() == Material.rock
            &&world.getBlock(x+1,y,z).getMaterial() == Material.rock
            &&world.getBlock(x,y-1,z).getMaterial() == Material.rock
            &&world.getBlock(x,y+1,z).getMaterial() == Material.rock
            &&world.getBlock(x,y,z-1).getMaterial() == Material.rock
            &&world.getBlock(x,y,z+1).getMaterial() == Material.rock)
            return true;
        else
            return false;
    }


   }