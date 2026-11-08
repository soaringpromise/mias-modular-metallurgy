package net.soaringpromise.mmm.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.soaringpromise.mmm.Mmm;
import net.soaringpromise.mmm.entity.SilverArrowEntity;

public final class ModEntities {

    private static final ResourceKey<EntityType<?>> SILVER_ARROW_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, Mmm.id("silver_arrow"));

    public static final EntityType<SilverArrowEntity> SILVER_ARROW =
            Registry.register(
                    BuiltInRegistries.ENTITY_TYPE,
                    SILVER_ARROW_KEY,
                    EntityType.Builder
                            .<SilverArrowEntity>of(SilverArrowEntity::new, MobCategory.MISC)
                            .noLootTable()
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build(SILVER_ARROW_KEY)
            );

    public static void register() {}

    private ModEntities() {}
}