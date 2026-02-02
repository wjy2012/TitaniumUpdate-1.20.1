package com.wu.datagen;

import com.wu.block.modBlocks;
import com.wu.tag.modBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class modBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public modBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(modBlocks.TITANIUM_ORE)
                .add(modBlocks.DEEPSLATE_TITANIUM_ORE)
                .add(modBlocks.RAW_TITANIUM_BLOCK)
                .add(modBlocks.TITANIUM_BLOCK)
                .add(modBlocks.TITANIUM_ALLOY_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(modBlocks.TITANIUM_ORE)
                .add(modBlocks.DEEPSLATE_TITANIUM_ORE)
                .add(modBlocks.RAW_TITANIUM_BLOCK)
                .add(modBlocks.TITANIUM_BLOCK)
                .add(modBlocks.TITANIUM_ALLOY_BLOCK);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .forceAddTag(modBlockTags.PINE_LOGS);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(modBlocks.PINE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(modBlocks.PINE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(modBlocks.PINE_PLANKS);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).forceAddTag(modBlockTags.MOD_BUSHES);
        getOrCreateTagBuilder(BlockTags.FALL_DAMAGE_RESETTING).forceAddTag(modBlockTags.MOD_BUSHES);
        getOrCreateTagBuilder(BlockTags.BEE_GROWABLES).forceAddTag(modBlockTags.MOD_BUSHES);
        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT).forceAddTag(modBlockTags.MOD_BUSHES);


        getOrCreateTagBuilder(modBlockTags.PINE_LOGS)
                .add(modBlocks.PINE_LOG)
                .add(modBlocks.PINE_WOOD)
                .add(modBlocks.STRIPPED_PINE_LOG)
                .add(modBlocks.STRIPPED_PINE_WOOD);
        getOrCreateTagBuilder(modBlockTags.HAMMER_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE);
        getOrCreateTagBuilder(modBlockTags.MOD_BUSHES)
                .add(modBlocks.STRAWBERRY_BUSH)
                .add(modBlocks.BLUEBERRY_BUSH);
    }
}