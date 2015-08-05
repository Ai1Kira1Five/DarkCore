package net.bioace.darkcore.item;

import net.bioace.darkcore.util.Log;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

/**
 * Created by BIOACE on 30.07.2015.
 */
public class DebugWorldGen extends ItemDC {
    public DebugWorldGen(String name) {
        super(name);
        ItemStack stack = new ItemStack(this);
        stack.addEnchantment(Enchantment.sharpness, 4);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float FloatX, float FloatY, float FloatZ) {
       if (!world.isRemote) {
           // Log.info(" " + x + " " + y + " " + z + " " + side + " " + FloatX + " " + FloatY + " " + FloatZ);
           //Log.info(" " + world.getChunkFromBlockCoords(x, z).getChunkCoordIntPair().chunkXPos);
           int ChunkX = world.getChunkFromBlockCoords(x, z).getChunkCoordIntPair().chunkXPos;
           int ChunkZ = world.getChunkFromBlockCoords(x, z).getChunkCoordIntPair().chunkZPos;
           int CoordX = ChunkX * 16;
           int CoordZ = ChunkZ * 16;

        //   Log.info("0");
           for (int i = 128; i >= 3; i--)
               for (int x1 = 0; x1 < 16; x1++)
                   for (int z1 = 0; z1 < 16; z1++)
                   if(world.getBlock(CoordX + x1, i, CoordZ + z1)==Blocks.grass
                      ||world.getBlock(CoordX + x1, i, CoordZ + z1)==Blocks.sand
                           ||world.getBlock(CoordX + x1, i, CoordZ + z1)==Blocks.water
                           ||world.getBlock(CoordX + x1, i, CoordZ + z1)==Blocks.lava
                           ||world.getBlock(CoordX + x1, i, CoordZ + z1)==Blocks.stone
                           ||world.getBlock(CoordX + x1, i, CoordZ + z1)==Blocks.dirt
                           ||world.getBlock(CoordX + x1, i, CoordZ + z1)==Blocks.gravel
                           ||world.getBlock(CoordX + x1, i, CoordZ + z1)==Blocks.sandstone){
                       world.setBlock(CoordX + x1, i, CoordZ + z1,Blocks.air,0,2);


           }
       }
        return true;
    }
}
