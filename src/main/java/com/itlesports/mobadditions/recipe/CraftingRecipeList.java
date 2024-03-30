package com.itlesports.mobadditions.recipe;

import btw.crafting.recipe.RecipeManager;
import btw.item.BTWItems;
import com.itlesports.mobadditions.item.ModItems;
import net.minecraft.src.ItemStack;

import java.nio.charset.StandardCharsets;

public class CraftingRecipeList {
    public static void addRecipes() {
        addItemRecipes();
        addBlockRecipes();
    }
    public static void addItemRecipes() {
        RecipeManager.addRecipe(new ItemStack(ModItems.glowPaste, 1), new Object[]{
                "PG",
                "P", ModItems.glowPowder,
                "G", BTWItems.glue
        });
        RecipeManager.addRecipe(new ItemStack(ModItems.lavaPaste, 1), new Object[]{
                "PG",
                "P", ModItems.lavaPowder,
                "G", BTWItems.glue
        });
    }
    public static void addBlockRecipes() {

    }
}
