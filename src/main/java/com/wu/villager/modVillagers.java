package com.wu.villager;

import com.google.common.collect.ImmutableSet;
import com.wu.TitaniumUpdate;
import com.wu.block.modBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.jetbrains.annotations.Nullable;


public class modVillagers {
    public static final VillagerProfession TITANIUM_ALLOY_SCIENTIST = register("titanium_alloy_scientist",
            modPointOfInterestTypes.TITANIUM_ALLOY, SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH);

    public static PointOfInterestType TITANIUM_ALLOY_POI = registerPOI("titanium_alloy_poi", modBlocks.TITANIUM_BLOCK);

    public static VillagerProfession register(String id, RegistryKey<PointOfInterestType> heldWorkstation, @Nullable SoundEvent workSound){
        return Registry.register(
                Registries.VILLAGER_PROFESSION,
                new Identifier(TitaniumUpdate.MOD_ID, id),
                new VillagerProfession(id,
                        entry -> entry.matchesKey(heldWorkstation),
                        entry -> entry.matchesKey(heldWorkstation),
                        ImmutableSet.of(),
                        ImmutableSet.of(),
                        workSound)
        );
    }

    public static PointOfInterestType registerPOI(String id, Block block){
        return PointOfInterestHelper.register(
                new Identifier(TitaniumUpdate.MOD_ID, id),1,1, block
        );
    }

    public static void registerVillagers() {
    }
}