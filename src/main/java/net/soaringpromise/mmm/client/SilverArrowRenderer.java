package net.soaringpromise.mmm.client;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;
import net.soaringpromise.mmm.Mmm;
import net.soaringpromise.mmm.entity.SilverArrowEntity;
import org.jspecify.annotations.NonNull;

public class SilverArrowRenderer extends ArrowRenderer<SilverArrowEntity, ArrowRenderState> {

    private static final Identifier TEXTURE = Mmm.id("textures/entity/projectiles/silver_arrow.png");

    public SilverArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NonNull ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }

    @Override
    protected @NonNull Identifier getTextureLocation(@NonNull ArrowRenderState state) {
        return TEXTURE;
    }
}