package com.wu.villager;

import com.wu.TitaniumUpdate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class modPointOfInterestTypes {
    public static final RegistryKey<PointOfInterestType> TITANIUM_ALLOY = of("titanium_alloy_poi");

    private static RegistryKey<PointOfInterestType> of(String id) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(TitaniumUpdate.MOD_ID, id));
    }
}