package net.soaringpromise.mmm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.soaringpromise.mmm.registry.ModBlocks;
import net.soaringpromise.mmm.registry.ModTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBlocksTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlocksTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SILVER_BLOCK)
                .add(ModBlocks.STEEL_BLOCK)
                .add(ModBlocks.LEAD_BLOCK)
                .add(ModBlocks.RAW_SILVER_BLOCK)
                .add(ModBlocks.RAW_LEAD_BLOCK)
                .add(ModBlocks.SILVER_ORE)
                .add(ModBlocks.DEEPSLATE_SILVER_ORE)
                .add(ModBlocks.LEAD_ORE)
                .add(ModBlocks.DEEPSLATE_LEAD_ORE);

        valueLookupBuilder(ModTags.Blocks.NEEDS_LEAD_TOOL)
                .add(ModBlocks.LEAD_BLOCK)
                .add(ModBlocks.RAW_LEAD_BLOCK)
                .add(ModBlocks.LEAD_ORE)
                .add(ModBlocks.DEEPSLATE_LEAD_ORE);

        valueLookupBuilder(ModTags.Blocks.NEEDS_SILVER_TOOL)
                .add(ModBlocks.SILVER_BLOCK)
                .add(ModBlocks.RAW_SILVER_BLOCK)
                .add(ModBlocks.SILVER_ORE)
                .add(ModBlocks.DEEPSLATE_SILVER_ORE);

        valueLookupBuilder(ModTags.Blocks.NEEDS_STEEL_TOOL)
                .add(ModBlocks.STEEL_BLOCK);

        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .addTag(ModTags.Blocks.NEEDS_LEAD_TOOL);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .addTag(ModTags.Blocks.NEEDS_SILVER_TOOL);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .addTag(ModTags.Blocks.NEEDS_STEEL_TOOL);

        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_LEAD_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_SILVER_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL);
    }
}