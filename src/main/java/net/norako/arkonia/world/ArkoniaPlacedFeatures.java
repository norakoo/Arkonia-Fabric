package net.norako.arkonia.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.norako.arkonia.Arkonia;

import java.util.List;

public class ArkoniaPlacedFeatures {

    // OVERWORLD

    public static final RegistryKey<PlacedFeature> MAGMITITE_ORE_PLACED_KEY = registerKey("magmitite_ore_placed");
    public static final RegistryKey<PlacedFeature> XYOPHITE_ORE_PLACED_KEY = registerKey("xyophite_ore_placed");
    public static final RegistryKey<PlacedFeature> BELITE_ORE_PLACED_KEY = registerKey("belite_ore_placed");
    public static final RegistryKey<PlacedFeature> AVIDITE_ORE_PLACED_KEY = registerKey("avidite_ore_placed");

    // NETHER

    public static final RegistryKey<PlacedFeature> NETHER_ONYX_ORE_PLACED_KEY = registerKey("nether_onyx_ore_placed");

    // END

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, MAGMITITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ArkoniaConfiguredFeatures.MAGMITITE_ORE_KEY),
                ArkoniaOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(40))));
        register(context, XYOPHITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ArkoniaConfiguredFeatures.XYOPHITE_ORE_KEY),
                ArkoniaOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(30))));
        register(context, BELITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ArkoniaConfiguredFeatures.BELITE_ORE_KEY),
                ArkoniaOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(20))));
        register(context, AVIDITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ArkoniaConfiguredFeatures.AVIDITE_ORE_KEY),
                ArkoniaOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(15))));
        register(context, NETHER_ONYX_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ArkoniaConfiguredFeatures.NETHER_ONYX_ORE_KEY),
                ArkoniaOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(100))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Arkonia.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
