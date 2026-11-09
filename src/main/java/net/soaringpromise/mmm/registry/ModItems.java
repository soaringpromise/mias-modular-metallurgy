package net.soaringpromise.mmm.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.soaringpromise.mmm.Mmm;
import net.soaringpromise.mmm.item.custom.SilverArrowItem;

import java.util.function.Function;

public final class ModItems {
    public static final Item RAW_SILVER = registerItem("raw_silver", Item::new);
    public static final Item RAW_LEAD = registerItem("raw_lead", Item::new);

    public static final Item SILVER_INGOT = registerItem("silver_ingot",
            p -> new Item(p.trimMaterial(ModTrimMaterials.SILVER)));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", Item::new);
    public static final Item LEAD_INGOT = registerItem("lead_ingot",
            p -> new Item(p.trimMaterial(ModTrimMaterials.LEAD)));

    public static final Item SILVER_NUGGET = registerItem("silver_nugget", Item::new);
    public static final Item STEEL_NUGGET = registerItem("steel_nugget", Item::new);
    public static final Item LEAD_NUGGET = registerItem("lead_nugget", Item::new);

    public static final Item SILVER_ARROW = registerItem("silver_arrow", SilverArrowItem::new);
    public static final Item STEEL_BLEND = registerItem("steel_blend", Item::new);

    public static Item registerItem(String name, Function<Item.Properties, Item> factory) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Mmm.id(name));
        Item.Properties properties = new Item.Properties().setId(key);

        return Registry.register(BuiltInRegistries.ITEM, key, factory.apply(properties));
    }

    public static void register() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(STEEL_INGOT);
            output.accept(RAW_SILVER);
            output.accept(SILVER_INGOT);
        });
    }

    private ModItems() {
    }
}