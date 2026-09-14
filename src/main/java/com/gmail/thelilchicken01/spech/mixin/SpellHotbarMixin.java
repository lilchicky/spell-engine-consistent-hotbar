package com.gmail.thelilchicken01.spech.mixin;

import com.gmail.thelilchicken01.spech.util.SpECHTags;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.spell_engine.api.spell.container.SpellContainer;
import net.spell_engine.api.spell.container.SpellContainerHelper;
import net.spell_engine.client.SpellEngineClient;
import net.spell_engine.client.input.SpellHotbar;
import net.spell_engine.client.input.WrappedKeybinding;
import net.spell_engine.mixin.client.control.KeybindingAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpellHotbar.class)
public class SpellHotbarMixin {
    @Inject(
            method = "expectedUseStack",
            at = @At("RETURN"),
            cancellable = true
    )
    private static void spech$forceItemUseSlot(
            Player player,
            CallbackInfoReturnable<SpellHotbar.ItemUseExpectation> cir
    ) {
        if (cir.getReturnValue() == null) {
            ItemStack stack = player.getMainHandItem();

            if (!stack.isEmpty()) {
                SpellContainer item_spells = SpellContainerHelper.containerFromItemStack(stack);

                if (item_spells != null && (item_spells.spell_ids().isEmpty() || stack.is(SpECHTags.Items.HAS_NON_SPELL_ENGINE_SPELL))) {
                    cir.setReturnValue(new SpellHotbar.ItemUseExpectation(InteractionHand.MAIN_HAND, stack));
                }
            }
        }
    }

    @ModifyVariable(method = "update(Lnet/minecraft/client/player/LocalPlayer;Lnet/minecraft/client/Options;)Z", at = @At(value = "INVOKE", target = "Lnet/spell_engine/mixin/client/control/KeybindingAccessor;spellEngine_getBoundKey()Lcom/mojang/blaze3d/platform/InputConstants$Key;", ordinal = 1, shift = At.Shift.AFTER), name = "keyBindingIndex")
    private int spech$skipUseKey(int keyBindingIndex, @Local(name = "useKey") InputConstants.Key useKey, @Local(name = "unwrapped") WrappedKeybinding.Unwrapped unwrapped) {
        return (SpellEngineClient.config.spellHotbarUseKey && ((KeybindingAccessor)unwrapped.keyBinding()).spellEngine_getBoundKey().equals(useKey)) ? keyBindingIndex - 1 : keyBindingIndex;
    }
}
