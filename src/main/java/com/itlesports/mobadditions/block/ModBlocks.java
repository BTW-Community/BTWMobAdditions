package com.itlesports.mobadditions.block;

import com.itlesports.mobadditions.block.onesix.HayBlock;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;

public class ModBlocks{
    public static Block hayBlock;
    public static void registerModBlocks() {
        hayBlock = new HayBlock(2000).setUnlocalizedName("hayBlock").setCreativeTab(CreativeTabs.tabBlock);
    }
}
