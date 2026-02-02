package com.wu.tag;

import com.wu.TitaniumUpdate;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class modBlockTags {
    public static final TagKey<Block> PINE_LOGS = of("pine_logs");
    public static final TagKey<Block> HAMMER_MINEABLE = of("mineable/hammer");
    public static final TagKey<Block> MOD_BUSHES = of("mod_bushes");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(TitaniumUpdate.MOD_ID, id));
    }
}