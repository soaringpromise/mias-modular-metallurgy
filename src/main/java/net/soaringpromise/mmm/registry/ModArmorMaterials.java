package net.soaringpromise.mmm.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.soaringpromise.mmm.Mmm;

public final class ModArmorMaterials {
    public static final ResourceKey<EquipmentAsset> SILVER_KEY =
            ResourceKey.create(EquipmentAssets.ROOT_ID, Mmm.id("silver"));

    public static final ResourceKey<EquipmentAsset> STEEL_KEY =
            ResourceKey.create(EquipmentAssets.ROOT_ID, Mmm.id("steel"));

    public static final ResourceKey<EquipmentAsset> LEAD_KEY =
            ResourceKey.create(EquipmentAssets.ROOT_ID, Mmm.id("lead"));

    public static final ArmorMaterial SILVER = new ArmorMaterial(
            10,
            ArmorMaterials.makeDefense(1, 4, 5, 2, 8),
            24,
            SoundEvents.ARMOR_EQUIP_GOLD,
            0.0f,
            0.0f,
            ModTags.Items.SILVER_REPAIRABLES,
            SILVER_KEY
    );

    public static final ArmorMaterial STEEL = new ArmorMaterial(
            23,
            ArmorMaterials.makeDefense(2, 5, 7, 3, 9),
            13,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            1.0f,
            0.025f,
            ModTags.Items.STEEL_REPAIRABLES,
            STEEL_KEY
    );

    public static final ArmorMaterial LEAD = new ArmorMaterial(
            9,
            ArmorMaterials.makeDefense(2, 4, 6, 2, 7),
            8,
            SoundEvents.ARMOR_EQUIP_IRON,
            0.0f,
            0.05f,
            ModTags.Items.LEAD_REPAIRABLES,
            LEAD_KEY
    );

    private ModArmorMaterials() {}
}