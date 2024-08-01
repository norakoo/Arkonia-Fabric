package net.norako.arkonia.entity.client.overworld.illagers;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.illagers.MountaineerEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MountaineerRenderer extends GeoEntityRenderer<MountaineerEntity> {
    public MountaineerRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MountaineerModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTextureLocation(MountaineerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "textures/entity/illager/mountaineer.png");
    }

    @Override
    public void render(MountaineerEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.scale(1.0f, 1.0f, 1.0f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
