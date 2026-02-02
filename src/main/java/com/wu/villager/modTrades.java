package com.wu.villager;

import com.wu.item.modItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

public class modTrades {
    public static void registerTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 3,
                factories -> {
                    factories.add(
                            new TradeOffers.BuyForOneEmeraldFactory(modItems.STRAWBERRIES, 3, 22, 20));
                    factories.add(
                            new modTradeOffers.BuyForEmeraldsFactory(modItems.STRAWBERRIES, 8, 3, 16, 20, 0.04f));
                }
        );
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5,
                factories -> {
                    factories.add(
                            new TradeOffers.SellItemFactory(modItems.BLUEBERRIES.getDefaultStack(), 1, 6, 16, 30, 0.04f));
                }
        );
    }
    public static void registerModTrades() {
        TradeOfferHelper.registerVillagerOffers(modVillagers.TITANIUM_ALLOY_SCIENTIST, 1,
                factories -> {
                    factories.add(
                            new TradeOffers.SellItemFactory(Items.IRON_INGOT.getDefaultStack(), 1, 4, 16, 3, 0.03f));
                    factories.add(
                            new TradeOffers.SellItemFactory(Items.GOLD_INGOT.getDefaultStack(), 1, 5, 16, 3, 0.03f));
                    factories.add(
                            new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_INGOT, 5, 18, 5));
                }
        );
        TradeOfferHelper.registerVillagerOffers(modVillagers.TITANIUM_ALLOY_SCIENTIST, 2,
                factories ->{
                    factories.add(
                            new TradeOffers.SellItemFactory(modItems.TITANIUM_ALLOY_UPGRADE_SMITHING_TEMPLATE.getDefaultStack(), 64, 1, 6, 8, 0.03f));
                    factories.add(
                            new modTradeOffers.BuyForEmeraldsFactory(modItems.TITANIUM, 1, 9, 8, 12));
                }
        );
        TradeOfferHelper.registerVillagerOffers(modVillagers.TITANIUM_ALLOY_SCIENTIST, 3,
                factories -> {
                    factories.add(
                            new TradeOffers.SellItemFactory(modItems.TITANIUM.getDefaultStack(), 32, 1, 1, 10, 0.03f));
                    factories.add(
                            new TradeOffers.SellItemFactory(modItems.RAW_TITANIUM.getDefaultStack(), 32, 1, 1, 10, 0.03f));
                    factories.add(
                            new modTradeOffers.BuyForEmeraldsFactory(modItems.TITANIUM_ALLOY_INGOT, 1, 36, 4, 20));
                }
        );
        TradeOfferHelper.registerVillagerOffers(modVillagers.TITANIUM_ALLOY_SCIENTIST, 4,
                factories -> {
                    factories.add(
                            new modTradeOffers.EnchantFactory(modItems.TITANIUM_ALLOY_PICKAXE));
                    factories.add(
                            new modTradeOffers.EnchantFactory(modItems.TITANIUM_ALLOY_AXE));
                    factories.add(
                            new modTradeOffers.EnchantFactory(modItems.TITANIUM_ALLOY_SHOVEL));
                    factories.add(
                            new modTradeOffers.EnchantFactory(modItems.TITANIUM_ALLOY_SWORD));
                    factories.add(
                            new modTradeOffers.EnchantFactory(modItems.TITANIUM_ALLOY_HELMET));
                    factories.add(
                            new modTradeOffers.EnchantFactory(modItems.TITANIUM_ALLOY_CHESTPLATE));
                    factories.add(
                            new modTradeOffers.EnchantFactory(modItems.TITANIUM_ALLOY_LEGGINGS));
                    factories.add(
                            new modTradeOffers.EnchantFactory(modItems.TITANIUM_ALLOY_BOOTS));
                }
        );
        TradeOfferHelper.registerVillagerOffers(modVillagers.TITANIUM_ALLOY_SCIENTIST, 5,
                factories -> {
                    factories.add(
                            new modTradeOffers.BuyForEmeraldsFactory(modItems.TITANIUM_ALLOY_HORSE_ARMOR, 1, 1, 1, 30));
                    factories.add(
                            new modTradeOffers.BuyForEmeraldsFactory(modItems.TITANIUM_ALLOY_HAMMER, 1, 1, 1, 30));
                }
        );
    }
}