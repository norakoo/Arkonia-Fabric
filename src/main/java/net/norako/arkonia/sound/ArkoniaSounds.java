package net.norako.arkonia.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;

public class ArkoniaSounds {

    // OVERWORLD

        // ZOMBIES

    public static final SoundEvent FROZEN_ZOMBIE_AMBIENT = registerSoundEvent("frozen_zombie_ambient");
    public static final SoundEvent FROZEN_ZOMBIE_HURT = registerSoundEvent("frozen_zombie_hurt");
    public static final SoundEvent FROZEN_ZOMBIE_DEATH = registerSoundEvent("frozen_zombie_death");
    public static final SoundEvent JUNGLE_ZOMBIE_AMBIENT = registerSoundEvent("jungle_zombie_ambient");
    public static final SoundEvent JUNGLE_ZOMBIE_HURT = registerSoundEvent("jungle_zombie_hurt");
    public static final SoundEvent JUNGLE_ZOMBIE_DEATH = registerSoundEvent("jungle_zombie_death");

        // ILLAGERS

    public static final SoundEvent MOUNTAINEER_AMBIENT = registerSoundEvent("mountaineer_ambient");
    public static final SoundEvent MOUNTAINEER_HURT = registerSoundEvent("mountaineer_hurt");
    public static final SoundEvent MOUNTAINEER_DEATH = registerSoundEvent("mountaineer_death");
    public static final SoundEvent WINDCALLER_AMBIENT = registerSoundEvent("windcaller_ambient");
    public static final SoundEvent WINDCALLER_HURT = registerSoundEvent("windcaller_hurt");
    public static final SoundEvent WINDCALLER_DEATH = registerSoundEvent("windcaller_death");
    public static final SoundEvent WINDCALLER_POLNAREFF = registerSoundEvent("windcaller_polnareff");
    public static final SoundEvent ICEOLOGER_AMBIENT = registerSoundEvent("iceologer_ambient");
    public static final SoundEvent ICEOLOGER_HURT = registerSoundEvent("iceologer_hurt");
    public static final SoundEvent ICEOLOGER_DEATH = registerSoundEvent("iceologer_death");

    // NETHER

    // END

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(Arkonia.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Arkonia.LOGGER.info("Registering Sounds for " + Arkonia.MOD_ID);
    }
}
