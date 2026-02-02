package com.wu.tag;

import com.wu.TitaniumUpdate;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class modItemTags {

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(TitaniumUpdate.MOD_ID, id));
    }
}