package net.norako.arkonia.entity.client.overworld.illagers;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.illagers.WindCallerEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WindCallerRenderer extends GeoEntityRenderer<WindCallerEntity> {
    public WindCallerRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WindCallerModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTextureLocation(WindCallerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "textures/entity/illager/windcaller.png");
    }

    @Override
    public void render(WindCallerEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.scale(1.0f, 1.0f, 1.0f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
