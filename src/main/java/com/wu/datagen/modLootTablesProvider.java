package com.wu.datagen;

import com.wu.block.custom.modBushBlock;
import com.wu.block.modBlocks;
import com.wu.item.modItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class modLootTablesProvider extends FabricBlockLootTableProvider {

    public modLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(modBlocks.TITANIUM_BLOCK);
        addDrop(modBlocks.TITANIUM_ALLOY_BLOCK);
        addDrop(modBlocks.RAW_TITANIUM_BLOCK);
        addDrop(modBlocks.PINE_LOG);
        addDrop(modBlocks.PINE_WOOD);
        addDrop(modBlocks.STRIPPED_PINE_LOG);
        addDrop(modBlocks.STRIPPED_PINE_WOOD);
        addDrop(modBlocks.PINE_PLANKS);

        addDrop(modBlocks.PINE_STAIRS);
        addDrop(modBlocks.PINE_SLAB, slabDrops(modBlocks.PINE_SLAB));
        addDrop(modBlocks.PINE_BUTTON);
        addDrop(modBlocks.PINE_PRESSURE_PLATE);
        addDrop(modBlocks.PINE_FENCE);
        addDrop(modBlocks.PINE_FENCE_GATE);
        addDrop(modBlocks.PINE_DOOR, doorDrops(modBlocks.PINE_DOOR));
        addDrop(modBlocks.PINE_TRAPDOOR);

        addDrop(modBlocks.PINE_LEAVES, block -> leavesDrops(block, Blocks.SPRUCE_SAPLING, SAPLING_DROP_CHANCE));

        addDrop(modBlocks.TITANIUM_ORE,oreDrops(modBlocks.TITANIUM_ORE, modItems.RAW_TITANIUM));
        addDrop(modBlocks.DEEPSLATE_TITANIUM_ORE,oreDrops(modBlocks.DEEPSLATE_TITANIUM_ORE, modItems.RAW_TITANIUM));

        addBushDrops(modBlocks.BLUEBERRY_BUSH, modItems.BLUEBERRIES);
        addBushDrops(modBlocks.STRAWBERRY_BUSH, modItems.STRAWBERRIES);
    }

    public void addBushDrops(Block bushBlock, Item item) {
        this.addDrop(bushBlock, block -> this.applyExplosionDecay(
                block, LootTable.builder()
                        .pool(LootPool.builder()
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(bushBlock).properties(StatePredicate.Builder.create().exactMatch(modBushBlock.AGE, 3))
                                )
                                .with(ItemEntry.builder(item))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
                        )
                        .pool(LootPool.builder()
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(bushBlock).properties(StatePredicate.Builder.create().exactMatch(modBushBlock.AGE, 2))
                                )
                                .with(ItemEntry.builder(item))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
                        )
        ));
    }
}