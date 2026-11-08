
package net.soaringpromise.mmm.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.soaringpromise.mmm.Mmm;

import static net.soaringpromise.mmm.registry.ModItems.registerItem;

public final class ModTools {
    public static final Item SILVER_SWORD = registerItem("silver_sword",
            p -> new Item(p.sword(ModToolMaterials.SILVER, 3f, -2.2f)));

    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe",
            p -> new Item(p.pickaxe(ModToolMaterials.SILVER, 1f, -2.4f)));

    public static final Item SILVER_SHOVEL = registerItem("silver_shovel",
            p -> new ShovelItem(ModToolMaterials.SILVER, 1.5f, -2.6f, p));

    public static final Item SILVER_AXE = registerItem("silver_axe",
            p -> new AxeItem(ModToolMaterials.SILVER, 5.5f, -2.9f, p));

    public static final Item SILVER_HOE = registerItem("silver_hoe",
            p -> new HoeItem(ModToolMaterials.SILVER, 0f, -2.6f, p));

    public static final Item SILVER_SPEAR = registerItem("silver_spear",
            p -> new Item(p.spear(ModToolMaterials.SILVER,
                    0.85f, 0.8f, 0.65f,
                    3f, 13f, 7f, 5.5f, 11.5f, 5f)));


    public static final Item STEEL_SWORD = registerItem("steel_sword",
            p -> new Item(p.sword(ModToolMaterials.STEEL, 4f, -2.7f)));

    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe",
            p -> new Item(p.pickaxe(ModToolMaterials.STEEL, 1f, -2.8f)));

    public static final Item STEEL_SHOVEL = registerItem("steel_shovel",
            p -> new ShovelItem(ModToolMaterials.STEEL, 1.5f, -3f, p));

    public static final Item STEEL_AXE = registerItem("steel_axe",
            p -> new AxeItem(ModToolMaterials.STEEL, 5.5f, -3.1f, p));

    public static final Item STEEL_HOE = registerItem("steel_hoe",
            p -> new HoeItem(ModToolMaterials.STEEL, 0f, -3f, p));

    public static final Item STEEL_SPEAR = registerItem("steel_spear",
            p -> new Item(p.spear(ModToolMaterials.STEEL,
                    1f, 1f, 0.6f,
                    3f, 11f, 5f, 6f, 13f, 5f)));

    public static final Item STEEL_FISHING_ROD = registerItem("steel_fishing_rod",
            p -> new FishingRodItem(p.durability(192).enchantable(13)));

    public static final Item STEEL_SHEARS = registerItem("steel_shears",
            p -> new ShearsItem(p.durability(400).component(
                    DataComponents.TOOL, ShearsItem.createToolProperties())));

    public static final Item LEAD_SWORD = registerItem("lead_sword",
            p -> new Item(p.sword(ModToolMaterials.LEAD, 4f, -3.1f)));

    public static final Item LEAD_PICKAXE = registerItem("lead_pickaxe",
            p -> new Item(p.pickaxe(ModToolMaterials.LEAD, 1f, -3.2f)));

    public static final Item LEAD_SHOVEL = registerItem("lead_shovel",
            p -> new ShovelItem(ModToolMaterials.LEAD, 1.5f, -3.3f, p));

    public static final Item LEAD_AXE = registerItem("lead_axe",
            p -> new AxeItem(ModToolMaterials.LEAD, 7f, -3.5f, p));

    public static final Item LEAD_HOE = registerItem("lead_hoe",
            p -> new HoeItem(ModToolMaterials.LEAD, 0f, -3.3f, p));

    public static final Item LEAD_SPEAR = registerItem("lead_spear",
            p -> new Item(p.spear(ModToolMaterials.LEAD,
                    1.25f, 1.15f, 0.8f,
                    3f, 11f, 6f, 5.5f, 11f, 5f)));


    public static void register() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(output -> {
                    output.accept(STEEL_PICKAXE);
                    output.accept(STEEL_SHOVEL);
                    output.accept(STEEL_AXE);
                    output.accept(STEEL_HOE);
                    output.accept(STEEL_FISHING_ROD);
                    output.accept(STEEL_SHEARS);

                    output.accept(SILVER_PICKAXE);
                    output.accept(SILVER_SHOVEL);
                    output.accept(SILVER_AXE);
                    output.accept(SILVER_HOE);

                    output.accept(LEAD_PICKAXE);
                    output.accept(LEAD_SHOVEL);
                    output.accept(LEAD_AXE);
                    output.accept(LEAD_HOE);
                });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register(output -> {
                    output.accept(STEEL_SWORD);
                    output.accept(STEEL_SPEAR);

                    output.accept(SILVER_SWORD);
                    output.accept(SILVER_SPEAR);

                    output.accept(LEAD_SWORD);
                    output.accept(LEAD_SPEAR);
                });

        Mmm.LOGGER.info("{}: custom tools successfully registered.", Mmm.MOD_NAME);
    }

    private ModTools() {}
}