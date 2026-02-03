package com.wu.entity;

import com.wu.TitaniumUpdate;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class modEntities {
    public static final EntityType<SeatEntity> SEAT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TitaniumUpdate.MOD_ID, "seat"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, SeatEntity::new).build());

    public static void registerEntities() {
    }
}
