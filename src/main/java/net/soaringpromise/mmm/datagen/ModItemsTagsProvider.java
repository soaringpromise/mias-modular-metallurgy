package net.soaringpromise.mmm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.soaringpromise.mmm.registry.ModArmor;
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
                .add(ModTools.STEEL_SWORD)
                .add(ModTools.LEAD_SWORD);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModTools.SILVER_PICKAXE)
                .add(ModTools.STEEL_PICKAXE)
                .add(ModTools.LEAD_PICKAXE);

        valueLookupBuilder(ItemTags.AXES)
                .add(ModTools.SILVER_AXE)
                .add(ModTools.STEEL_AXE)
                .add(ModTools.LEAD_AXE);

        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModTools.SILVER_SHOVEL)
                .add(ModTools.STEEL_SHOVEL)
                .add(ModTools.LEAD_SHOVEL);

        valueLookupBuilder(ItemTags.HOES)
                .add(ModTools.SILVER_HOE)
                .add(ModTools.STEEL_HOE)
                .add(ModTools.LEAD_HOE);

        valueLookupBuilder(ItemTags.SPEARS)
                .add(ModTools.SILVER_SPEAR)
                .add(ModTools.STEEL_SPEAR)
                .add(ModTools.LEAD_SPEAR);

        valueLookupBuilder(ItemTags.FISHING_ENCHANTABLE)
                .add(ModTools.STEEL_FISHING_ROD);

        valueLookupBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModTools.STEEL_SHEARS);

        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModTools.STEEL_FISHING_ROD)
                .add(ModTools.STEEL_SHEARS);

        valueLookupBuilder(ItemTags.VANISHING_ENCHANTABLE)
                .add(ModTools.STEEL_FISHING_ROD)
                .add(ModTools.STEEL_SHEARS);

        valueLookupBuilder(ItemTags.ARROWS)
                .add(ModItems.SILVER_ARROW);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModArmor.SILVER_HELMET)
                .add(ModArmor.STEEL_HELMET)
                .add(ModArmor.LEAD_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModArmor.SILVER_CHESTPLATE)
                .add(ModArmor.STEEL_CHESTPLATE)
                .add(ModArmor.LEAD_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModArmor.SILVER_LEGGINGS)
                .add(ModArmor.STEEL_LEGGINGS)
                .add(ModArmor.LEAD_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModArmor.SILVER_BOOTS)
                .add(ModArmor.STEEL_BOOTS)
                .add(ModArmor.LEAD_BOOTS);
    }
}