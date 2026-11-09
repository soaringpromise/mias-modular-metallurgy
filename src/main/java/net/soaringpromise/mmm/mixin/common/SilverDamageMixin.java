package net.soaringpromise.mmm.mixin.common;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.soaringpromise.mmm.config.MetallurgyConfig;
import net.soaringpromise.mmm.registry.ModTools;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class SilverDamageMixin {
    @ModifyVariable(method = "hurtServer", at = @At("HEAD"), argsOnly = true, require = 1, name = "damage")
    private float modularmetallurgy$modifySilverDamage(float damage, ServerLevel level, DamageSource source) {
        if (!MetallurgyConfig.INSTANCE.silverUndeadDamageBonus.get())
            return damage;

        LivingEntity target = (LivingEntity) (Object) this;

        if (!BuiltInRegistries.ENTITY_TYPE.wrapAsHolder(target.getType()).is(EntityTypeTags.UNDEAD))
            return damage;

        if (!(source.getDirectEntity() instanceof ServerPlayer player))
            return damage;

        if (!source.is(DamageTypes.PLAYER_ATTACK) && !source.is(DamageTypes.SPEAR))
            return damage;

        ItemStack weapon = player.getMainHandItem();

        boolean silverTool = weapon.is(ModTools.SILVER_SWORD)
                || weapon.is(ModTools.SILVER_AXE)
                || weapon.is(ModTools.SILVER_PICKAXE)
                || weapon.is(ModTools.SILVER_SHOVEL)
                || weapon.is(ModTools.SILVER_HOE)
                || weapon.is(ModTools.SILVER_SPEAR);

        return silverTool ? damage * 2.0f : damage;
    }
}