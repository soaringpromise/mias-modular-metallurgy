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
                        output.accept(ModItems.SILVER_INGOT);
                        output.accept(ModItems.SILVER_NUGGET);
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
                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModItems.STEEL_NUGGET);
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
                        output.accept(ModItems.LEAD_INGOT);
                        output.accept(ModItems.LEAD_NUGGET);
                    })
                    .build()
    );

    public static void register() {
    }

    private ModCreativeTabs() {
    }
}