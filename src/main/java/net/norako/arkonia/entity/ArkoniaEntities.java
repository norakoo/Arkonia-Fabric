package net.norako.arkonia.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.FrozenZombieEntity;
import net.norako.arkonia.entity.custom.overworld.illager.MountaineerEntity;

public class ArkoniaEntities {
    public static final EntityType<FrozenZombieEntity> FROZEN_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Arkonia.MOD_ID, "frozen_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrozenZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 2.0f)).build());
    public static final EntityType<MountaineerEntity> MOUNTAINEER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Arkonia.MOD_ID, "mountaineer"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MountaineerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.9f)).build());

    public static void registerArkoniaEntities() {
        Arkonia.LOGGER.info("Registering Arkonia Entities for " + Arkonia.MOD_ID);
    }
}
