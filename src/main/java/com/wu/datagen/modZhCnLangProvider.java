package com.wu.datagen;

import com.wu.block.modBlocks;
import com.wu.item.modItemGroups;
import com.wu.item.modItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class modZhCnLangProvider extends FabricLanguageProvider {
    public modZhCnLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(modItems.RAW_TITANIUM, "粗钛");
        translationBuilder.add(modItems.TITANIUM, "钛");
        translationBuilder.add(modItems.TITANIUM_ALLOY_INGOT, "钛合金锭");
        translationBuilder.add(modItems.TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE, "锻造模版");
        translationBuilder.add(modItems.BLUEBERRIES, "蓝莓");
        translationBuilder.add(modItems.STRAWBERRIES, "草莓");
        translationBuilder.add(modItems.LAVA_COAL, "熔岩煤");
        translationBuilder.add(modItems.NETHERITE_HAMMER, "下界合金锤");
        translationBuilder.add(modItems.TITANIUM_ALLOY_SWORD, "钛合金剑");
        translationBuilder.add(modItems.TITANIUM_ALLOY_SHOVEL, "钛合金锹");
        translationBuilder.add(modItems.TITANIUM_ALLOY_PICKAXE, "钛合金镐");
        translationBuilder.add(modItems.TITANIUM_ALLOY_AXE, "钛合金斧");
        translationBuilder.add(modItems.TITANIUM_ALLOY_HOE, "钛合金锄");
        translationBuilder.add(modItems.TITANIUM_ALLOY_HAMMER, "钛合金锤");
        translationBuilder.add(modItems.TITANIUM_ALLOY_HELMET, "钛合金头盔");
        translationBuilder.add(modItems.TITANIUM_ALLOY_CHESTPLATE, "钛合金胸甲");
        translationBuilder.add(modItems.TITANIUM_ALLOY_LEGGINGS, "钛合金护腿");
        translationBuilder.add(modItems.TITANIUM_ALLOY_BOOTS, "钛合金靴子");
        translationBuilder.add(modItems.TITANIUM_ALLOY_HORSE_ARMOR, "钛合金马铠");

        translationBuilder.add(modBlocks.TITANIUM_BLOCK, "钛块");
        translationBuilder.add(modBlocks.TITANIUM_ALLOY_BLOCK, "钛合金块");
        translationBuilder.add(modBlocks.TITANIUM_ORE, "钛矿石");
        translationBuilder.add(modBlocks.DEEPSLATE_TITANIUM_ORE, "深层钛矿石");
        translationBuilder.add(modBlocks.RAW_TITANIUM_BLOCK, "粗钛块");
        translationBuilder.add(modBlocks.BLUEBERRY_BUSH, "蓝莓丛");
        translationBuilder.add(modBlocks.STRAWBERRY_BUSH, "草莓丛");
        translationBuilder.add(modBlocks.PINE_LOG, "松木原木");
        translationBuilder.add(modBlocks.PINE_WOOD, "松木");
        translationBuilder.add(modBlocks.STRIPPED_PINE_LOG, "去皮松木原木");
        translationBuilder.add(modBlocks.STRIPPED_PINE_WOOD, "去皮松木");
        translationBuilder.add(modBlocks.PINE_LEAVES, "松树树叶");
        translationBuilder.add(modBlocks.PINE_PLANKS, "松木木板");
        translationBuilder.add(modBlocks.PINE_STAIRS, "松木楼梯");
        translationBuilder.add(modBlocks.PINE_SLAB, "松木台阶");
        translationBuilder.add(modBlocks.PINE_BUTTON, "松木按钮");
        translationBuilder.add(modBlocks.PINE_PRESSURE_PLATE, "松木压力板");
        translationBuilder.add(modBlocks.PINE_FENCE, "松木栅栏");
        translationBuilder.add(modBlocks.PINE_FENCE_GATE, "松木栅栏门");
        translationBuilder.add(modBlocks.PINE_DOOR, "松木门");
        translationBuilder.add(modBlocks.PINE_TRAPDOOR, "松木活板门");
        translationBuilder.add(modBlocks.TITANIUM_SOFA, "钛制沙发");

        translationBuilder.add("entity.minecraft.villager.titanium_alloy_scientist", "钛合金科学家");

        translationBuilder.add("sounds.titanium-update.hammer_use", "锤子 : 使用");

        translationBuilder.add(modItemGroups.TITANIUM_UPDATE_ITEM, "钛更新-物品");
        translationBuilder.add(modItemGroups.TITANIUM_UPDATE_BLOCK, "钛更新-方块");

        translationBuilder.add("tooltip.titanium-update.titanium_hammer.shift", "§7同时拥有镐子和斧子的功能§r");
        translationBuilder.add("tooltip.titanium-update.titanium_hammer", "§7按住§r§6§n§lSHIFT§r§r§r§7查看更多信息§r");
        translationBuilder.add("tooltip.titanium-update.titanium_alloy_upgrade_smithing_template","§7钛合金升级§r");
    }
}