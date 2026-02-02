package com.wu.datagen;

import com.wu.block.modBlockFamilies;
import com.wu.block.modBlocks;
import com.wu.item.modItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;

public class modModelsProvider extends FabricModelProvider {
    public modModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        modBlockFamilies.getFamilies()
                .filter(BlockFamily::shouldGenerateModels)
                .forEach(family -> blockStateModelGenerator.registerCubeAllModelTexturePool(family.getBaseBlock()).family(family));

        blockStateModelGenerator.registerSimpleCubeAll(modBlocks.TITANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(modBlocks.TITANIUM_ALLOY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(modBlocks.RAW_TITANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(modBlocks.TITANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(modBlocks.DEEPSLATE_TITANIUM_ORE);

        blockStateModelGenerator.registerLog(modBlocks.PINE_LOG).log(modBlocks.PINE_LOG).wood(modBlocks.PINE_WOOD);
        blockStateModelGenerator.registerLog(modBlocks.STRIPPED_PINE_LOG).log(modBlocks.STRIPPED_PINE_LOG).wood(modBlocks.STRIPPED_PINE_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(modBlocks.PINE_LEAVES);

        registerBush(blockStateModelGenerator, modBlocks.BLUEBERRY_BUSH);
        registerBush(blockStateModelGenerator, modBlocks.STRAWBERRY_BUSH);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(modItems.TITANIUM_ALLOY_INGOT, Models.GENERATED);
        itemModelGenerator.register(modItems.TITANIUM, Models.GENERATED);
        itemModelGenerator.register(modItems.RAW_TITANIUM, Models.GENERATED);
        itemModelGenerator.register(modItems.BLUEBERRIES, Models.GENERATED);
        itemModelGenerator.register(modItems.STRAWBERRIES, Models.GENERATED);
        itemModelGenerator.register(modItems.LAVA_COAL, Models.GENERATED);
        itemModelGenerator.register(modItems.TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(modItems.TITANIUM_ALLOY_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(modItems.NETHERITE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(modItems.TITANIUM_ALLOY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(modItems.TITANIUM_ALLOY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(modItems.TITANIUM_ALLOY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(modItems.TITANIUM_ALLOY_AXE, Models.HANDHELD);
        itemModelGenerator.register(modItems.TITANIUM_ALLOY_HOE, Models.HANDHELD);
        itemModelGenerator.register(modItems.TITANIUM_ALLOY_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) modItems.TITANIUM_ALLOY_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) modItems.TITANIUM_ALLOY_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) modItems.TITANIUM_ALLOY_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) modItems.TITANIUM_ALLOY_BOOTS);
    }


    private void registerBush(BlockStateModelGenerator generator, Block block) {
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(block)
                        .coordinate(BlockStateVariantMap.create(Properties.AGE_3)
                                .register(stage -> BlockStateVariant.create()
                                        .put(VariantSettings.MODEL,
                                                generator.createSubModel(
                                                        block, "_stage"+stage, Models.CROSS, TextureMap::cross)
                                        )
                                )
                        ));
    }
}