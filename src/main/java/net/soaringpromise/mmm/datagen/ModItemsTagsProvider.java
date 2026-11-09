package net.soaringpromise.mmm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

        addRecycling(ModTags.Items.RECYCLABLE_IRON,
                Items.IRON_SWORD, Items.IRON_SPEAR,
                Items.IRON_PICKAXE, Items.IRON_AXE,
                Items.IRON_SHOVEL, Items.IRON_HOE,
                Items.IRON_HELMET, Items.IRON_CHESTPLATE,
                Items.IRON_LEGGINGS, Items.IRON_BOOTS,
                Items.IRON_HORSE_ARMOR, Items.IRON_NAUTILUS_ARMOR,
                Items.CHAINMAIL_HELMET, Items.CHAINMAIL_CHESTPLATE,
                Items.CHAINMAIL_LEGGINGS, Items.CHAINMAIL_BOOTS);

        addRecycling(ModTags.Items.RECYCLABLE_GOLD,
                Items.GOLDEN_SWORD, Items.GOLDEN_SPEAR,
                Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE,
                Items.GOLDEN_SHOVEL, Items.GOLDEN_HOE,
                Items.GOLDEN_HELMET, Items.GOLDEN_CHESTPLATE,
                Items.GOLDEN_LEGGINGS, Items.GOLDEN_BOOTS,
                Items.GOLDEN_HORSE_ARMOR, Items.GOLDEN_NAUTILUS_ARMOR);

        addRecycling(ModTags.Items.RECYCLABLE_COPPER,
                Items.COPPER_SWORD, Items.COPPER_SPEAR,
                Items.COPPER_PICKAXE, Items.COPPER_AXE,
                Items.COPPER_SHOVEL, Items.COPPER_HOE,
                Items.COPPER_HELMET, Items.COPPER_CHESTPLATE,
                Items.COPPER_LEGGINGS, Items.COPPER_BOOTS,
                Items.COPPER_HORSE_ARMOR, Items.COPPER_NAUTILUS_ARMOR);

        addRecycling(ModTags.Items.RECYCLABLE_SILVER,
                ModTools.SILVER_SWORD, ModTools.SILVER_SPEAR,
                ModTools.SILVER_PICKAXE, ModTools.SILVER_AXE,
                ModTools.SILVER_SHOVEL, ModTools.SILVER_HOE,
                ModArmor.SILVER_HELMET, ModArmor.SILVER_CHESTPLATE,
                ModArmor.SILVER_LEGGINGS, ModArmor.SILVER_BOOTS,
                ModArmor.SILVER_HORSE_ARMOR, ModArmor.SILVER_NAUTILUS_ARMOR);

        addRecycling(ModTags.Items.RECYCLABLE_STEEL,
                ModTools.STEEL_SWORD, ModTools.STEEL_SPEAR,
                ModTools.STEEL_PICKAXE, ModTools.STEEL_AXE,
                ModTools.STEEL_SHOVEL, ModTools.STEEL_HOE,
                ModTools.STEEL_FISHING_ROD, ModTools.STEEL_SHEARS,
                ModArmor.STEEL_HELMET, ModArmor.STEEL_CHESTPLATE,
                ModArmor.STEEL_LEGGINGS, ModArmor.STEEL_BOOTS,
                ModArmor.STEEL_HORSE_ARMOR, ModArmor.STEEL_NAUTILUS_ARMOR);

        addRecycling(ModTags.Items.RECYCLABLE_LEAD,
                ModTools.LEAD_SWORD, ModTools.LEAD_SPEAR,
                ModTools.LEAD_PICKAXE, ModTools.LEAD_AXE,
                ModTools.LEAD_SHOVEL, ModTools.LEAD_HOE,
                ModArmor.LEAD_HELMET, ModArmor.LEAD_CHESTPLATE,
                ModArmor.LEAD_LEGGINGS, ModArmor.LEAD_BOOTS,
                ModArmor.LEAD_HORSE_ARMOR, ModArmor.LEAD_NAUTILUS_ARMOR);

        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.SILVER_INGOT)
                .add(ModItems.LEAD_INGOT);
    }

    private void addRecycling(TagKey<Item> tag, Item... items) {
        var builder = valueLookupBuilder(tag);
        for (Item item : items) builder.add(item);
    }
}