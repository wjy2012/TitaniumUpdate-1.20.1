package com.wu.datagen;

import com.wu.block.modBlocks;
import com.wu.item.modItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class modItemTagsProvider extends FabricTagProvider.ItemTagProvider{
    public modItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(modBlocks.PINE_LOG.asItem())
                .add(modBlocks.PINE_WOOD.asItem())
                .add(modBlocks.STRIPPED_PINE_LOG.asItem())
                .add(modBlocks.STRIPPED_PINE_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(modBlocks.PINE_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(modBlocks.PINE_LOG.asItem())
                .add(modBlocks.PINE_WOOD.asItem())
                .add(modBlocks.STRIPPED_PINE_LOG.asItem())
                .add(modBlocks.STRIPPED_PINE_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(modItems.TITANIUM_ALLOY_HELMET, modItems.TITANIUM_ALLOY_CHESTPLATE, modItems.TITANIUM_ALLOY_LEGGINGS, modItems.TITANIUM_ALLOY_BOOTS);
    }
}