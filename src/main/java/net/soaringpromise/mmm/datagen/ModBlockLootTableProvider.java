package net.soaringpromise.mmm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.soaringpromise.mmm.registry.ModBlocks;
import net.soaringpromise.mmm.registry.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.SILVER_BLOCK);
        dropSelf(ModBlocks.STEEL_BLOCK);
        dropSelf(ModBlocks.LEAD_BLOCK);
        dropSelf(ModBlocks.RAW_SILVER_BLOCK);
        dropSelf(ModBlocks.RAW_LEAD_BLOCK);

        add(ModBlocks.SILVER_ORE, createOreDrop(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER));
        add(ModBlocks.LEAD_ORE, createOreDrop(ModBlocks.LEAD_ORE, ModItems.RAW_LEAD));
        add(ModBlocks.DEEPSLATE_SILVER_ORE, createOreDrop(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER));
        add(ModBlocks.DEEPSLATE_LEAD_ORE, createOreDrop(ModBlocks.DEEPSLATE_LEAD_ORE, ModItems.RAW_LEAD));
    }
}
