package net.norako.arkonia.entity.client.overworld.illagers;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.illagers.WindCallerEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WindCallerModel extends GeoModel<WindCallerEntity> {
    @Override
    public Identifier getModelResource(WindCallerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "geo/windcaller.geo.json");
    }

    @Override
    public Identifier getTextureResource(WindCallerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "textures/entity/illager/windcaller.png");
    }

    @Override
    public Identifier getAnimationResource(WindCallerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "animations/windcaller.animation.json");
    }

    @Override
    public void setCustomAnimations(WindCallerEntity animatable, long instanceId, AnimationState<WindCallerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("bipedHead");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
