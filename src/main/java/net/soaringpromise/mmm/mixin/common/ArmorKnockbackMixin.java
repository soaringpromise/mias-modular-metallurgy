package net.soaringpromise.mmm.mixin.common;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.soaringpromise.mmm.registry.ModArmorSetBonuses;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class ArmorKnockbackMixin {
    @ModifyVariable(method = "knockback", at = @At("HEAD"), argsOnly = true, require = 1, name = "power")
    private double modularmetallurgy$modifyArmorKnockback(double power) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity instanceof ServerPlayer player && ModArmorSetBonuses.hasFullSet(player, EquipmentAssets.COPPER))
            return power * 1.25;

        return power;
    }
}