package net.soaringpromise.mmm.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.soaringpromise.mmm.registry.ModBlocks;
import net.soaringpromise.mmm.registry.ModItems;
import net.soaringpromise.mmm.registry.ModTools;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.SILVER_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.LEAD_ORE);

        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_LEAD_ORE);

        blockModelGenerators.createTrivialCube(ModBlocks.SILVER_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.STEEL_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.LEAD_BLOCK);

        blockModelGenerators.createTrivialCube(ModBlocks.RAW_SILVER_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_LEAD_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.RAW_SILVER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_LEAD, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.SILVER_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEAD_INGOT, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.SILVER_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STEEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEAD_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModTools.STEEL_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.STEEL_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.STEEL_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.STEEL_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.STEEL_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModTools.STEEL_SPEAR);

        itemModelGenerators.generateFlatItem(ModTools.SILVER_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.SILVER_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.SILVER_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.SILVER_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.SILVER_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModTools.SILVER_SPEAR);
    }
}
