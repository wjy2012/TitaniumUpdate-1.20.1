package com.wu.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class modFoodComponents {
    //hunger(a). saturationModifier(b)
    //BaoHeDu = a * b * 2.0F
    public static final FoodComponent BLUEBERRIES = new FoodComponent.Builder().hunger(1).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 100, 1), 0.01f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 100), 0.6f)
            .build();

    public static final FoodComponent STRAWBERRIES = new FoodComponent.Builder().hunger(1).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 0.05f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 0.01f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200), 0.02f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 1), 0.01f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 100), 0.6f)
            .build();
}