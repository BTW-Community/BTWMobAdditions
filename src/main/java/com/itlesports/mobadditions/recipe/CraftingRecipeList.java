package com.itlesports.mobadditions.recipe;

import btw.crafting.recipe.RecipeManager;
import btw.item.BTWItems;
import btw.item.items.ProgressiveCraftingItem;
import com.itlesports.mobadditions.item.ModItems;
import net.minecraft.src.Item;
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
        RecipeManager.addShapelessRecipe(new ItemStack(ModItems.sinewExtractingFox, 1, ProgressiveCraftingItem.DEFAULT_MAX_DAMAGE), new Object[]{
                new ItemStack(ModItems.rawFoxChop),
                new ItemStack(ModItems.rawFoxChop),
                new ItemStack(BTWItems.sharpStone)
        });
        RecipeManager.addShapelessRecipe(new ItemStack(ModItems.sinewExtractingFox, 1, ProgressiveCraftingItem.DEFAULT_MAX_DAMAGE), new Object[]{
                new ItemStack(ModItems.cookedFoxChop),
                new ItemStack(ModItems.cookedFoxChop),
                new ItemStack(BTWItems.sharpStone)
        });
    }
    public static void addBlockRecipes() {

    }
}
