package com.wu.villager;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class modTradeOffers {

    public static class BuyForEmeraldsFactory implements TradeOffers.Factory {
        private final Item buy;
        private final int count;
        private final int prize;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public BuyForEmeraldsFactory(ItemConvertible buyItem, int buyCount, int ECount, int maxUses, int experience, float multiplier) {
            this.buy = buyItem.asItem();
            this.count = buyCount;
            this.prize = ECount;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }
        public BuyForEmeraldsFactory(ItemConvertible buyItem, int buyCount, int ECount, int maxUses, int experience) {
            this(buyItem, buyCount, ECount, maxUses, experience, 0.05f);
        }

        @Override
        public @Nullable TradeOffer create(Entity entity, Random random) {
            ItemStack itemStack1 = new ItemStack(this.buy, this.count);
            ItemStack itemStack2 = new ItemStack(Items.EMERALD, this.prize);
            return new TradeOffer(itemStack1, ItemStack.EMPTY, itemStack2, 0, maxUses, experience, multiplier);
        }

    }
    public static class EnchantFactory implements TradeOffers.Factory {
        private final Item item;

        public EnchantFactory(Item item) {
            this.item = item;
        }


        @Override
        public @Nullable TradeOffer create(Entity entity, Random random) {
            ItemStack itemStack1 = new ItemStack(this.item);
            List<Enchantment> list = Registries.ENCHANTMENT
                    .stream()
                    .filter(enchantment ->
                            enchantment.isAvailableForEnchantedBookOffer() && enchantment.isAcceptableItem(itemStack1))
                    .collect(Collectors.toList());
            if (list.isEmpty()) {
                return new TradeOffer(itemStack1, itemStack1, 1, 5, 0.2f);
            }
            int enchantmentsNum = MathHelper.nextInt(random, 1, 3);
            ItemStack itemStack2 = itemStack1.copy();
            int cost = 2;
            for (int i = 0; i < enchantmentsNum && i < list.size(); i++) {
                Enchantment enchantment = (Enchantment)list.get(random.nextInt(list.size()));
                int level = MathHelper.nextInt(random, enchantment.getMinLevel(), enchantment.getMaxLevel());

                if (enchantment.isCursed() && i!=(enchantmentsNum-1)) continue;
                if (hasConflictingEnchantments(itemStack2, enchantment)) continue;

                EnchantmentLevelEntry ele = new EnchantmentLevelEntry(enchantment, level);

                if (!itemStack2.hasEnchantments() || !itemStack2.getEnchantments().contains(enchantment)) {
                    itemStack2.addEnchantment(enchantment, level);
                }

                int j = random.nextInt(5 + i * 10) + 3 * i;
                if (enchantment.isTreasure())  j *= 2;
                cost += j / 2;
            }
            if (cost > 64) cost = 64;
            return new TradeOffer(itemStack1, new ItemStack(Items.EMERALD, cost), itemStack2, 1, 20, 0.2f);
        }

        private boolean hasConflictingEnchantments(ItemStack itemStack, Enchantment newEnchantment) {
            if (!itemStack.hasEnchantments())  return false;

            for (Map.Entry<Enchantment, Integer> entry : EnchantmentHelper.get(itemStack).entrySet()) {
                Enchantment enchantment = entry.getKey();
                if (!enchantment.canCombine(newEnchantment))  return true;
            }

            return false;
        }
    }
}