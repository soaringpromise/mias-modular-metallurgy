package net.soaringpromise.mmm.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.soaringpromise.mmm.Mmm;

import java.util.List;

public final class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_LOWER_PLACED_KEY = registerKey("silver_ore_lower_placed");
    public static final ResourceKey<PlacedFeature> LEAD_ORE_PLACED_KEY = registerKey("lead_ore_placed");
    public static final ResourceKey<PlacedFeature> LEAD_ORE_LOWER_PLACED_KEY = registerKey("lead_ore_lower_placed");

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Mmm.id(name));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        var silverOre = configuredFeatures.getOrThrow(ModConfiguredFeatures.SILVER_ORE_KEY);
        var silverOreBuried = configuredFeatures.getOrThrow(ModConfiguredFeatures.SILVER_ORE_BURIED_KEY);

        var leadOre = configuredFeatures.getOrThrow(ModConfiguredFeatures.LEAD_ORE_KEY);
        var leadOreBuried = configuredFeatures.getOrThrow(ModConfiguredFeatures.LEAD_ORE_BURIED_KEY);

        register(
                context,
                SILVER_ORE_PLACED_KEY,
                silverOre,
                OrePlacements.commonOrePlacement(
                        3,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(32)
                        )
                )
        );

        register(
                context,
                SILVER_ORE_LOWER_PLACED_KEY,
                silverOreBuried,
                OrePlacements.orePlacement(
                        CountPlacement.of(UniformInt.of(0, 1)),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(-48)
                        )
                )
        );

        register(
                context,
                LEAD_ORE_PLACED_KEY,
                leadOre,
                OrePlacements.commonOrePlacement(
                        5,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(48)
                        )
                )
        );

        register(
                context,
                LEAD_ORE_LOWER_PLACED_KEY,
                leadOreBuried,
                OrePlacements.orePlacement(
                        CountPlacement.of(UniformInt.of(0, 3)),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(-32)
                        )
                )
        );
    }

    private static void register(
        BootstrapContext<PlacedFeature> context,
        ResourceKey<PlacedFeature> key,
        Holder<ConfiguredFeature<?, ?>> config,
        List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(config, modifiers));
    }

    private ModPlacedFeatures() {}
}