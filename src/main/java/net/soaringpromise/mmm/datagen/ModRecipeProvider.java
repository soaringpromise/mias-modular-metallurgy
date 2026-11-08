package net.soaringpromise.mmm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.soaringpromise.mmm.Mmm;
import net.soaringpromise.mmm.registry.*;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(
            HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput exporter) {
        return new RecipeProvider(registries, exporter) {
            @Override
            public void buildRecipes() {
                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, ModItems.SILVER_INGOT,
                        RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_BLOCK,
                        "silver_ingot_from_silver_block", "silver_ingot"
                );

                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, ModItems.STEEL_INGOT,
                        RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK,
                        "steel_ingot_from_steel_block", "steel_ingot"
                );

                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, ModItems.LEAD_INGOT,
                        RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_BLOCK,
                        "lead_ingot_from_lead_block", "lead_ingot"
                );

                oreSmelting(
                        List.of(
                                ModItems.RAW_SILVER,
                                ModBlocks.SILVER_ORE,
                                ModBlocks.DEEPSLATE_SILVER_ORE),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.SILVER_INGOT,
                        0.7f,
                        200,
                        "silver_ingot");

                // Silver blasting
                oreBlasting(
                        List.of(
                                ModItems.RAW_SILVER,
                                ModBlocks.SILVER_ORE,
                                ModBlocks.DEEPSLATE_SILVER_ORE),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.SILVER_INGOT,
                        0.7f,
                        100,
                        "silver_ingot");

                oreSmelting(
                        List.of(
                                ModItems.RAW_LEAD,
                                ModBlocks.LEAD_ORE,
                                ModBlocks.DEEPSLATE_LEAD_ORE),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.LEAD_INGOT,
                        0.7f,
                        200,
                        "lead_ingot");

                oreBlasting(
                        List.of(
                                ModItems.RAW_LEAD,
                                ModBlocks.LEAD_ORE,
                                ModBlocks.DEEPSLATE_LEAD_ORE),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.LEAD_INGOT,
                        0.7f,
                        100,
                        "lead_ingot");

                toolRecipes(
                        ModItems.SILVER_INGOT,
                        ModTools.SILVER_SWORD,
                        ModTools.SILVER_PICKAXE,
                        ModTools.SILVER_AXE,
                        ModTools.SILVER_SHOVEL,
                        ModTools.SILVER_HOE,
                        ModTools.SILVER_SPEAR
                );

                toolRecipes(
                        ModItems.STEEL_INGOT,
                        ModTools.STEEL_SWORD,
                        ModTools.STEEL_PICKAXE,
                        ModTools.STEEL_AXE,
                        ModTools.STEEL_SHOVEL,
                        ModTools.STEEL_HOE,
                        ModTools.STEEL_SPEAR
                );

                toolRecipes(
                        ModItems.LEAD_INGOT,
                        ModTools.LEAD_SWORD,
                        ModTools.LEAD_PICKAXE,
                        ModTools.LEAD_AXE,
                        ModTools.LEAD_SHOVEL,
                        ModTools.LEAD_HOE,
                        ModTools.LEAD_SPEAR
                );

                armorRecipes(
                        ModItems.SILVER_INGOT,
                        ModArmor.SILVER_HELMET,
                        ModArmor.SILVER_CHESTPLATE,
                        ModArmor.SILVER_LEGGINGS,
                        ModArmor.SILVER_BOOTS
                );

                armorRecipes(
                        ModItems.STEEL_INGOT,
                        ModArmor.STEEL_HELMET,
                        ModArmor.STEEL_CHESTPLATE,
                        ModArmor.STEEL_LEGGINGS,
                        ModArmor.STEEL_BOOTS
                );

                armorRecipes(
                        ModItems.LEAD_INGOT,
                        ModArmor.LEAD_HELMET,
                        ModArmor.LEAD_CHESTPLATE,
                        ModArmor.LEAD_LEGGINGS,
                        ModArmor.LEAD_BOOTS
                );

                nautilusArmorUpgrade(
                        Items.COPPER_NAUTILUS_ARMOR,
                        ModItems.LEAD_INGOT,
                        ModArmor.LEAD_NAUTILUS_ARMOR
                );

                nautilusArmorUpgrade(
                        Items.GOLDEN_NAUTILUS_ARMOR,
                        ModItems.SILVER_INGOT,
                        ModArmor.SILVER_NAUTILUS_ARMOR
                );

                nautilusArmorUpgrade(
                        Items.IRON_NAUTILUS_ARMOR,
                        ModItems.STEEL_INGOT,
                        ModArmor.STEEL_NAUTILUS_ARMOR
                );

                shaped(RecipeCategory.TOOLS, ModTools.STEEL_FISHING_ROD)
                        .pattern("  M")
                        .pattern(" MS")
                        .pattern("M S")
                        .define('M', ModItems.STEEL_INGOT)
                        .define('S', Items.STRING)
                        .unlockedBy(
                                getHasName(ModItems.STEEL_INGOT),
                                has(ModItems.STEEL_INGOT))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, ModTools.STEEL_SHEARS)
                        .pattern(" M")
                        .pattern("M ")
                        .define('M', ModItems.STEEL_INGOT)
                        .unlockedBy(
                                getHasName(ModItems.STEEL_INGOT),
                                has(ModItems.STEEL_INGOT))
                        .save(exporter);

                shaped(RecipeCategory.COMBAT, ModItems.SILVER_ARROW, 8)
                        .pattern("M")
                        .pattern("S")
                        .pattern("F")
                        .define('M', ModItems.SILVER_INGOT)
                        .define('S', Items.STICK)
                        .define('F', Items.FEATHER)
                        .unlockedBy(
                                getHasName(ModItems.SILVER_INGOT),
                                has(ModItems.SILVER_INGOT))
                        .save(exporter);

                shapeless(RecipeCategory.MISC, ModItems.STEEL_BLEND)
                        .requires(Items.RAW_IRON)
                        .requires(ItemTags.COALS)
                        .requires(ItemTags.COALS)
                        .requires(Items.CALCITE)
                        .unlockedBy(
                                getHasName(Items.RAW_IRON),
                                has(Items.RAW_IRON)
                        )
                        .save(exporter);

                oreBlasting(
                        List.of(ModItems.STEEL_BLEND),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.STEEL_INGOT,
                        1f,
                        100,
                        "steel_ingot"
                );

                shaped(RecipeCategory.BUILDING_BLOCKS, Items.CALCITE, 2)
                        .pattern("DB")
                        .pattern("BD")
                        .define('D', Items.POINTED_DRIPSTONE)
                        .define('B', Items.BONE_MEAL)
                        .unlockedBy(
                                getHasName(Items.POINTED_DRIPSTONE),
                                has(Items.POINTED_DRIPSTONE)
                        )
                        .save(exporter, ResourceKey.create(Registries.RECIPE, Mmm.id("calcite_from_dripstone")));

                recyclingRecipes(ModTags.Items.RECYCLABLE_IRON, Items.IRON_INGOT,
                        "minecraft:iron_nugget_from_smelting",
                        "minecraft:iron_nugget_from_blasting");

                recyclingRecipes(ModTags.Items.RECYCLABLE_GOLD, Items.GOLD_INGOT,
                        "minecraft:gold_nugget_from_smelting",
                        "minecraft:gold_nugget_from_blasting");

                recyclingRecipes(ModTags.Items.RECYCLABLE_COPPER, Items.COPPER_INGOT,
                        "minecraft:copper_nugget_from_smelting",
                        "minecraft:copper_nugget_from_blasting");

                recyclingRecipes(ModTags.Items.RECYCLABLE_SILVER, ModItems.SILVER_INGOT,
                        "modular-metallurgy:silver_ingot_from_recycling_smelting",
                        "modular-metallurgy:silver_ingot_from_recycling_blasting");

                recyclingRecipes(ModTags.Items.RECYCLABLE_STEEL, ModItems.STEEL_INGOT,
                        "modular-metallurgy:steel_ingot_from_recycling_smelting",
                        "modular-metallurgy:steel_ingot_from_recycling_blasting");

                recyclingRecipes(ModTags.Items.RECYCLABLE_LEAD, ModItems.LEAD_INGOT,
                        "modular-metallurgy:lead_ingot_from_recycling_smelting",
                        "modular-metallurgy:lead_ingot_from_recycling_blasting");
            }

            private void toolRecipes(Item ingot, Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, Item spear) {
                shaped(RecipeCategory.COMBAT, sword)
                        .pattern("M")
                        .pattern("M")
                        .pattern("S")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, pickaxe)
                        .pattern("MMM")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, axe)
                        .pattern("MM")
                        .pattern("MS")
                        .pattern(" S")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, shovel)
                        .pattern("M")
                        .pattern("S")
                        .pattern("S")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, hoe)
                        .pattern("MM")
                        .pattern(" S")
                        .pattern(" S")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                shaped(RecipeCategory.COMBAT, spear)
                        .pattern("  M")
                        .pattern(" S ")
                        .pattern("S  ")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);
            }

            private void armorRecipes(Item ingot, Item helmet, Item chestplate, Item leggings, Item boots) {
                shaped(RecipeCategory.COMBAT, helmet)
                        .pattern("MMM")
                        .pattern("M M")
                        .define('M', ingot)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                shaped(RecipeCategory.COMBAT, chestplate)
                        .pattern("M M")
                        .pattern("MMM")
                        .pattern("MMM")
                        .define('M', ingot)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                shaped(RecipeCategory.COMBAT, leggings)
                        .pattern("MMM")
                        .pattern("M M")
                        .pattern("M M")
                        .define('M', ingot)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                shaped(RecipeCategory.COMBAT, boots)
                        .pattern("M M")
                        .pattern("M M")
                        .define('M', ingot)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);
            }


            private void recyclingRecipes(TagKey<Item> inputs, Item result, String smeltingId, String blastingId) {
                SimpleCookingRecipeBuilder.smelting(
                                tag(inputs),
                                RecipeCategory.MISC,
                                CookingBookCategory.MISC,
                                result,
                                0.1f,
                                200
                        )
                        .unlockedBy("has_recyclable_equipment", has(inputs))
                        .save(exporter, smeltingId);

                SimpleCookingRecipeBuilder.blasting(
                                tag(inputs),
                                RecipeCategory.MISC,
                                CookingBookCategory.MISC,
                                result,
                                0.1f,
                                100
                        )
                        .unlockedBy("has_recyclable_equipment", has(inputs))
                        .save(exporter, blastingId);
            }

            private void nautilusArmorUpgrade(Item base, Item ingot, Item result) {
                shapeless(RecipeCategory.COMBAT, result)
                        .requires(base)
                        .requires(ingot, 4)
                        .unlockedBy(getHasName(base), has(base))
                        .save(exporter);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return String.format("%s Recipe Provider", Mmm.MOD_NAME);
    }
}