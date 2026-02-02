package com.wu;

import com.wu.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TitaniumUpdateDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack =  fabricDataGenerator.createPack();
        pack.addProvider(modItemTagsProvider::new);
        pack.addProvider(modBlockTagsProvider::new);
        pack.addProvider(modModelsProvider::new);
        pack.addProvider(modRecipesProvider::new);
        pack.addProvider(modLootTablesProvider::new);
        pack.addProvider(modEnUsLangProvider::new);
        pack.addProvider(modZhCnLangProvider::new);
        pack.addProvider(modPointTagsProvider::new);
    }
}