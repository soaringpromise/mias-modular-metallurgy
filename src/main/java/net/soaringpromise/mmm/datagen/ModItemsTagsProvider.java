package net.soaringpromise.mmm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.soaringpromise.mmm.registry.ModItems;
import net.soaringpromise.mmm.registry.ModTags;
import net.soaringpromise.mmm.registry.ModTools;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModItemsTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemsTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        valueLookupBuilder(ModTags.Items.SILVER_REPAIRABLES)
                .add(ModItems.SILVER_INGOT);

        valueLookupBuilder(ModTags.Items.STEEL_REPAIRABLES)
                .add(ModItems.STEEL_INGOT);

        valueLookupBuilder(ModTags.Items.LEAD_REPAIRABLES)
                .add(ModItems.LEAD_INGOT);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModTools.SILVER_SWORD)
                .add(ModTools.STEEL_SWORD);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModTools.SILVER_PICKAXE)
                .add(ModTools.STEEL_PICKAXE);

        valueLookupBuilder(ItemTags.AXES)
                .add(ModTools.SILVER_AXE)
                .add(ModTools.STEEL_AXE);

        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModTools.SILVER_SHOVEL)
                .add(ModTools.STEEL_SHOVEL);

        valueLookupBuilder(ItemTags.HOES)
                .add(ModTools.SILVER_HOE)
                .add(ModTools.STEEL_HOE);

        valueLookupBuilder(ItemTags.SPEARS)
                .add(ModTools.SILVER_SPEAR)
                .add(ModTools.STEEL_SPEAR);
    }
}