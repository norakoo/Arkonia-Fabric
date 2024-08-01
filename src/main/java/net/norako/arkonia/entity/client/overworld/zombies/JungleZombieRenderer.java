package net.norako.arkonia.entity.client.overworld.zombies;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.zombies.JungleZombieEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class JungleZombieRenderer extends GeoEntityRenderer<JungleZombieEntity> {
    public JungleZombieRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new JungleZombieModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTextureLocation(JungleZombieEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "textures/entity/zombie/jungle_zombie.png");
    }

    @Override
    public void render(JungleZombieEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}