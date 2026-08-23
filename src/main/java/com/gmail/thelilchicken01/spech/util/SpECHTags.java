package com.gmail.thelilchicken01.spech.util;

import com.gmail.thelilchicken01.spech.Spech;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SpECHTags {

    public static class Items {
        public static final TagKey<Item> HAS_NON_SPELL_ENGINE_SPELL = createTag("has_non_spell_engine_spell");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Spech.MODID, name));
        }
    }

}
