package net.soaringpromise.mmm.registry;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.soaringpromise.mmm.Mmm;

public final class ModCreativeTabs {
    public static final CreativeModeTab SILVER_ITEM_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            Mmm.id("silver_items"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SILVER_INGOT))
                    .title(Component.translatable("tab.modular-metallurgy.silver_items"))
                    .displayItems((_, output) -> {
                        output.accept(ModBlocks.SILVER_ORE);
                        output.accept(ModBlocks.DEEPSLATE_SILVER_ORE);
                        output.accept(ModBlocks.RAW_SILVER_BLOCK);
                        output.accept(ModBlocks.SILVER_BLOCK);

                        output.accept(ModItems.RAW_SILVER);
                        output.accept(ModItems.SILVER_INGOT);
                        output.accept(ModItems.SILVER_NUGGET);

                        output.accept(ModTools.SILVER_PICKAXE);
                        output.accept(ModTools.SILVER_AXE);
                        output.accept(ModTools.SILVER_SHOVEL);
                        output.accept(ModTools.SILVER_HOE);

                        output.accept(ModTools.SILVER_SWORD);
                        output.accept(ModTools.SILVER_SPEAR);

                        output.accept(ModItems.SILVER_ARROW);
                    })
                    .build()
    );

    public static final CreativeModeTab STEEL_ITEM_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            Mmm.id("steel_items"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.STEEL_INGOT))
                    .title(Component.translatable("tab.modular-metallurgy.steel_items"))
                    .displayItems((_, output) -> {
                        output.accept(ModBlocks.STEEL_BLOCK);

                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModItems.STEEL_NUGGET);

                        output.accept(ModTools.STEEL_PICKAXE);
                        output.accept(ModTools.STEEL_AXE);
                        output.accept(ModTools.STEEL_SHOVEL);
                        output.accept(ModTools.STEEL_HOE);

                        output.accept(ModTools.STEEL_SWORD);
                        output.accept(ModTools.STEEL_SPEAR);

                        output.accept(ModTools.STEEL_FISHING_ROD);
                        output.accept(ModTools.STEEL_SHEARS);
                    })
                    .build()
    );

    public static final CreativeModeTab LEAD_ITEM_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            Mmm.id("lead_items"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.LEAD_INGOT))
                    .title(Component.translatable("tab.modular-metallurgy.lead_items"))
                    .displayItems((_, output) -> {
                        output.accept(ModBlocks.LEAD_ORE);
                        output.accept(ModBlocks.DEEPSLATE_LEAD_ORE);
                        output.accept(ModBlocks.RAW_LEAD_BLOCK);
                        output.accept(ModBlocks.LEAD_BLOCK);

                        output.accept(ModItems.RAW_LEAD);
                        output.accept(ModItems.LEAD_INGOT);
                        output.accept(ModItems.LEAD_NUGGET);

                        output.accept(ModTools.LEAD_PICKAXE);
                        output.accept(ModTools.LEAD_AXE);
                        output.accept(ModTools.LEAD_SHOVEL);
                        output.accept(ModTools.LEAD_HOE);

                        output.accept(ModTools.LEAD_SWORD);
                        output.accept(ModTools.LEAD_SPEAR);
                    })
                    .build()
    );

    public static void register() {
    }

    private ModCreativeTabs() {
    }
}