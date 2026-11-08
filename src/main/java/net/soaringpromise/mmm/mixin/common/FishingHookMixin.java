package net.soaringpromise.mmm.mixin.common;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.soaringpromise.mmm.registry.ModTools;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FishingHook.class)
public abstract class FishingHookMixin {
    @WrapOperation(
            method = "shouldStopFishing",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Ljava/lang/Object;)Z"
            )
    )
    private boolean modularmetalurgy$allowSteelFishingRod(ItemStack stack, Object item, Operation<Boolean> original) {
        return original.call(stack, item) || (item == Items.FISHING_ROD && stack.is(ModTools.STEEL_FISHING_ROD));
    }
}