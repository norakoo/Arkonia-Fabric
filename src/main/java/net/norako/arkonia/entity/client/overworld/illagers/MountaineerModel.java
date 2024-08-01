package net.norako.arkonia.entity.client.overworld.illagers;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.illagers.MountaineerEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MountaineerModel extends GeoModel<MountaineerEntity> {
    @Override
    public Identifier getModelResource(MountaineerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "geo/mountaineer.geo.json");
    }

    @Override
    public Identifier getTextureResource(MountaineerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "textures/entity/illager/mountaineer.png");
    }

    @Override
    public Identifier getAnimationResource(MountaineerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "animations/mountaineer.animation.json");
    }

    @Override
    public void setCustomAnimations(MountaineerEntity animatable, long instanceId, AnimationState<MountaineerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("bipedHead");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
