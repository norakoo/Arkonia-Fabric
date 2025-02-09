package net.norako.arkonia.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationStep;
import net.norako.arkonia.world.ArkoniaPlacedFeatures;

public class ArkoniaOreGeneration {
    public static void generateOres() {

        // OVERWORLD

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ArkoniaPlacedFeatures.MAGMITITE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ArkoniaPlacedFeatures.XYOPHITE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ArkoniaPlacedFeatures.BELITE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ArkoniaPlacedFeatures.AVIDITE_ORE_PLACED_KEY);

        // NETHER

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, ArkoniaPlacedFeatures.NETHER_ONYX_ORE_PLACED_KEY);

        // END
    }
}
