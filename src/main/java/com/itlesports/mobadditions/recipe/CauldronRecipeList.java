package com.itlesports.mobadditions.recipe;

import btw.crafting.recipe.RecipeManager;
import com.itlesports.mobadditions.item.ModItems;
import net.minecraft.src.ItemStack;

public class CauldronRecipeList {
    public static void addRecipes() {
        RecipeManager.addCauldronRecipe(
                new ItemStack(ModItems.cookedCheval, 1),
                new ItemStack[]{
                new ItemStack(ModItems.rawCheval)
        });
        RecipeManager.addCauldronRecipe(
                new ItemStack(ModItems.cookedFoxChop, 1),
                new ItemStack[]{
                        new ItemStack(ModItems.rawFoxChop)
                }
        );
    }
}
