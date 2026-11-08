package net.soaringpromise.mmm.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.soaringpromise.mmm.Mmm;

import java.util.List;

public final class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_BURIED_KEY = registerKey("silver_ore_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY = registerKey("lead_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE_BURIED_KEY = registerKey("lead_ore_buried");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        var silverTargets = getTargetBlockStates(ModBlocks.SILVER_ORE, ModBlocks.DEEPSLATE_SILVER_ORE);
        var leadTargets = getTargetBlockStates(ModBlocks.LEAD_ORE, ModBlocks.DEEPSLATE_LEAD_ORE);

        register(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(silverTargets, 6));
        register(context, SILVER_ORE_BURIED_KEY, Feature.ORE, new OreConfiguration(
                silverTargets, 8, 0.4f));

        register(context, LEAD_ORE_KEY, Feature.ORE, new OreConfiguration(leadTargets, 10));
        register(context, LEAD_ORE_BURIED_KEY, Feature.ORE, new OreConfiguration(
                leadTargets, 8, 0.2f));
    }


    private static List<OreConfiguration.TargetBlockState> getTargetBlockStates(
            Block stoneOre, Block deepslateOre
    ) {
        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        return List.of(
                OreConfiguration.target(stone, stoneOre.defaultBlockState()),
                OreConfiguration.target(deepslate, deepslateOre.defaultBlockState())
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Mmm.id(name));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstrapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC configuration
    ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private ModConfiguredFeatures() {}
}