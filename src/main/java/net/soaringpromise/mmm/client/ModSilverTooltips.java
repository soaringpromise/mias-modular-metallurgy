package net.soaringpromise.mmm.client;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.soaringpromise.mmm.config.MetallurgyConfig;
import net.soaringpromise.mmm.registry.ModItems;
import net.soaringpromise.mmm.registry.ModTools;

public final class ModSilverTooltips {
    private ModSilverTooltips() {}

    public static void register() {
        ItemTooltipCallback.EVENT.register((stack, _, _, lines) -> {
            boolean silverArrow = stack.is(ModItems.SILVER_ARROW);
            boolean silverTool = isSilverTool(stack)
                    && MetallurgyConfig.INSTANCE.silverUndeadDamageBonus.get();

            if (silverArrow || silverTool) {
                lines.add(Component.translatable(
                        "tooltip.modular-metallurgy.silver.undead_damage"
                ).withStyle(ChatFormatting.GRAY));
            }
        });
    }

    private static boolean isSilverTool(ItemStack stack) {
        return stack.is(ModTools.SILVER_SWORD)
                || stack.is(ModTools.SILVER_PICKAXE)
                || stack.is(ModTools.SILVER_AXE)
                || stack.is(ModTools.SILVER_SHOVEL)
                || stack.is(ModTools.SILVER_HOE)
                || stack.is(ModTools.SILVER_SPEAR);
    }
}