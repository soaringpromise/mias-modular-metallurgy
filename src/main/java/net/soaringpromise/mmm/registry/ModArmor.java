package net.soaringpromise.mmm.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.soaringpromise.mmm.Mmm;

import static net.soaringpromise.mmm.registry.ModItems.registerItem;

public final class ModArmor {
    // Silver
    public static final Item SILVER_HELMET = registerItem("silver_helmet",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.SILVER, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(10))));

    public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.SILVER, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(10))));

    public static final Item SILVER_LEGGINGS = registerItem("silver_leggings",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.SILVER, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(10))));

    public static final Item SILVER_BOOTS = registerItem("silver_boots",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.SILVER, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(10))));

    public static final Item SILVER_HORSE_ARMOR = registerItem("silver_horse_armor",
            p -> new Item(p.horseArmor(ModArmorMaterials.SILVER)));

    public static final Item SILVER_NAUTILUS_ARMOR = registerItem("silver_nautilus_armor",
            p -> new Item(p.nautilusArmor(ModArmorMaterials.SILVER)));

    // Steel
    public static final Item STEEL_HELMET = registerItem("steel_helmet",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.STEEL, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(23))));

    public static final Item STEEL_CHESTPLATE = registerItem("steel_chestplate",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.STEEL, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(23))));

    public static final Item STEEL_LEGGINGS = registerItem("steel_leggings",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.STEEL, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(23))));

    public static final Item STEEL_BOOTS = registerItem("steel_boots",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.STEEL, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(23))));

    public static final Item STEEL_HORSE_ARMOR = registerItem("steel_horse_armor",
            p -> new Item(p.horseArmor(ModArmorMaterials.STEEL)));

    public static final Item STEEL_NAUTILUS_ARMOR = registerItem("steel_nautilus_armor",
            p -> new Item(p.nautilusArmor(ModArmorMaterials.STEEL)));

    // Lead
    public static final Item LEAD_HELMET = registerItem("lead_helmet",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.LEAD, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(9))));

    public static final Item LEAD_CHESTPLATE = registerItem("lead_chestplate",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.LEAD, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(9))));

    public static final Item LEAD_LEGGINGS = registerItem("lead_leggings",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.LEAD, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(9))));

    public static final Item LEAD_BOOTS = registerItem("lead_boots",
            p -> new Item(p.humanoidArmor(ModArmorMaterials.LEAD, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(9))));

    public static final Item LEAD_HORSE_ARMOR = registerItem("lead_horse_armor",
            p -> new Item(p.horseArmor(ModArmorMaterials.LEAD)));

    public static final Item LEAD_NAUTILUS_ARMOR = registerItem("lead_nautilus_armor",
            p -> new Item(p.nautilusArmor(ModArmorMaterials.LEAD)));


    public static void register() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register(output -> {
                    output.accept(SILVER_HELMET);
                    output.accept(SILVER_CHESTPLATE);
                    output.accept(SILVER_LEGGINGS);
                    output.accept(SILVER_BOOTS);
                    output.accept(SILVER_HORSE_ARMOR);
                    output.accept(SILVER_NAUTILUS_ARMOR);

                    output.accept(STEEL_HELMET);
                    output.accept(STEEL_CHESTPLATE);
                    output.accept(STEEL_LEGGINGS);
                    output.accept(STEEL_BOOTS);
                    output.accept(STEEL_HORSE_ARMOR);
                    output.accept(STEEL_NAUTILUS_ARMOR);

                    output.accept(LEAD_HELMET);
                    output.accept(LEAD_CHESTPLATE);
                    output.accept(LEAD_LEGGINGS);
                    output.accept(LEAD_BOOTS);
                    output.accept(LEAD_HORSE_ARMOR);
                    output.accept(LEAD_NAUTILUS_ARMOR);
                });

        Mmm.LOGGER.info("{}: custom armor successfully registered.", Mmm.MOD_NAME);
    }

    private ModArmor() {}
}