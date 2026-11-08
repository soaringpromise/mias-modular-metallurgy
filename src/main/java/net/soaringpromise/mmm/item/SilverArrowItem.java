package net.soaringpromise.mmm.item;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.soaringpromise.mmm.entity.SilverArrowEntity;
import org.jspecify.annotations.NonNull;

public class SilverArrowItem extends ArrowItem {
    public SilverArrowItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull AbstractArrow createArrow(
            @NonNull Level level, ItemStack stack, @NonNull LivingEntity shooter, ItemStack weapon) {
        return new SilverArrowEntity(level, shooter, stack.copyWithCount(1), weapon);
    }

    @Override
    public @NonNull Projectile asProjectile(
            @NonNull Level level, Position position, ItemStack stack, @NonNull Direction direction) {
        SilverArrowEntity arrow = new SilverArrowEntity(
                level,
                position.x(), position.y(), position.z(),
                stack.copyWithCount(1), null
        );

        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }
}