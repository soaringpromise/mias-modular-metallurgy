package net.soaringpromise.mmm.mixin.common;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.Items;
import net.soaringpromise.mmm.registry.ModTools;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemPredicate.class)
public abstract class ItemPredicateMixin {
    @WrapOperation(
            method = "test(Lnet/minecraft/world/item/ItemInstance;)Z",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemInstance;is(Lnet/minecraft/core/HolderSet;)Z"
            )
    )
    private boolean modularmetallurgy$allowSteelShears(ItemInstance stack, HolderSet<Item> items, Operation<Boolean> original) {
        if (original.call(stack, items))
            return true;

        return stack.typeHolder().value() == ModTools.STEEL_SHEARS
                && items.size() == 1
                && items.contains(BuiltInRegistries.ITEM.wrapAsHolder(Items.SHEARS));
    }
}