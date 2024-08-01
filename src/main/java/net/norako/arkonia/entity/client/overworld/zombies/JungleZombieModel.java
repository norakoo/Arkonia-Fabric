package net.norako.arkonia.entity.client.overworld.zombies;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.zombies.JungleZombieEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class JungleZombieModel extends GeoModel<JungleZombieEntity> {
    @Override
    public Identifier getModelResource(JungleZombieEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "geo/jungle_zombie.geo.json");
    }

    @Override
    public Identifier getTextureResource(JungleZombieEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "textures/entity/zombie/jungle_zombie.png");
    }

    @Override
    public Identifier getAnimationResource(JungleZombieEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "animations/jungle_zombie.animation.json");
    }

    @Override
    public void setCustomAnimations(JungleZombieEntity animatable, long instanceId, AnimationState<JungleZombieEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}