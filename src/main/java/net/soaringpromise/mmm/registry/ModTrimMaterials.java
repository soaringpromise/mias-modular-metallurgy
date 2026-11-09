package net.soaringpromise.mmm.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.soaringpromise.mmm.Mmm;

public final class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> SILVER =
            ResourceKey.create(Registries.TRIM_MATERIAL, Mmm.id("silver"));
    public static final ResourceKey<TrimMaterial> LEAD =
            ResourceKey.create(Registries.TRIM_MATERIAL, Mmm.id("lead"));

    private ModTrimMaterials() {}
}