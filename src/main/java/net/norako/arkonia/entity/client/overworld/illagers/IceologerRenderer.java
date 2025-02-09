package net.norako.arkonia.entity.client.overworld.illagers;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.illagers.IceologerEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class IceologerRenderer extends GeoEntityRenderer<IceologerEntity> {
    public IceologerRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new IceologerModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTextureLocation(IceologerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "textures/entity/illager/iceologer.png");
    }

    @Override
    public void render(IceologerEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.scale(1.0f, 1.0f, 1.0f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
