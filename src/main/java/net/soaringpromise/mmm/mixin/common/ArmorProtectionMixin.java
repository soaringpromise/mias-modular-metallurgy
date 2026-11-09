package net.soaringpromise.mmm.mixin.common;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.soaringpromise.mmm.registry.ModArmorSetBonuses;
import net.soaringpromise.mmm.registry.ModArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public abstract class ArmorProtectionMixin {
    @Inject(method = "getDamageProtection", at = @At("RETURN"), cancellable = true)
    private static void modularmetallurgy$modifyArmorProtection(
            ServerLevel serverLevel,
            LivingEntity victim,
            DamageSource source,
            CallbackInfoReturnable<Float> cir
    ) {
        if (!(victim instanceof ServerPlayer player))
            return;

        if (source.is(DamageTypeTags.IS_EXPLOSION)
                && ModArmorSetBonuses.hasFullSet(player, ModArmorMaterials.LEAD_KEY)) {
            cir.setReturnValue(cir.getReturnValueF() + 4.0f);
        }

        if (source.is(DamageTypeTags.IS_PROJECTILE)
                && ModArmorSetBonuses.hasFullSet(player, EquipmentAssets.DIAMOND)) {
            cir.setReturnValue(cir.getReturnValueF() + 4.0f);
        }

        if (source.is(DamageTypeTags.IS_FIRE)
                && ModArmorSetBonuses.hasFullSet(player, EquipmentAssets.NETHERITE)) {
            cir.setReturnValue(cir.getReturnValueF() + 4.0f);
        }
    }
}