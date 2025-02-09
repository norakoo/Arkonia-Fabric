package net.norako.arkonia.entity.client.overworld.illagers;

import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.illagers.IceologerEntity;
import software.bernie.geckolib.model.GeoModel;

public class IceologerModel extends GeoModel<IceologerEntity> {
    @Override
    public Identifier getModelResource(IceologerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "geo/iceologer.geo.json");
    }

    @Override
    public Identifier getTextureResource(IceologerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "texture/entity/illager/iceologer.png");
    }

    @Override
    public Identifier getAnimationResource(IceologerEntity animatable) {
        return new Identifier(Arkonia.MOD_ID, "animations/iceologer.animation.json");
    }
}
