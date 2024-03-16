package com.itlesports.mobadditions.item;

import btw.item.BTWItems;
import com.itlesports.mobadditions.item.food.cookedFoxChopItem;
import com.itlesports.mobadditions.item.food.rawFoxChopItem;
import net.minecraft.src.*;

public class ModItems extends BTWItems {
    public static Item rawFoxChop;
    public static Item cookedFoxChop;
    public static Item glowInkSac;
    public static void registerModItems() {
        rawFoxChop = new rawFoxChopItem(700,4, 0.25F, false, "rawFoxChopItem", true );
        cookedFoxChop = new cookedFoxChopItem(701,5, 0.25F, false, "cookedFoxChopItem", false );

        glowInkSac = new glowInkSacItem(702, 1, 0.25F,false,"glowInkSacItem");
    }



}
