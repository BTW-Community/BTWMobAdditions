package com.itlesports.mobadditions.block;

import com.itlesports.mobadditions.block.onesix.HayBlock;
import net.minecraft.src.Block;

public class ModBlocks{
    public static Block hay;
    public static void registerModItems() {
        hay = new HayBlock(700);
    }
}
