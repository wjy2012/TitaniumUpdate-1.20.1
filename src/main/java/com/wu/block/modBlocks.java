package com.wu.block;

import com.wu.TitaniumUpdate;
import com.wu.block.custom.modBushBlock;
import com.wu.item.modItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import static net.minecraft.block.Blocks.createWoodenButtonBlock;

public class modBlocks {
    public static final Block TITANIUM_BLOCK = modRegisterBlock("ore/titanium_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)));
    public static final Block TITANIUM_ALLOY_BLOCK = modRegisterBlock("titanium_alloy_block", new Block(AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS)));
    public static final Block TITANIUM_ORE = modRegisterBlock("ore/titanium_ore", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block DEEPSLATE_TITANIUM_ORE = modRegisterBlock("ore/deepslate_titanium_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final Block RAW_TITANIUM_BLOCK = modRegisterBlock("ore/raw_titanium_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(5.0F, 6.0F)));

    public static final Block BLUEBERRY_BUSH = modRegisterBlock(
            "food/blueberry_bush",
            new modBushBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_GREEN)
                            .ticksRandomly()
                            .noCollision()
                            .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                            .pistonBehavior(PistonBehavior.DESTROY),
                    modItems.BLUEBERRIES
            )
    );
    public static final Block STRAWBERRY_BUSH = modRegisterBlock(
            "food/strawberry_bush",
            new modBushBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_GREEN)
                            .ticksRandomly()
                            .noCollision()
                            .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                            .pistonBehavior(PistonBehavior.DESTROY),
                    modItems.STRAWBERRIES
            )
    );

    public static final Block PINE_LOG = modRegisterBlock("wood/pine_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block PINE_WOOD = modRegisterBlock("wood/pine_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_PINE_LOG = modRegisterBlock("wood/stripped_pine_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PINE_WOOD = modRegisterBlock("wood/stripped_pine_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block PINE_LEAVES = modRegisterBlock("wood/pine_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block PINE_PLANKS = modRegisterBlock("wood/pine_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block PINE_STAIRS = modRegisterBlock("building/pine_stairs",
            new StairsBlock(PINE_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(PINE_PLANKS)));
    public static final Block PINE_SLAB = modRegisterBlock("building/pine_slab",
            new SlabBlock(AbstractBlock.Settings.copy(PINE_PLANKS)));
    public static final Block PINE_BUTTON = modRegisterBlock("building/pine_button",
            createWoodenButtonBlock(BlockSetType.BAMBOO));
    public static final Block PINE_PRESSURE_PLATE = modRegisterBlock("building/pine_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.copy(PINE_PLANKS), BlockSetType.BAMBOO));
    public static final Block PINE_FENCE = modRegisterBlock("building/pine_fence",
            new FenceBlock(AbstractBlock.Settings.copy(PINE_PLANKS)));
    public static final Block PINE_FENCE_GATE = modRegisterBlock("building/pine_fence_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(PINE_PLANKS), WoodType.BAMBOO));
    public static final Block PINE_DOOR = modRegisterBlock("building/pine_door",
            new DoorBlock(AbstractBlock.Settings.copy(PINE_PLANKS).nonOpaque(), BlockSetType.BAMBOO));
    public static final Block PINE_TRAPDOOR = modRegisterBlock("building/pine_trapdoor",
            new TrapdoorBlock(AbstractBlock.Settings.copy(PINE_PLANKS).nonOpaque(), BlockSetType.BAMBOO));


    public static Block modRegisterBlock(String id, Block block) {
        Registry.register(Registries.ITEM, new Identifier(TitaniumUpdate.MOD_ID, id),
                new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK,
                new Identifier(TitaniumUpdate.MOD_ID, id), block);
    }

    private static void addBlocksToNaturalBlockGroup(FabricItemGroupEntries entries) {
        entries.add(RAW_TITANIUM_BLOCK);
        entries.add(TITANIUM_ORE);
        entries.add(DEEPSLATE_TITANIUM_ORE);
        entries.add(PINE_LOG);
        entries.add(PINE_LEAVES);
    }
    private static void addBlocksToBuildingBlockGroup(FabricItemGroupEntries entries) {
        entries.add(PINE_LOG);
        entries.add(PINE_WOOD);
        entries.add(STRIPPED_PINE_LOG);
        entries.add(STRIPPED_PINE_WOOD);
        entries.add(PINE_PLANKS);
        entries.add(PINE_STAIRS);
        entries.add(PINE_SLAB);
        entries.add(PINE_BUTTON);
        entries.add(PINE_PRESSURE_PLATE);
        entries.add(PINE_FENCE);
        entries.add(PINE_FENCE_GATE);
        entries.add(PINE_DOOR);
        entries.add(PINE_TRAPDOOR);
        entries.add(TITANIUM_BLOCK);
        entries.add(TITANIUM_ALLOY_BLOCK);
    }


    public static void registerBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(modBlocks::addBlocksToBuildingBlockGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(modBlocks::addBlocksToNaturalBlockGroup);
    }
}