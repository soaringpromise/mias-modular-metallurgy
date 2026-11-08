package net.soaringpromise.mmm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.soaringpromise.mmm.Mmm;
import net.soaringpromise.mmm.registry.ModBlocks;
import net.soaringpromise.mmm.registry.ModItems;
import net.soaringpromise.mmm.registry.ModTools;
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

                // Silver smelting
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

                // Lead smelting
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

                // Lead blasting
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

                // Silver tools
                toolRecipes(
                        ModItems.SILVER_INGOT,
                        ModTools.SILVER_SWORD,
                        ModTools.SILVER_PICKAXE,
                        ModTools.SILVER_AXE,
                        ModTools.SILVER_SHOVEL,
                        ModTools.SILVER_HOE,
                        ModTools.SILVER_SPEAR
                );

                // Steel tools
                toolRecipes(
                        ModItems.STEEL_INGOT,
                        ModTools.STEEL_SWORD,
                        ModTools.STEEL_PICKAXE,
                        ModTools.STEEL_AXE,
                        ModTools.STEEL_SHOVEL,
                        ModTools.STEEL_HOE,
                        ModTools.STEEL_SPEAR
                );

                // Lead tools
                toolRecipes(
                        ModItems.LEAD_INGOT,
                        ModTools.LEAD_SWORD,
                        ModTools.LEAD_PICKAXE,
                        ModTools.LEAD_AXE,
                        ModTools.LEAD_SHOVEL,
                        ModTools.LEAD_HOE,
                        ModTools.LEAD_SPEAR
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
            }

            private void toolRecipes(Item ingot, Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, Item spear) {
                // Sword
                shaped(RecipeCategory.COMBAT, sword)
                        .pattern("M")
                        .pattern("M")
                        .pattern("S")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                // Pickaxe
                shaped(RecipeCategory.TOOLS, pickaxe)
                        .pattern("MMM")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                // Axe
                shaped(RecipeCategory.TOOLS, axe)
                        .pattern("MM")
                        .pattern("MS")
                        .pattern(" S")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                // Shovel
                shaped(RecipeCategory.TOOLS, shovel)
                        .pattern("M")
                        .pattern("S")
                        .pattern("S")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                // Hoe
                shaped(RecipeCategory.TOOLS, hoe)
                        .pattern("MM")
                        .pattern(" S")
                        .pattern(" S")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);

                // Spear
                shaped(RecipeCategory.COMBAT, spear)
                        .pattern("  M")
                        .pattern(" S ")
                        .pattern("S  ")
                        .define('M', ingot)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(exporter);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return String.format("%s Recipe Provider", Mmm.MOD_NAME);
    }
}
