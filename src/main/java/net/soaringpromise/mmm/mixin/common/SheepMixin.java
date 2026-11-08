package net.soaringpromise.mmm.mixin.common;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.soaringpromise.mmm.registry.ModTools;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Sheep.class)
public abstract class SheepMixin {
    @WrapOperation(
            method = "mobInteract",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;is(Ljava/lang/Object;)Z"
            )
    )
    private boolean mmm$allowSteelShears(ItemStack stack, Object item, Operation<Boolean> original) {
        return original.call(stack, item) || (item == Items.SHEARS && stack.is(ModTools.STEEL_SHEARS));
    }
}