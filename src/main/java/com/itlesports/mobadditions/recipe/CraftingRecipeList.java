package com.itlesports.mobadditions.recipe;

import btw.crafting.recipe.RecipeManager;
import btw.item.BTWItems;
import com.itlesports.mobadditions.item.ModItems;
import net.minecraft.src.ItemStack;

public class CraftingRecipeList {
    public static void addRecipes() {
        addItemRecipes();
        addBlockRecipes();
    }
    public static void addItemRecipes() {
        RecipeManager.addShapelessRecipe(new ItemStack(ModItems.glowPaste, 1), new Object[]{
                new ItemStack(ModItems.glowPowder),
                new ItemStack(BTWItems.glue)
        });
        RecipeManager.addShapelessRecipe(new ItemStack(ModItems.lavaPaste, 1), new Object[]{
                new ItemStack(ModItems.lavaPowder),
                new ItemStack(BTWItems.glue)
        });
        RecipeManager.addShapelessRecipe(new ItemStack(ModItems.sinewExtractingFox, 1), new Object[]{
                new ItemStack(ModItems.rawFoxChop, 2)
        });
        RecipeManager.addShapelessRecipe(new ItemStack(ModItems.sinewExtractingFox, 1), new Object[]{
                new ItemStack(ModItems.cookedFoxChop, 2)
        });
    }
    public static void addBlockRecipes() {

    }
}
