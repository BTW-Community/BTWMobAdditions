package com.itlesports.mobadditions.recipe;

import btw.crafting.recipe.RecipeManager;
import com.itlesports.mobadditions.item.ModItems;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class MillstoneRecipeList {
    public static void addRecipes() {
        RecipeManager.addMillStoneRecipe(new ItemStack(ModItems.glowPowder.itemID, 2, 0), new ItemStack(ModItems.glowInkSac));
        RecipeManager.addMillStoneRecipe(new ItemStack(ModItems.lavaPowder.itemID, 2, 0), new ItemStack(ModItems.lavaInkSac));
    }
}
