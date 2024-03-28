package com.itlesports.mobadditions.item;

import btw.item.BTWItems;
import com.itlesports.mobadditions.block.ModBlocks;
import com.itlesports.mobadditions.item.food.cookedChevalItem;
import com.itlesports.mobadditions.item.food.cookedFoxChopItem;
import com.itlesports.mobadditions.item.food.rawChevalItem;
import com.itlesports.mobadditions.item.food.rawFoxChopItem;
import net.minecraft.src.*;

public class ModItems extends BTWItems {
    public static Item rawFoxChop;
    public static Item cookedFoxChop;
    public static Item rawCheval;
    public static Item cookedCheval;
    public static Item glowInkSac;
    public static Item horseArmorIron;
    public static Item horseArmorGold;
    public static Item horseArmorDiamond;
    public static void registerModItems() {
        rawFoxChop = new rawFoxChopItem(700,4, 0.25F, true, "rawFoxChopItem", true );
        cookedFoxChop = new cookedFoxChopItem(701,5, 0.25F, true, "cookedFoxChopItem", false );
        rawCheval = new rawChevalItem(702,4, 0.25F, false, "rawChevalItem", true );
        cookedCheval = new cookedChevalItem(703,5, 0.25F, false, "cookedChevalItem", false );

        glowInkSac = new glowInkSacItem(704, 1, 0.25F,false,"glowInkSacItem");

        horseArmorIron = new Item(705).setUnlocalizedName("horseArmorIron").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
        horseArmorGold = new Item(706).setUnlocalizedName("horseArmorGold").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
        horseArmorDiamond = new Item(707).setUnlocalizedName("horseArmorDiamond").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    }
public static void registerModBlockItems() {
        Item.suppressConflictWarnings = true;
}


}
