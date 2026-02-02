package com.wu.block;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class modBlockFamilies {
    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.<Block, BlockFamily>newHashMap();

    public static final BlockFamily PINE = register(modBlocks.PINE_PLANKS)
            .stairs(modBlocks.PINE_STAIRS)
            .slab(modBlocks.PINE_SLAB)
            .button(modBlocks.PINE_BUTTON)
            .pressurePlate(modBlocks.PINE_PRESSURE_PLATE)
            .fence(modBlocks.PINE_FENCE)
            .fenceGate(modBlocks.PINE_FENCE_GATE)
            .door(modBlocks.PINE_DOOR)
            .trapdoor(modBlocks.PINE_TRAPDOOR)
            .build();

    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = (BlockFamily)BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getFamilies() {
        return BASE_BLOCKS_TO_FAMILIES.values().stream();
    }
}