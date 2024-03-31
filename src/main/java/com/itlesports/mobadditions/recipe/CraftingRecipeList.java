package com.itlesports.mobadditions.recipe;

import btw.crafting.recipe.RecipeManager;
import btw.item.BTWItems;
import btw.item.items.ProgressiveCraftingItem;
import com.itlesports.mobadditions.block.ModBlocks;
import com.itlesports.mobadditions.item.ModItems;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class CraftingRecipeList {
    public static void addRecipes() {
        addItemRecipes();
        addBlockRecipes();
        addMeatCuringRecipes();
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
        RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.tastySandwich, 2 ), new Object[] {
                new ItemStack( Item.bread ),
                new ItemStack( ModItems.cookedCheval )
        });
        RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.tastySandwich, 2 ), new Object[] {
                new ItemStack( Item.bread ),
                new ItemStack( ModItems.cookedFoxChop )
        });


        RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.steakAndPotatoes, 2 ), new Object[] {
                new ItemStack( Item.bakedPotato ),
                new ItemStack( ModItems.cookedCheval )
        });
        RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.steakAndPotatoes, 2 ), new Object[] {
                new ItemStack( BTWItems.boiledPotato),
                new ItemStack( ModItems.cookedCheval )
        });
        RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.steakDinner, 3 ), new Object[] {
                new ItemStack( BTWItems.boiledPotato),
                new ItemStack( BTWItems.cookedCarrot),
                new ItemStack( ModItems.cookedCheval )
        });

        RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.steakDinner, 3 ), new Object[] {
                new ItemStack( Item.bakedPotato ),
                new ItemStack( BTWItems.cookedCarrot),
                new ItemStack( ModItems.cookedCheval )
        });
        RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.wolfDinner, 3 ), new Object[] {
                new ItemStack( BTWItems.boiledPotato),
                new ItemStack( BTWItems.cookedCarrot),
                new ItemStack( ModItems.cookedFoxChop)
        });

        RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.wolfDinner, 3 ), new Object[] {
                new ItemStack( Item.bakedPotato ),
                new ItemStack( BTWItems.cookedCarrot),
                new ItemStack( ModItems.cookedFoxChop)
        });
    }
    public static void addBlockRecipes() {
        RecipeManager.addRecipe(new ItemStack(ModBlocks.foxCompanionCube, 1, 0 ), new Object[] {
                "#  ",
                "#  ",
                '#', new ItemStack(ModBlocks.foxCompanionCube, 1, 1)
        });
    }
    public static void addMeatCuringRecipes() {
        RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.curedMeat), new Object[] {
                new ItemStack( ModItems.rawCheval ), new ItemStack( BTWItems.nitre) });
        RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.curedMeat), new Object[] {
                new ItemStack( ModItems.rawFoxChop ), new ItemStack( BTWItems.nitre) });
    }
}
