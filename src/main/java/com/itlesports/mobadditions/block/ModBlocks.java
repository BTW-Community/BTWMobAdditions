package com.itlesports.mobadditions.block;

import com.itlesports.mobadditions.block.onesix.FoxCompanionCubeBlock;
import com.itlesports.mobadditions.block.onesix.GlowInkBlock;
import com.itlesports.mobadditions.block.onesix.HayBlock;
import com.itlesports.mobadditions.block.onesix.LavaInkBlock;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;

public class ModBlocks{
    public static Block hayBlock;
    public static Block foxCompanionCube;
    public static Block glowInkBlock;
    public static Block lavaInkBlock;
    public static int HayBlockID = 2000;
    public static int FoxCompanionCubeID = 2001;
    public static int GlowInkBlockID = 2002;
    public static int LavaInkBlockID = 2003;
    public static void registerModBlocks() {
        hayBlock = new HayBlock(HayBlockID).setUnlocalizedName("hayBlock").setCreativeTab(CreativeTabs.tabBlock);
        foxCompanionCube = new FoxCompanionCubeBlock(FoxCompanionCubeID).setUnlocalizedName("foxCompanionCube").setCreativeTab(CreativeTabs.tabBlock);
        glowInkBlock = new GlowInkBlock(GlowInkBlockID).setUnlocalizedName("glowInkBlock").setCreativeTab(CreativeTabs.tabBlock);
        lavaInkBlock = new LavaInkBlock(LavaInkBlockID).setUnlocalizedName("lavaInkBlock").setCreativeTab(CreativeTabs.tabBlock);
    }
}
