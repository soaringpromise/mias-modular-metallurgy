package net.soaringpromise.mmm.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.soaringpromise.mmm.Mmm;

import java.util.function.Function;

public final class ModBlocks {
    public static final Block SILVER_BLOCK = registerBlock("silver_block",
            p -> new Block(p.sound(SoundType.METAL).destroyTime(10f).explosionResistance(150f)
                    .requiresCorrectToolForDrops()));

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            p -> new Block(p.sound(SoundType.NETHERITE_BLOCK).destroyTime(20f).explosionResistance(300f)
                    .requiresCorrectToolForDrops()));

    public static final Block LEAD_BLOCK = registerBlock("lead_block",
            p -> new Block(p.sound(SoundType.METAL).destroyTime(10f).explosionResistance(150f)
                    .requiresCorrectToolForDrops()));

    public static final Block RAW_SILVER_BLOCK = registerBlock(
            "raw_silver_block",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)
    );

    public static final Block RAW_LEAD_BLOCK = registerBlock(
            "raw_lead_block",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)
    );

    public static final Block SILVER_ORE = registerBlock("silver_ore",
            p -> new DropExperienceBlock(UniformInt.of(2, 5),
                    p.sound(SoundType.STONE).destroyTime(3f).explosionResistance(3f)
                    .requiresCorrectToolForDrops()));

    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            p -> new DropExperienceBlock(UniformInt.of(2, 5),
                    p.sound(SoundType.DEEPSLATE).destroyTime(4.5f).explosionResistance(4f)
                    .requiresCorrectToolForDrops()));

    public static final Block LEAD_ORE = registerBlock("lead_ore",
            p -> new DropExperienceBlock(UniformInt.of(2, 5),
                    p.sound(SoundType.STONE).destroyTime(2.5f).explosionResistance(3f)
                    .requiresCorrectToolForDrops()));

    public static final Block DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            p -> new DropExperienceBlock(UniformInt.of(2, 5),
                    p.sound(SoundType.DEEPSLATE).destroyTime(4f).explosionResistance(4f)
                    .requiresCorrectToolForDrops()));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> factory) {
        return registerBlock(name, factory, BlockBehaviour.Properties.of());
    }

    private static Block registerBlock(
            String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Mmm.id(name));
        Block block = factory.apply(properties.setId(key));
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Mmm.id(name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Mmm.id(name)))));
    }
    public static void register() {}

    private ModBlocks() {}
}