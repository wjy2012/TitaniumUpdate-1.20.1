package com.wu.item;

import com.wu.TitaniumUpdate;
import com.wu.block.modBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class modItemGroups {
    public static final RegistryKey<ItemGroup> TITANIUM_UPDATE_ITEM = register("titanium-update_item");
    public static final RegistryKey<ItemGroup> TITANIUM_UPDATE_BLOCK = register("titanium-update_block");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(TitaniumUpdate.MOD_ID, id));
    }

    public static void registerItemGroups(){
        Registry.register(
                Registries.ITEM_GROUP,
                TITANIUM_UPDATE_ITEM,
                ItemGroup.create(null, -1)
                        .displayName(Text.translatable("itemGroup.titanium-update_item"))
                        .icon(() -> new ItemStack(modItems.TITANIUM_ALLOY_INGOT))
                        .entries((displayContext, entries) -> {
                            entries.add(modItems.TITANIUM_ALLOY_INGOT);
                            entries.add(modItems.TITANIUM);
                            entries.add(modItems.RAW_TITANIUM);
                            entries.add(modItems.TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE);
                            entries.add(modItems.BLUEBERRIES);
                            entries.add(modItems.STRAWBERRIES);
                            entries.add(modItems.LAVA_COAL);
                            entries.add(modItems.NETHERITE_HAMMER);
                            entries.add(modItems.TITANIUM_ALLOY_SWORD);
                            entries.add(modItems.TITANIUM_ALLOY_SHOVEL);
                            entries.add(modItems.TITANIUM_ALLOY_PICKAXE);
                            entries.add(modItems.TITANIUM_ALLOY_AXE);
                            entries.add(modItems.TITANIUM_ALLOY_HOE);
                            entries.add(modItems.TITANIUM_ALLOY_HAMMER);
                            entries.add(modItems.TITANIUM_ALLOY_HELMET);
                            entries.add(modItems.TITANIUM_ALLOY_CHESTPLATE);
                            entries.add(modItems.TITANIUM_ALLOY_LEGGINGS);
                            entries.add(modItems.TITANIUM_ALLOY_BOOTS);
                            entries.add(modItems.TITANIUM_ALLOY_HORSE_ARMOR);
                        })
                        .build());


        Registry.register(
                Registries.ITEM_GROUP,
                TITANIUM_UPDATE_BLOCK,
                ItemGroup.create(null, -1)
                        .displayName(Text.translatable("itemGroup.titanium-update_block"))
                        .icon(() -> new ItemStack(modBlocks.TITANIUM_BLOCK))
                        .entries((displayContext, entries) -> {
                            entries.add(modBlocks.TITANIUM_BLOCK);
                            entries.add(modBlocks.TITANIUM_ALLOY_BLOCK);
                            entries.add(modBlocks.TITANIUM_ORE);
                            entries.add(modBlocks.DEEPSLATE_TITANIUM_ORE);
                            entries.add(modBlocks.RAW_TITANIUM_BLOCK);
                            entries.add(modBlocks.PINE_LOG);
                            entries.add(modBlocks.PINE_WOOD);
                            entries.add(modBlocks.STRIPPED_PINE_LOG);
                            entries.add(modBlocks.STRIPPED_PINE_WOOD);
                            entries.add(modBlocks.PINE_LEAVES);
                            entries.add(modBlocks.PINE_PLANKS);
                            entries.add(modBlocks.PINE_STAIRS);
                            entries.add(modBlocks.PINE_SLAB);
                            entries.add(modBlocks.PINE_BUTTON);
                            entries.add(modBlocks.PINE_PRESSURE_PLATE);
                            entries.add(modBlocks.PINE_FENCE);
                            entries.add(modBlocks.PINE_FENCE_GATE);
                            entries.add(modBlocks.PINE_DOOR);
                            entries.add(modBlocks.PINE_TRAPDOOR);
                        })
                        .build());
    }
}