package net.norako.arkonia.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.raid.Raid;
import net.norako.arkonia.entity.ArkoniaEntities;
import net.norako.arkonia.entity.custom.overworld.illager.MountaineerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;

@Mixin(Raid.class)
public class RaidMixin {

    @Shadow @Final private ServerWorld world;

    @Inject(method = "spawnNextWave", at = @At("TAIL"))
    private void injectMountaineerEntity(BlockPos pos, CallbackInfo ci) {
        Raid raid = (Raid) (Object) this;
        int wave = raid.getGroupsSpawned();

        // Accède à la map des raiders par vague
        Map<Integer, Set<RaiderEntity>> waveToRaiders = ((RaidAccessor) raid).getWaveToRaiders();
        Set<RaiderEntity> currentWaveRaiders = waveToRaiders.get(wave);

        if (currentWaveRaiders != null) {
            // Utilisation d'une liste temporaire pour stocker les nouveaux raiders à ajouter
            List<RaiderEntity> newRaiders = new ArrayList<>();

            int mountaineerCount = 0;

            for (RaiderEntity raider : currentWaveRaiders) {
                if (mountaineerCount >= 2) {
                    break;
                }
                if (raider.getType() == EntityType.PILLAGER || raider.getType() == EntityType.VINDICATOR) {
                    MountaineerEntity mountaineer = ArkoniaEntities.MOUNTAINEER.create(this.world);
                    if (mountaineer != null) {
                        BlockPos spawnPos = raider.getBlockPos(); // Spawn près du raider existant
                        mountaineer.refreshPositionAndAngles(spawnPos, 0.0F, 0.0F);
                        newRaiders.add(mountaineer); // Ajoute le mountaineer à la liste temporaire
                        mountaineerCount++;
                    }
                }
            }

            // Ajoute les nouveaux raiders après l'itération
            for (RaiderEntity newRaider : newRaiders) {
                raid.addRaider(wave, newRaider, newRaider.getBlockPos(), false);
            }
        }
    }
}