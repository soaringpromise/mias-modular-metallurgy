package net.soaringpromise.mmm.registry;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public final class ModLootTables {
    public static void register() {
        LootTableEvents.MODIFY.register((key, table, source, registries) -> {
            if (!source.isBuiltin())
                return;

            if (key.equals(BuiltInLootTables.ABANDONED_MINESHAFT)) {
                addRareItem(table, ModArmor.LEAD_HORSE_ARMOR, 0.08f);
            }

            if (key.equals(BuiltInLootTables.DESERT_PYRAMID)) {
                addRareItem(table, ModArmor.SILVER_HORSE_ARMOR, 0.06f);
            }

            if (key.equals(BuiltInLootTables.VILLAGE_ARMORER)) {
                addRareItem(table, ModArmor.STEEL_HORSE_ARMOR, 0.05f);
            }
        });
    }

    private static void addRareItem(LootTable.Builder table, Item item, float chance) {
        table.withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .when(LootItemRandomChanceCondition.randomChance(chance))
                        .add(LootItem.lootTableItem(item))
        );
    }

    private ModLootTables() {}
}