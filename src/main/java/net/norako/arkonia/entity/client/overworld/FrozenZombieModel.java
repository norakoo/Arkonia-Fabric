package net.norako.arkonia.entity.client.overworld;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.FrozenZombieEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FrozenZombieModel extends GeoModel<FrozenZombieEntity> {
    @Override
    public Identifier getModelResource(FrozenZombieEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "geo/frozen_zombie.geo.json");
    }

    @Override
    public Identifier getTextureResource(FrozenZombieEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "textures/entity/frozen_zombie.png");
    }

    @Override
    public Identifier getAnimationResource(FrozenZombieEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "animations/frozen_zombie.animation.json");
    }

    @Override
    public void setCustomAnimations(FrozenZombieEntity animatable, long instanceId, AnimationState<FrozenZombieEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
