package com.wu.datagen;

import com.wu.TitaniumUpdate;
import com.wu.block.modBlocks;
import com.wu.item.modItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class modRecipesProvider extends FabricRecipeProvider {
    public modRecipesProvider(FabricDataOutput output) {
        super(output);
    }


    public static final List<ItemConvertible> TITANIUM_ORES = List.of(modBlocks.TITANIUM_ORE, modBlocks.DEEPSLATE_TITANIUM_ORE,modItems.RAW_TITANIUM);
    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        // 九宫格方块合成与逆合成
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, modItems.TITANIUM,
                RecipeCategory.MISC, modBlocks.TITANIUM_BLOCK);
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, modItems.TITANIUM_ALLOY_INGOT,
                RecipeCategory.MISC, modBlocks.TITANIUM_ALLOY_BLOCK);
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, modItems.RAW_TITANIUM,
                RecipeCategory.MISC, modBlocks.RAW_TITANIUM_BLOCK);

        // 无序合成
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.TITANIUM_ALLOY_INGOT,2)
                .input(modItems.TITANIUM)
                .input(Items.IRON_INGOT)
                .input(Items.GOLD_INGOT)
                .input(modItems.BLUEBERRIES)
                .criterion(hasItem(modItems.TITANIUM), conditionsFromItem(modItems.TITANIUM))
                .offerTo(consumer, new Identifier(TitaniumUpdate.MOD_ID, "titanium_alloy_ingot2"));

        // 有序合成
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.LAVA_COAL, 8)
                .input('#', Items.COAL)
                .input('X',Items.LAVA_BUCKET)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET))
                .offerTo(consumer, new Identifier(TitaniumUpdate.MOD_ID, "lava_coal"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE,2)
                .input('0', modItems.TITANIUM)
                .input('1', modItems.TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE)
                .input('d', Items.DIAMOND)
                .pattern("d1d")
                .pattern("d0d")
                .pattern("ddd")
                .criterion(hasItem(modItems.TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(modItems.TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(consumer, new Identifier(TitaniumUpdate.MOD_ID, "titanium_alloy_upgrade_smithing_template_copy"));
        offerHammerRecipe(consumer, modItems.TITANIUM_ALLOY_INGOT, RecipeCategory.COMBAT, modItems.TITANIUM_ALLOY_HAMMER);
        offerHammerRecipe(consumer, Items.NETHERITE_INGOT, RecipeCategory.COMBAT, modItems.NETHERITE_HAMMER);

        // 木质建筑方块
        offerAchievement(consumer, createStairsRecipe(modBlocks.PINE_STAIRS,
                Ingredient.ofItems(modBlocks.PINE_PLANKS)), "pine_stairs", modBlocks.PINE_PLANKS);
        offerAchievement(consumer, createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, modBlocks.PINE_SLAB,
                Ingredient.ofItems(modBlocks.PINE_PLANKS)), "pine_slab", modBlocks.PINE_PLANKS);
        offerAchievement(consumer, createTransmutationRecipe(modBlocks.PINE_BUTTON,
                Ingredient.ofItems(modBlocks.PINE_PLANKS)), "pine_button", modBlocks.PINE_PLANKS);
        offerAchievement(consumer, createPressurePlateRecipe(RecipeCategory.REDSTONE, modBlocks.PINE_PRESSURE_PLATE,
                Ingredient.ofItems(modBlocks.PINE_PLANKS)), "pine_pressure_plate", modBlocks.PINE_PLANKS);
        offerAchievement(consumer, createFenceRecipe(modBlocks.PINE_FENCE,
                Ingredient.ofItems(modBlocks.PINE_PLANKS)), "pine_fence", modBlocks.PINE_PLANKS);
        offerAchievement(consumer, createFenceGateRecipe(modBlocks.PINE_FENCE_GATE,
                Ingredient.ofItems(modBlocks.PINE_PLANKS)), "pine_fence_gate", modBlocks.PINE_PLANKS);
        offerAchievement(consumer, createDoorRecipe(modBlocks.PINE_DOOR,
                Ingredient.ofItems(modBlocks.PINE_PLANKS)), "pine_door", modBlocks.PINE_PLANKS);
        offerAchievement(consumer, createTrapdoorRecipe(modBlocks.PINE_TRAPDOOR,
                Ingredient.ofItems(modBlocks.PINE_PLANKS)), "pine_trapdoor", modBlocks.PINE_PLANKS);

        // 锻造
        offerTitaniumAlloyUpgradeRecipe(consumer, Items.DIAMOND_SWORD, RecipeCategory.COMBAT, modItems.TITANIUM_ALLOY_SWORD);
        offerTitaniumAlloyUpgradeRecipe(consumer, Items.DIAMOND_SHOVEL, RecipeCategory.TOOLS, modItems.TITANIUM_ALLOY_SHOVEL);
        offerTitaniumAlloyUpgradeRecipe(consumer, Items.DIAMOND_PICKAXE, RecipeCategory.TOOLS, modItems.TITANIUM_ALLOY_PICKAXE);
        offerTitaniumAlloyUpgradeRecipe(consumer, Items.DIAMOND_AXE, RecipeCategory.TOOLS, modItems.TITANIUM_ALLOY_AXE);
        offerTitaniumAlloyUpgradeRecipe(consumer, Items.DIAMOND_HOE, RecipeCategory.TOOLS, modItems.TITANIUM_ALLOY_HOE);
        offerTitaniumAlloyUpgradeRecipe(consumer, Items.DIAMOND_HELMET, RecipeCategory.COMBAT, modItems.TITANIUM_ALLOY_HELMET);
        offerTitaniumAlloyUpgradeRecipe(consumer, Items.DIAMOND_CHESTPLATE, RecipeCategory.COMBAT, modItems.TITANIUM_ALLOY_CHESTPLATE);
        offerTitaniumAlloyUpgradeRecipe(consumer, Items.DIAMOND_LEGGINGS, RecipeCategory.COMBAT, modItems.TITANIUM_ALLOY_LEGGINGS);
        offerTitaniumAlloyUpgradeRecipe(consumer, Items.DIAMOND_BOOTS, RecipeCategory.COMBAT, modItems.TITANIUM_ALLOY_BOOTS);

        // 熔炉熔炼
        offerBlasting(consumer, TITANIUM_ORES, RecipeCategory.MISC, modItems.TITANIUM, 1.0f, 150, "titanium");

        // 高炉熔炼
    }

    public static void offerHammerRecipe(Consumer<RecipeJsonProvider> exporter, Item input, RecipeCategory category, Item result) {
        ShapedRecipeJsonBuilder.create(category, result, 1)
                .input('|', Items.STICK)
                .input('X', input)
                .input('O', Items.DIAMOND)
                .pattern("XOX")
                .pattern(" | ")
                .pattern(" | ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(result) + "_hammer");
    }

    public static void offerTitaniumAlloyUpgradeRecipe(Consumer<RecipeJsonProvider> exporter, Item input, RecipeCategory category, Item result) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(modItems.TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(input), Ingredient.ofItems(modItems.TITANIUM_ALLOY_INGOT), category, result
                )
                .criterion(hasItem(modItems.TITANIUM_ALLOY_INGOT), conditionsFromItem(modItems.TITANIUM_ALLOY_INGOT))
                .offerTo(exporter, getItemPath(result) + "_smithing");
    }

    public static void offerAchievement(Consumer<RecipeJsonProvider> consumer, CraftingRecipeJsonBuilder builder, String id, ItemConvertible ingredient){
        builder.criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                .offerTo(consumer, new Identifier(TitaniumUpdate.MOD_ID, id));
    }
}