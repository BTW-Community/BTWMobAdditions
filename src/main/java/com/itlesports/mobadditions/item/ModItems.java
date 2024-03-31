package com.itlesports.mobadditions.item;

import btw.item.BTWItems;
import btw.item.items.SinewExtractingItem;
import com.itlesports.mobadditions.block.onesix.CompanionCubeFox;
import com.itlesports.mobadditions.item.blockitem.FoxCompanionCubeBlockItem;
import com.itlesports.mobadditions.item.blockitem.HayBlockItem;
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

        sinewExtractingFox = new SinewExtractingItem(702, "sinewExtractingFoxItem").setUnlocalizedName("sinewExtractingFoxItem");

        rawCheval = new rawChevalItem(703,4, 0.25F, false, "rawChevalItem", true );
        cookedCheval = new cookedChevalItem(704,5, 0.25F, false, "cookedChevalItem", false );

        glowInkSac = new glowInkSacItem(705, 4, 0.25F,false,"glowInkSacItem");
        lavaInkSac = new lavaInkSacItem(706, 4, 0.25F,false,"lavaInkSacItem");

        glowPowder = new glowPowderItem(707, 1, 0.1F, false, "glowPowderItem");
        lavaPowder = new lavaPowderItem(708, 1, 0.1F, false, "lavaPowderItem");

        glowPaste = new glowPasteItem(709, 4, 0.25F, false, "glowPasteItem");
        lavaPaste = new lavaPasteItem(710, 4, 0.25F, false, "lavaPasteItem");

        horseArmorIron = new Item(711).setUnlocalizedName("horseArmorIron").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
        horseArmorGold = new Item(712).setUnlocalizedName("horseArmorGold").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
        horseArmorDiamond = new Item(713).setUnlocalizedName("horseArmorDiamond").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc);
        ModItems.createAssociatedItemsForModBlocks();
    }
    private static void createAssociatedItemsForModBlocks()
    {
        registerModBlockItems();

        for (int iTempBlockID = 0; iTempBlockID < 4096; iTempBlockID++)
        {
            if (Block.blocksList[iTempBlockID] != null && Item.itemsList[iTempBlockID] == null)
            {
                Item.itemsList[iTempBlockID] = new ItemBlock(iTempBlockID - 256);
            }
        }

    }
    public static void registerModBlockItems() {
        Item.suppressConflictWarnings = true;
        Item.itemsList[2000] = new HayBlockItem( 2000 - 256);
        Item.itemsList[2001] = new FoxCompanionCubeBlockItem( 2001 - 256);
    }

}
