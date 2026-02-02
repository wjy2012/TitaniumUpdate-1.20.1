package com.wu.datagen;

import com.wu.TitaniumUpdate;
import com.wu.block.custom.SofaBlock;
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
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.Map;

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


        Identifier left = new Identifier(TitaniumUpdate.MOD_ID, "block/building/titanium_sofa_left");
        Identifier right = new Identifier(TitaniumUpdate.MOD_ID, "block/building/titanium_sofa_right");
        Identifier middle = new Identifier(TitaniumUpdate.MOD_ID, "block/building/titanium_sofa_middle");
        Identifier single = new Identifier(TitaniumUpdate.MOD_ID, "block/building/titanium_sofa");
        blockStateModelGenerator.blockStateCollector
                .accept(createSofaBlockState(modBlocks.TITANIUM_SOFA, left, right, middle, single));

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

    private static BlockStateSupplier createSofaBlockState(Block block, Identifier left, Identifier right, Identifier middle, Identifier single) {
        return VariantsBlockStateSupplier.create(block)
                .coordinate(
                        BlockStateVariantMap.create(SofaBlock.TYPE, Properties.HORIZONTAL_FACING)
                                .register(SofaBlock.Type.LEFT, Direction.EAST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, left).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                .register(SofaBlock.Type.LEFT, Direction.SOUTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, left).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                .register(SofaBlock.Type.LEFT, Direction.WEST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, left).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                .register(SofaBlock.Type.LEFT, Direction.NORTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, left))

                                .register(SofaBlock.Type.RIGHT, Direction.EAST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, right).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                .register(SofaBlock.Type.RIGHT, Direction.SOUTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, right).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                .register(SofaBlock.Type.RIGHT, Direction.WEST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, right).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                .register(SofaBlock.Type.RIGHT, Direction.NORTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, right))

                                .register(SofaBlock.Type.MIDDLE, Direction.EAST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, middle).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                .register(SofaBlock.Type.MIDDLE, Direction.SOUTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, middle).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                .register(SofaBlock.Type.MIDDLE, Direction.WEST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, middle).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                .register(SofaBlock.Type.MIDDLE, Direction.NORTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, middle))

                                .register(SofaBlock.Type.SINGLE, Direction.EAST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, single).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                .register(SofaBlock.Type.SINGLE, Direction.SOUTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, single).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                .register(SofaBlock.Type.SINGLE, Direction.WEST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, single).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                .register(SofaBlock.Type.SINGLE, Direction.NORTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, single))
                );
    }
}