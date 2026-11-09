package net.soaringpromise.mmm.registry;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.soaringpromise.mmm.Mmm;

public final class ModArmorSetBonuses {
    private static final EquipmentSlot[] ARMOR_SLOTS = {
            EquipmentSlot.HEAD,
            EquipmentSlot.CHEST,
            EquipmentSlot.LEGS,
            EquipmentSlot.FEET
    };

    private static final Identifier LEATHER_JUMP_ID = Mmm.id("full_leather_set_jump");
    private static final Identifier LEATHER_FALL_ID = Mmm.id("full_leather_set_fall_damage");

    private static final Identifier GOLD_ATTACK_SPEED_ID = Mmm.id("full_gold_set_attack_speed");

    private static final Identifier COPPER_SPEED_ID = Mmm.id("full_copper_set_speed");
    private static final Identifier COPPER_MINING_ID = Mmm.id("full_copper_set_mining");

    private static final Identifier LEAD_HEALTH_ID = Mmm.id("full_lead_set_health");
    private static final Identifier LEAD_EXPLOSION_KNOCKBACK_ID = Mmm.id("full_lead_set_explosion_knockback");

    private static final Identifier IRON_KNOCKBACK_ID = Mmm.id("full_iron_set_knockback");

    private static final Identifier STEEL_HEALTH_ID = Mmm.id("full_steel_set_health");
    private static final Identifier STEEL_SPEED_ID = Mmm.id("full_steel_set_speed");
    private static final Identifier STEEL_JUMP_ID = Mmm.id("full_steel_set_jump");

    private static final Identifier NETHERITE_BURNING_TIME_ID = Mmm.id("full_netherite_set_burning_time");
    private static final Identifier NETHERITE_GRAVITY_ID = Mmm.id("full_netherite_set_gravity");

    private ModArmorSetBonuses() {}

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                updatePlayer(player);
            }
        });
    }

    private static void updatePlayer(ServerPlayer player) {
        boolean wearingLeather = hasFullSet(player, EquipmentAssets.LEATHER);
        boolean wearingGold = hasFullSet(player, EquipmentAssets.GOLD);
        boolean wearingCopper = hasFullSet(player, EquipmentAssets.COPPER);
        boolean wearingLead = hasFullSet(player, ModArmorMaterials.LEAD_KEY);
        boolean wearingIron = hasFullSet(player, EquipmentAssets.IRON);
        boolean wearingSteel = hasFullSet(player, ModArmorMaterials.STEEL_KEY);
        boolean wearingNetherite = hasFullSet(player, EquipmentAssets.NETHERITE);

        updateModifier(player, Attributes.JUMP_STRENGTH, LEATHER_JUMP_ID,
                0.12, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, wearingLeather);

        updateModifier(player, Attributes.FALL_DAMAGE_MULTIPLIER, LEATHER_FALL_ID,
                -0.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, wearingLeather);

        updateModifier(player, Attributes.ATTACK_SPEED, GOLD_ATTACK_SPEED_ID,
                0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, wearingGold);

        updateModifier(player, Attributes.MOVEMENT_SPEED, COPPER_SPEED_ID,
                0.12, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, wearingCopper);

        updateModifier(player, Attributes.BLOCK_BREAK_SPEED, COPPER_MINING_ID,
                0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, wearingCopper);

        updateModifier(player, Attributes.MAX_HEALTH, LEAD_HEALTH_ID,
                -4, AttributeModifier.Operation.ADD_VALUE, wearingLead);

        updateModifier(player, Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, LEAD_EXPLOSION_KNOCKBACK_ID,
                0.3, AttributeModifier.Operation.ADD_VALUE, wearingLead);

        updateModifier(player, Attributes.KNOCKBACK_RESISTANCE, IRON_KNOCKBACK_ID,
                0.2, AttributeModifier.Operation.ADD_VALUE, wearingIron);

        updateModifier(player, Attributes.MAX_HEALTH, STEEL_HEALTH_ID,
                4, AttributeModifier.Operation.ADD_VALUE, wearingSteel);

        updateModifier(player, Attributes.MOVEMENT_SPEED, STEEL_SPEED_ID,
                -0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, wearingSteel);

        updateModifier(player, Attributes.JUMP_STRENGTH, STEEL_JUMP_ID,
                -0.06, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, wearingSteel);

        updateModifier(player, Attributes.BURNING_TIME, NETHERITE_BURNING_TIME_ID,
                -0.3, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, wearingNetherite);

        updateModifier(player, Attributes.GRAVITY, NETHERITE_GRAVITY_ID,
                0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, wearingNetherite);

        if (player.getHealth() > player.getMaxHealth())
            player.setHealth(player.getMaxHealth());
    }

    public static boolean hasFullSet(ServerPlayer player, ResourceKey<EquipmentAsset> assetId
    ) {
        for (EquipmentSlot slot : ARMOR_SLOTS) {
            ItemStack stack = player.getItemBySlot(slot);
            if (stack.isEmpty())
                return false;

            Equippable equippable = stack.get(DataComponents.EQUIPPABLE);
            if (equippable == null
                    || equippable.slot() != slot
                    || equippable.assetId().isEmpty()
                    || !equippable.assetId().get().equals(assetId)) {
                return false;
            }
        }
        return true;
    }

    private static void updateModifier(
            ServerPlayer player,
            Holder<Attribute> attribute,
            Identifier id,
            double amount,
            AttributeModifier.Operation operation,
            boolean active
    ) {
        AttributeInstance instance = player.getAttribute(attribute);
        if (instance == null)
            return;

        if (active) {
            if (!instance.hasModifier(id)) {
                instance.addTransientModifier(new AttributeModifier(id, amount, operation));
            }
        } else if (instance.hasModifier(id)) {
            instance.removeModifier(id);
        }
    }
}