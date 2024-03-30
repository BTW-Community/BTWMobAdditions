package com.itlesports.mobadditions.item;

import btw.item.BTWItems;
import btw.item.items.SinewExtractingItem;
import com.itlesports.mobadditions.item.food.cookedChevalItem;
import com.itlesports.mobadditions.item.food.cookedFoxChopItem;
import com.itlesports.mobadditions.item.food.rawChevalItem;
import com.itlesports.mobadditions.item.food.rawFoxChopItem;
import com.itlesports.mobadditions.item.squid.*;
import net.minecraft.src.*;

public class ModItems extends BTWItems {
    public static Item rawFoxChop;
    public static Item cookedFoxChop;
    public static Item sinewExtractingFox;
    public static Item rawCheval;
    public static Item cookedCheval;
    public static Item glowInkSac;
    public static Item lavaInkSac;
    public static Item glowPowder;
    public static Item lavaPowder;
    public static Item glowPaste;
    public static Item lavaPaste;
    public static Item horseArmorIron;
    public static Item horseArmorGold;
    public static Item horseArmorDiamond;
    public static void registerModItems() {
        rawFoxChop = new rawFoxChopItem(700,4, 0.25F, true, "rawFoxChopItem", true );
        cookedFoxChop = new cookedFoxChopItem(701,5, 0.25F, true, "cookedFoxChopItem", false );

        sinewExtractingFox = new SinewExtractingItem(702, "sinewExtractingFox");

        rawCheval = new rawChevalItem(702,4, 0.25F, false, "rawChevalItem", true );
        cookedCheval = new cookedChevalItem(703,5, 0.25F, false, "cookedChevalItem", false );

        glowInkSac = new glowInkSacItem(704, 4, 0.25F,false,"glowInkSacItem");
        lavaInkSac = new lavaInkSacItem(705, 4, 0.25F,false,"lavaInkSacItem");

        glowPowder = new glowPowderItem(706, 1, 0.1F, false, "glowPowderItem");
        lavaPowder = new lavaPowderItem(707, 1, 0.1F, false, "lavaPowderItem");

        glowPaste = new glowPasteItem(708, 4, 0.25F, false, "glowPasteItem");
        lavaPaste = new lavaPasteItem(709, 4, 0.25F, false, "lavaPasteItem");

        horseArmorIron = new Item(710).setUnlocalizedName("horseArmorIron").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
        horseArmorGold = new Item(70).setUnlocalizedName("horseArmorGold").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
        horseArmorDiamond = new Item(710).setUnlocalizedName("horseArmorDiamond").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
    }
public static void registerModBlockItems() {
        Item.suppressConflictWarnings = true;
}


}
