package net.soaringpromise.mmm.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.soaringpromise.mmm.Mmm;

public final class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SILVER_TOOL = createTag("needs_silver_tool");
        public static final TagKey<Block> INCORRECT_FOR_SILVER_TOOL = createTag("incorrect_for_silver_tool");

        public static final TagKey<Block> NEEDS_STEEL_TOOL = createTag("needs_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createTag("incorrect_for_steel_tool");

        public static final TagKey<Block> NEEDS_LEAD_TOOL = createTag("needs_lead_tool");
        public static final TagKey<Block> INCORRECT_FOR_LEAD_TOOL = createTag("incorrect_for_lead_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Mmm.id(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SILVER_REPAIRABLES = createTag("silver_repairables");
        public static final TagKey<Item> STEEL_REPAIRABLES = createTag("steel_repairables");
        public static final TagKey<Item> LEAD_REPAIRABLES = createTag("lead_repairables");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Mmm.id(name));
        }
    }

    private ModTags() {}
}