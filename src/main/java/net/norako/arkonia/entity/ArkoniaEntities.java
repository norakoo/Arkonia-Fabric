package net.norako.arkonia.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.entity.custom.overworld.illagers.IceologerEntity;
import net.norako.arkonia.entity.custom.overworld.illagers.WindCallerEntity;
import net.norako.arkonia.entity.custom.overworld.zombies.FrozenZombieEntity;
import net.norako.arkonia.entity.custom.overworld.illagers.MountaineerEntity;
import net.norako.arkonia.entity.custom.overworld.zombies.JungleZombieEntity;

public class ArkoniaEntities {
    public static final EntityType<FrozenZombieEntity> FROZEN_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Arkonia.MOD_ID, "frozen_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrozenZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.9f)).build());
    public static final EntityType<MountaineerEntity> MOUNTAINEER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Arkonia.MOD_ID, "mountaineer"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MountaineerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.9f)).build());
    public static final EntityType<WindCallerEntity> WINDCALLER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Arkonia.MOD_ID, "windcaller"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WindCallerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.9f)).build());
    public static final EntityType<JungleZombieEntity> JUNGLE_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Arkonia.MOD_ID, "jungle_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, JungleZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.9f)).build());
    public static final EntityType<IceologerEntity> ICEOLOGER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Arkonia.MOD_ID, "iceologer"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IceologerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.9f)).build());

    public static void registerArkoniaEntities() {
        Arkonia.LOGGER.info("Registering Arkonia Entities for " + Arkonia.MOD_ID);
    }
}
