package net.soaringpromise.mmm.mixin.common;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.soaringpromise.mmm.registry.ModArmorSetBonuses;
import net.soaringpromise.mmm.registry.ModArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Player.class)
public abstract class ArmorDamageMixin {
    @ModifyVariable(method = "actuallyHurt", at = @At("HEAD"), argsOnly = true, require = 1, name = "dmg")
    private float modularmetallurgy$modifyArmorDamage(float dmg, ServerLevel level, DamageSource source) {
        Player entity = (Player) (Object) this;

        if (!(entity instanceof ServerPlayer player))
            return dmg;

        if (ModArmorSetBonuses.hasFullSet(player, EquipmentAssets.COPPER) && source.is(DamageTypes.LIGHTNING_BOLT))
            return dmg * 4f;

        if (ModArmorSetBonuses.hasFullSet(player, EquipmentAssets.CHAINMAIL)) {
            boolean melee =
                    source.is(DamageTypes.MOB_ATTACK)
                            || source.is(DamageTypes.MOB_ATTACK_NO_AGGRO)
                            || source.is(DamageTypes.PLAYER_ATTACK)
                            || source.is(DamageTypes.MACE_SMASH)
                            || source.is(DamageTypes.SPEAR)
                            || source.is(DamageTypes.STING);

            if (melee) return dmg * 0.85f;
            if (source.is(DamageTypeTags.IS_PROJECTILE)) return dmg * 1.1f;
        }

        if (ModArmorSetBonuses.hasFullSet(player, ModArmorMaterials.SILVER_KEY)
                && source.getEntity() != null
                && BuiltInRegistries.ENTITY_TYPE.wrapAsHolder(source.getEntity().getType()).is(EntityTypeTags.UNDEAD))
            return dmg * 0.75f;

        if (ModArmorSetBonuses.hasFullSet(player, EquipmentAssets.DIAMOND) && source.is(DamageTypeTags.IS_EXPLOSION))
            return dmg * 1.15f;

        return dmg;
    }
}