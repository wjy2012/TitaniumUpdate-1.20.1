package com.wu.datagen;

import com.wu.block.modBlocks;
import com.wu.item.modItemGroups;
import com.wu.item.modItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class modEnUsLangProvider extends FabricLanguageProvider {
    public modEnUsLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(modItems.RAW_TITANIUM, "Raw Titanium");
        translationBuilder.add(modItems.TITANIUM_ALLOY_INGOT, "Titanium Alloy Ingot");
        translationBuilder.add(modItems.TITANIUM, "Titanium");
        translationBuilder.add(modItems.TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE, "Smithing Template");
        translationBuilder.add(modItems.BLUEBERRIES, "Blueberry");
        translationBuilder.add(modItems.STRAWBERRIES, "Strawberry");
        translationBuilder.add(modItems.LAVA_COAL, "Lava Coal");
        translationBuilder.add(modItems.NETHERITE_HAMMER, "Netherite Hammer");
        translationBuilder.add(modItems.TITANIUM_ALLOY_SWORD, "Titanium Alloy Sword");
        translationBuilder.add(modItems.TITANIUM_ALLOY_SHOVEL, "Titanium Alloy Shovel");
        translationBuilder.add(modItems.TITANIUM_ALLOY_PICKAXE, "Titanium Alloy Pickaxe");
        translationBuilder.add(modItems.TITANIUM_ALLOY_AXE, "Titanium Alloy Axe");
        translationBuilder.add(modItems.TITANIUM_ALLOY_HOE, "Titanium Alloy Hoe");
        translationBuilder.add(modItems.TITANIUM_ALLOY_HAMMER, "Titanium Alloy Hammer");
        translationBuilder.add(modItems.TITANIUM_ALLOY_HELMET, "Titanium Alloy Helmet");
        translationBuilder.add(modItems.TITANIUM_ALLOY_CHESTPLATE, "Titanium Alloy Chestplate");
        translationBuilder.add(modItems.TITANIUM_ALLOY_LEGGINGS, "Titanium Alloy Leggings");
        translationBuilder.add(modItems.TITANIUM_ALLOY_BOOTS, "Titanium Alloy Boots");
        translationBuilder.add(modItems.TITANIUM_ALLOY_HORSE_ARMOR, "Titanium Alloy Horse Armor");

        translationBuilder.add(modBlocks.TITANIUM_BLOCK, "Titanium Block");
        translationBuilder.add(modBlocks.TITANIUM_ALLOY_BLOCK, "Titanium Alloy Block");
        translationBuilder.add(modBlocks.TITANIUM_ORE, "Titanium Ore");
        translationBuilder.add(modBlocks.DEEPSLATE_TITANIUM_ORE, "Deepslate Titanium Ore");
        translationBuilder.add(modBlocks.RAW_TITANIUM_BLOCK, "Raw Titanium Block");
        translationBuilder.add(modBlocks.BLUEBERRY_BUSH, "Blueberry Bush");
        translationBuilder.add(modBlocks.STRAWBERRY_BUSH, "Strawberry Bush");
        translationBuilder.add(modBlocks.PINE_LOG, "Pine Log");
        translationBuilder.add(modBlocks.PINE_WOOD, "Pine Wood");
        translationBuilder.add(modBlocks.STRIPPED_PINE_LOG, "Stripped Pine Log");
        translationBuilder.add(modBlocks.STRIPPED_PINE_WOOD, "Stripped Pine Wood");
        translationBuilder.add(modBlocks.PINE_LEAVES, "Pine Leaves");
        translationBuilder.add(modBlocks.PINE_PLANKS, "Pine Planks");
        translationBuilder.add(modBlocks.PINE_STAIRS, "Pine Stairs");
        translationBuilder.add(modBlocks.PINE_SLAB, "Pine Slab");
        translationBuilder.add(modBlocks.PINE_BUTTON, "Pine Button");
        translationBuilder.add(modBlocks.PINE_PRESSURE_PLATE, "Pine Pressure Plate");
        translationBuilder.add(modBlocks.PINE_FENCE, "Pine Fence");
        translationBuilder.add(modBlocks.PINE_FENCE_GATE, "Pine Fence Gate");
        translationBuilder.add(modBlocks.PINE_DOOR, "Pine Door");
        translationBuilder.add(modBlocks.PINE_TRAPDOOR, "Pine Trapdoor");

        translationBuilder.add("entity.minecraft.villager.titanium_alloy_scientist", "Titanium Alloy Scientist");

        translationBuilder.add("sounds.titanium-update.hammer_use", "Hammer : Use");

        translationBuilder.add(modItemGroups.TITANIUM_UPDATE_ITEM, "Titanium Update");
        translationBuilder.add(modItemGroups.TITANIUM_UPDATE_BLOCK, "Titanium Update");

        translationBuilder.add("tooltip.titanium-update.titanium_hammer.shift", "§7It has the functions of both a pickaxe and an axe§r");
        translationBuilder.add("tooltip.titanium-update.titanium_hammer", "Press §6§n§lSHIFT§r§r§r for more information");
        translationBuilder.add("tooltip.titanium-update.titanium_alloy_upgrade_smithing_template", "§7Titanium Alloy Upgrade§r");
    }
}