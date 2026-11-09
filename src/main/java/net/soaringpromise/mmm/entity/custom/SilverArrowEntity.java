package net.soaringpromise.mmm.entity.custom;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.soaringpromise.mmm.registry.ModEntities;
import net.soaringpromise.mmm.registry.ModItems;
import org.jspecify.annotations.NonNull;

public class SilverArrowEntity extends AbstractArrow {
    private static final float SPEED_MULTIPLIER = 1.2f;
    private static final double UNDEAD_MULTIPLIER = 2.0;

    private double normalBaseDamage = 2.0;

    public SilverArrowEntity(EntityType<? extends SilverArrowEntity> type, Level level) {
        super(type, level);
        setBaseDamage(2.0);
    }

    public SilverArrowEntity(Level level, LivingEntity shooter, ItemStack arrow, ItemStack weapon) {
        super(ModEntities.SILVER_ARROW, shooter, level, arrow, weapon);
        setBaseDamage(2.0);
    }

    public SilverArrowEntity(Level level, double x, double y, double z, ItemStack arrow, ItemStack weapon) {
        super(ModEntities.SILVER_ARROW, x, y, z, level, arrow, weapon);
        setBaseDamage(2.0);
    }

    @Override
    public void shoot(double x, double y, double z, float speed, float uncertainty) {
        super.shoot(x, y, z, speed * SPEED_MULTIPLIER, uncertainty);
    }

    @Override
    public void setBaseDamage(double damage) {
        normalBaseDamage = damage;
        super.setBaseDamage(damage / SPEED_MULTIPLIER);
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        if (BuiltInRegistries.ENTITY_TYPE.wrapAsHolder(hitResult.getEntity().getType()).is(EntityTypeTags.UNDEAD)) {
            super.setBaseDamage(normalBaseDamage * UNDEAD_MULTIPLIER / SPEED_MULTIPLIER);

            try {
                super.onHitEntity(hitResult);
            } finally {
                super.setBaseDamage(normalBaseDamage / SPEED_MULTIPLIER);
            }
        } else {
            super.onHitEntity(hitResult);
        }
    }

    @Override
    protected @NonNull ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.SILVER_ARROW);
    }
}