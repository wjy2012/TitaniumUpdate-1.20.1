package com.wu.item.custom;

import com.google.common.collect.ImmutableBiMap;
import com.wu.item.modArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class modPlayerArmorItem extends ArmorItem {
    static final Map<ArmorMaterial, List<StatusEffectInstance>> MAP =
            (new ImmutableBiMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(modArmorMaterials.TITANIUM_ALLOY, List.of(
                            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 80, 0, true, false, true)))
                    .build();

    public modPlayerArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if (hasFullSuitableArmor(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity entity) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MAP.entrySet()) {
            ArmorMaterial material = entry.getKey();
            List<StatusEffectInstance> effects = entry.getValue();

            if (hasCorrectMaterialArmorOn(material, entity)) {
                for (StatusEffectInstance effect : effects) {
                    StatusEffect thisEffectType = effect.getEffectType();
                    if (!entity.hasStatusEffect(thisEffectType)) {
                        entity.addStatusEffect(new StatusEffectInstance(effect));
                    } else {
                        StatusEffectInstance existing = entity.getStatusEffect(thisEffectType);
                        if (existing.getDuration() < 30) {
                            entity.removeStatusEffect(thisEffectType);
                            entity.addStatusEffect(new StatusEffectInstance(effect));
                        }
                    }
                }
            }
        }
    }


    private boolean hasCorrectMaterialArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack stack : player.getInventory().armor) if (!(stack.getItem() instanceof ArmorItem)) return false;

        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
        return helmet.getMaterial() == material &&
                chestplate.getMaterial() == material &&
                leggings.getMaterial() == material &&
                boots.getMaterial() == material;
    }


    private boolean hasFullSuitableArmor(PlayerEntity player) {
        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);

        return helmet.getItem() instanceof ArmorItem &&
                chestplate.getItem() instanceof ArmorItem &&
                leggings.getItem() instanceof ArmorItem &&
                boots.getItem() instanceof ArmorItem;
    }

}