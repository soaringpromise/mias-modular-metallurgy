package net.soaringpromise.mmm.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.soaringpromise.mmm.registry.ModEntities;

public class MmmClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRenderers.register(ModEntities.SILVER_ARROW, SilverArrowRenderer::new);
    }
}