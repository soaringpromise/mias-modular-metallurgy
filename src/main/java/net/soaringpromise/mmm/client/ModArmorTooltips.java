package net.soaringpromise.mmm.client;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.soaringpromise.mmm.registry.ModArmorMaterials;
import net.soaringpromise.mmm.registry.ModArmorSetBonuses;

import java.util.Map;
import java.util.List;

public final class ModArmorTooltips {
    private record SetTooltip(String material, int bonuses, int drawbacks) {}

    private static final Map<ResourceKey<EquipmentAsset>, SetTooltip> SETS =
            Map.ofEntries(
                    Map.entry(EquipmentAssets.LEATHER, new SetTooltip("leather", 2, 0)),
                    Map.entry(EquipmentAssets.GOLD, new SetTooltip("gold", 1, 0)),
                    Map.entry(EquipmentAssets.COPPER, new SetTooltip("copper", 2, 2)),
                    Map.entry(EquipmentAssets.CHAINMAIL, new SetTooltip("chainmail", 1, 1)),
                    Map.entry(ModArmorMaterials.LEAD_KEY, new SetTooltip("lead", 2, 1)),
                    Map.entry(EquipmentAssets.IRON, new SetTooltip("iron", 1, 0)),
                    Map.entry(ModArmorMaterials.SILVER_KEY, new SetTooltip("silver", 1, 0)),
                    Map.entry(ModArmorMaterials.STEEL_KEY, new SetTooltip("steel", 1, 2)),
                    Map.entry(EquipmentAssets.DIAMOND, new SetTooltip("diamond", 1, 1)),
                    Map.entry(EquipmentAssets.NETHERITE, new SetTooltip("netherite", 2, 1))
            );

    private ModArmorTooltips() {}

    public static void register() {
        ItemTooltipCallback.EVENT.register((stack, _, _, lines) -> {
            Equippable equippable = stack.get(DataComponents.EQUIPPABLE);

            if (equippable == null || !isArmorSlot(equippable.slot()))
                return;

            ResourceKey<EquipmentAsset> assetId = equippable.assetId().orElse(null);

            if (assetId == null || !ModArmorSetBonuses.isSetBonusEnabled(assetId))
                return;

            SetTooltip data = SETS.get(assetId);

            if (data == null) return;

            appendTooltip(lines, data);
        });
    }

    private static boolean isArmorSlot(EquipmentSlot slot) {
        return switch (slot) {
            case HEAD, CHEST, LEGS, FEET -> true;
            default -> false;
        };
    }

    private static void appendTooltip(List<Component> lines, SetTooltip data) {
        String prefix = "tooltip.modular-metallurgy.armor." + data.material();

        lines.add(Component.empty());
        lines.add(Component.translatable("tooltip.modular-metallurgy.armor.full_set")
                .withStyle(ChatFormatting.GOLD));

        for (int i = 1; i <= data.bonuses(); i++) {
            lines.add(Component.translatable(prefix + ".bonus." + i)
                    .withStyle(ChatFormatting.GREEN));
        }

        for (int i = 1; i <= data.drawbacks(); i++) {
            lines.add(Component.translatable(prefix + ".drawback." + i)
                    .withStyle(ChatFormatting.RED));
        }
    }
}