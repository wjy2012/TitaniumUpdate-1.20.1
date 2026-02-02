package com.wu.sound;

import com.wu.TitaniumUpdate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class modSoundEvents {
    public static SoundEvent HAMMER_USE = register("hammer_use");

    private static SoundEvent register(String name) {
        Identifier id = new Identifier(TitaniumUpdate.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
    }
}