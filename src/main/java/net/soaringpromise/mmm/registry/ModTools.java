package net.soaringpromise.mmm.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.*;
import net.soaringpromise.mmm.Mmm;

import static net.soaringpromise.mmm.registry.ModItems.registerItem;

public final class ModTools {
    public static final Item SILVER_SWORD = registerItem("silver_sword",
            p -> new Item(p.sword(ModToolMaterials.SILVER, 2f, -2f)));
    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe",
            p -> new Item(p.pickaxe(ModToolMaterials.SILVER, 1f, -2.4f)));
    public static final Item SILVER_SHOVEL = registerItem("silver_shovel",
            p -> new ShovelItem(ModToolMaterials.SILVER, 1.5f, -2.6f, p));
    public static final Item SILVER_AXE = registerItem("silver_axe",
            p -> new AxeItem(ModToolMaterials.SILVER, 5.5f, -3f, p));
    public static final Item SILVER_HOE = registerItem("silver_hoe",
            p -> new HoeItem(ModToolMaterials.SILVER, 0f, -2.6f, p));
    public static final Item SILVER_SPEAR = registerItem("silver_spear",
            p -> new Item(p.spear(ModToolMaterials.SILVER, 1f, 0.8f, 0.7f,
                    3f, 11f, 7f, 5.5f, 11.5f, 5f)));

    public static final Item STEEL_SWORD = registerItem("steel_sword",
            p -> new Item(p.sword(ModToolMaterials.STEEL, 4f, -2.6f)));
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe",
            p -> new Item(p.pickaxe(ModToolMaterials.STEEL, 2f, -3f)));
    public static final Item STEEL_SHOVEL = registerItem("steel_shovel",
            p -> new ShovelItem(ModToolMaterials.STEEL, 2.5f, -3.2f, p));
    public static final Item STEEL_AXE = registerItem("steel_axe",
            p -> new AxeItem(ModToolMaterials.STEEL, 7f, -3.4f, p));
    public static final Item STEEL_HOE = registerItem("steel_hoe",
            p -> new HoeItem(ModToolMaterials.STEEL, 1f, -3f, p));
    public static final Item STEEL_SPEAR = registerItem("steel_spear",
            p -> new Item(p.spear(ModToolMaterials.STEEL, 1f, 1.1f, 0.6f,
                    3f, 11f, 5f, 6f, 13f, 5f)));

    public static void register() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(STEEL_PICKAXE);
            output.accept(STEEL_SHOVEL);
            output.accept(STEEL_AXE);
            output.accept(STEEL_HOE);

            output.accept(SILVER_PICKAXE);
            output.accept(SILVER_SHOVEL);
            output.accept(SILVER_AXE);
            output.accept(SILVER_HOE);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(STEEL_SWORD);
            output.accept(STEEL_SPEAR);

            output.accept(SILVER_SWORD);
            output.accept(SILVER_SPEAR);
        });

        Mmm.LOGGER.info("{}: custom tools successfully registered.", Mmm.MOD_NAME);
    }

    private ModTools() {}
}