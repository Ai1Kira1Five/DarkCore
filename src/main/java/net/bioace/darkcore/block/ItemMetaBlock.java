package net.bioace.darkcore.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by BIOACE on 13.08.2015.
 */
public class ItemMetaBlock extends ItemBlock {
    BlockMetaDC block;
    public ItemMetaBlock(Block block) {
        super(block);
        this.setHasSubtypes(true);
       // if (block instanceof BlockMetaDC)
        this.block=(BlockMetaDC) block;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int i = stack.getItemDamage();
        if (i<0 || i>= block.subBlocks.length){
            i=0;
        }
        return super.getUnlocalizedName()+"."+block.subBlocks[i];
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
