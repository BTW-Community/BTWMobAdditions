package com.itlesports.mobadditions.item;

import btw.item.items.FoodItem;
import net.minecraft.src.*;

public class lavaInkSacItem extends FoodItem {

    public lavaInkSacItem(int iItemID, int iHungerHealed, float fSaturationModifier, boolean bWolfMeat, String sItemName) {
        super(iItemID, iHungerHealed, fSaturationModifier, bWolfMeat, sItemName);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setPotionEffect(Potion.nightVision.id, 5, 0, 1.0F);
    }

    public ItemStack onEaten(ItemStack var1, World var2, EntityPlayer var3) {
        super.onEaten(var1, var2, var3);
        var3.addPotionEffect(new PotionEffect(Potion.hunger.id, 5 * 20, 0));

        return var1;
    }
}
