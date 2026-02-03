package com.wu;

import com.wu.block.modBlocks;
import com.wu.entity.modEntities;
import com.wu.item.modItemGroups;
import com.wu.item.modItems;
import com.wu.sound.modSoundEvents;
import com.wu.villager.modTrades;
import com.wu.villager.modVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TitaniumUpdate implements ModInitializer {
    public static final String MOD_ID = "titanium-update";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        modItems.registerItems();
        modBlocks.registerBlocks();
        modItemGroups.registerItemGroups();
        modTrades.registerTrades();
        modTrades.registerModTrades();
        modVillagers.registerVillagers();
        modSoundEvents.registerSounds();
        modEntities.registerEntities();


        StrippableBlockRegistry.register(modBlocks.PINE_LOG, modBlocks.STRIPPED_PINE_LOG);
        StrippableBlockRegistry.register(modBlocks.PINE_WOOD, modBlocks.STRIPPED_PINE_WOOD);
        FlammableBlockRegistry.getDefaultInstance().add(modBlocks.PINE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(modBlocks.PINE_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(modBlocks.STRIPPED_PINE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(modBlocks.STRIPPED_PINE_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(modBlocks.PINE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(modBlocks.PINE_LEAVES, 30, 60);


        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(modItems.STRAWBERRIES, 0.65F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(modItems.BLUEBERRIES, 0.65F);
        //FuelRegistry.INSTANCE.add(modItems.LAVA_COAL, 20000);//mixin
        LOGGER.info("Hello Fabric world!");
    }
}