package net.norako.arkonia.world;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.block.ArkoniaBlocks;

import java.util.List;

public class ArkoniaConfiguredFeatures {

    // OVERWORLD

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAGMITITE_ORE_KEY = registerKey("magmitite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> XYOPHITE_ORE_KEY = registerKey("xyophite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BELITE_ORE_KEY = registerKey("belite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AVIDITE_ORE_KEY = registerKey("avidite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_ONYX_ORE_KEY = registerKey("nether_onyx_ore_key");

    // NETHER

    // END

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        // OVERWORLD

        List<OreFeatureConfig.Target> overworldMagmititeOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplacables, ArkoniaBlocks.DEEPSLATE_MAGMITITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldXyophiteOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplacables, ArkoniaBlocks.DEEPSLATE_XYOPHITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldBeliteOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplacables, ArkoniaBlocks.DEEPSLATE_BELITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldAviditeOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplacables, ArkoniaBlocks.DEEPSLATE_AVIDITE_ORE.getDefaultState()));

        // NETHER

        List<OreFeatureConfig.Target> netherNetherOnyxOre =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ArkoniaBlocks.NETHER_ONYX_ORE.getDefaultState()));

        // END

        register(context, MAGMITITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldMagmititeOres, 8));
        register(context, XYOPHITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldXyophiteOres, 8));
        register(context, BELITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldBeliteOres, 6));
        register(context, AVIDITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldAviditeOres, 6));
        register(context, NETHER_ONYX_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherNetherOnyxOre, 10));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Arkonia.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
