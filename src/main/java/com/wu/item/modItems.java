package com.wu.item;

import com.wu.TitaniumUpdate;
import com.wu.block.modBlocks;
import com.wu.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class modItems {

    public static final Item TITANIUM_ALLOY_INGOT = modRegisterItem("titanium_alloy_ingot", new Item(new Item.Settings().fireproof()));
    public static final Item TITANIUM = modRegisterItem("ore/titanium", new Item(new Item.Settings()));
    public static final Item RAW_TITANIUM = modRegisterItem("ore/raw_titanium", new Item(new Item.Settings()));
    public static final Item TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE = modRegisterItem("titanium_alloy_upgrade_smithing_template",
            new MessageItem(new Item.Settings(), "titanium_alloy_upgrade_smithing_template"));

    public static final Item BLUEBERRIES = modRegisterItem("food/blueberries", new AliasedBlockItem(modBlocks.BLUEBERRY_BUSH, new Item.Settings().food(modFoodComponents.BLUEBERRIES)));
    public static final Item STRAWBERRIES = modRegisterItem("food/strawberries", new AliasedBlockItem(modBlocks.STRAWBERRY_BUSH, new Item.Settings().food(modFoodComponents.STRAWBERRIES)));
    public static final Item LAVA_COAL = modRegisterItem("lava_coal", new Item(new Item.Settings()));

    public static final Item NETHERITE_HAMMER = modRegisterItem("tools/netherite_hammer", new HammerItem(ToolMaterials.NETHERITE, 5.5f, -3.3f, new Item.Settings().fireproof()));
    public static final Item TITANIUM_ALLOY_SWORD = modRegisterItem("tools/titanium_alloy_sword", new SwordItem(modToolMaterials.TITANIUM_ALLOY, 4, -2.4f , new Item.Settings().fireproof()));
    public static final Item TITANIUM_ALLOY_SHOVEL = modRegisterItem("tools/titanium_alloy_shovel", new ShovelItem(modToolMaterials.TITANIUM_ALLOY, 1.5f, -3.0f, new Item.Settings().fireproof()));
    public static final Item TITANIUM_ALLOY_PICKAXE = modRegisterItem("tools/titanium_alloy_pickaxe", new PickaxeItem(modToolMaterials.TITANIUM_ALLOY, 1, -2.8f, new Item.Settings().fireproof()));
    public static final Item TITANIUM_ALLOY_AXE = modRegisterItem("tools/titanium_alloy_axe", new AxeItem(modToolMaterials.TITANIUM_ALLOY, 5.0f, -3.0f, new Item.Settings().fireproof()));
    public static final Item TITANIUM_ALLOY_HOE = modRegisterItem("tools/titanium_alloy_hoe", new HoeItem(modToolMaterials.TITANIUM_ALLOY, -1, 0.0f, new Item.Settings().fireproof()));
    public static final Item TITANIUM_ALLOY_HAMMER = modRegisterItem("tools/titanium_alloy_hammer", new HammerItem(modToolMaterials.TITANIUM_ALLOY, 5.5f, -3.3f, new Item.Settings().fireproof()));

    public static final Item TITANIUM_ALLOY_HELMET = modRegisterItem("armor/titanium_alloy_helmet", new modPlayerArmorItem(modArmorMaterials.TITANIUM_ALLOY, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item TITANIUM_ALLOY_CHESTPLATE = modRegisterItem("armor/titanium_alloy_chestplate", new ArmorItem(modArmorMaterials.TITANIUM_ALLOY, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item TITANIUM_ALLOY_LEGGINGS = modRegisterItem("armor/titanium_alloy_leggings", new ArmorItem(modArmorMaterials.TITANIUM_ALLOY, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item TITANIUM_ALLOY_BOOTS = modRegisterItem("armor/titanium_alloy_boots", new ArmorItem(modArmorMaterials.TITANIUM_ALLOY, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));

    public static final Item TITANIUM_ALLOY_HORSE_ARMOR = modRegisterItem("titanium_alloy_horse_armor", new HorseArmorItem(12, "titanium_alloy", new Item.Settings().fireproof().maxCount(1)));


    public static Item modRegisterItem(String id, Item item){
        return Registry.register(
                Registries.ITEM,
                RegistryKey.of(Registries.ITEM.getKey(), new Identifier(TitaniumUpdate.MOD_ID, id)),
                item);
    }


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(RAW_TITANIUM);
        entries.add(TITANIUM_ALLOY_INGOT);
        entries.add(TITANIUM);
        entries.add(LAVA_COAL);
    }
    private static void addItemsToFoodAndDrinkItemGroup(FabricItemGroupEntries entries){
        entries.add(BLUEBERRIES);
        entries.add(STRAWBERRIES);
    }

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries){
        entries.add(NETHERITE_HAMMER);
        entries.add(TITANIUM_ALLOY_SHOVEL);
        entries.add(TITANIUM_ALLOY_PICKAXE);
        entries.add(TITANIUM_ALLOY_AXE);
        entries.add(TITANIUM_ALLOY_HOE);
        entries.add(TITANIUM_ALLOY_HAMMER);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries){
        entries.add(NETHERITE_HAMMER);
        entries.add(TITANIUM_ALLOY_SWORD);
        entries.add(TITANIUM_ALLOY_AXE);
        entries.add(TITANIUM_ALLOY_HAMMER);
        entries.add(TITANIUM_ALLOY_HELMET);
        entries.add(TITANIUM_ALLOY_CHESTPLATE);
        entries.add(TITANIUM_ALLOY_LEGGINGS);
        entries.add(TITANIUM_ALLOY_BOOTS);
        entries.add(TITANIUM_ALLOY_HORSE_ARMOR);
    }

    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries){
        entries.add(BLUEBERRIES);
        entries.add(STRAWBERRIES);
    }


    public static void registerItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(modItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(modItems::addItemsToFoodAndDrinkItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(modItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(modItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(modItems::addItemsToNaturalItemGroup);
    }
}