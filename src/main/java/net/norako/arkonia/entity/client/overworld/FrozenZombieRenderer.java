package net.norako.arkonia.entity.client.overworld;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.FrozenZombieEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FrozenZombieRenderer extends GeoEntityRenderer<FrozenZombieEntity> {
    public FrozenZombieRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new FrozenZombieModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTextureLocation(FrozenZombieEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "textures/entity/frozen_zombie.png");
    }

    @Override
    public void render(FrozenZombieEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
