package net.bioace.darkcore.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by BIOACE on 03.08.2015.
 */
public abstract class BlockContainerDC extends BlockDC implements ITileEntityProvider {
    public BlockContainerDC(String name, Material material) {
        super(name, material);
        this.isBlockContainer = true;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        super.breakBlock(world, x, y, z, block, meta);
        world.removeTileEntity(x, y, z);
    }

    public boolean onBlockEventReceived(World world, int x, int y, int z, int number, int argument)
    {
        super.onBlockEventReceived(world, x, y, z, number, argument);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null ? tileentity.receiveClientEvent(number, argument) : false;
    }

    @Override
    public abstract TileEntity createNewTileEntity(World world, int i);
}
