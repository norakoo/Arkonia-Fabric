package net.norako.arkonia.mixin;

import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.village.raid.Raid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mixin(Raid.class)
public interface RaidAccessor {

    @Accessor("waveToRaiders")
    Map<Integer, Set<RaiderEntity>> getWaveToRaiders();
}
