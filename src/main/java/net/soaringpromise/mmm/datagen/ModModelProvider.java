package net.soaringpromise.mmm.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.soaringpromise.mmm.registry.ModArmor;
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
        itemModelGenerators.generateFlatItem(ModTools.STEEL_SHEARS, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModTools.SILVER_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.SILVER_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.SILVER_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.SILVER_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.SILVER_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModTools.SILVER_SPEAR);
        itemModelGenerators.generateFlatItem(ModItems.SILVER_ARROW, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModTools.LEAD_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.LEAD_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.LEAD_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.LEAD_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModTools.LEAD_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModTools.LEAD_SPEAR);

        itemModelGenerators.generateFlatItem(ModArmor.SILVER_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.SILVER_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.SILVER_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.SILVER_BOOTS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.SILVER_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.SILVER_NAUTILUS_ARMOR, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModArmor.STEEL_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.STEEL_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.STEEL_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.STEEL_BOOTS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.STEEL_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.STEEL_NAUTILUS_ARMOR, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModArmor.LEAD_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.LEAD_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.LEAD_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.LEAD_BOOTS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.LEAD_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModArmor.LEAD_NAUTILUS_ARMOR, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.STEEL_BLEND, ModelTemplates.FLAT_ITEM);
    }
}
