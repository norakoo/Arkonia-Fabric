package net.norako.arkonia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.norako.arkonia.block.ArkoniaBlocks;

import java.util.concurrent.CompletableFuture;

public class ArkoniaBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ArkoniaBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ArkoniaBlocks.DEEPSLATE_MAGMITITE_ORE)
                .add(ArkoniaBlocks.DEEPSLATE_XYOPHITE_ORE)
                .add(ArkoniaBlocks.DEEPSLATE_BELITE_ORE)
                .add(ArkoniaBlocks.DEEPSLATE_AVIDITE_ORE)
                .add(ArkoniaBlocks.NETHER_ONYX_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ArkoniaBlocks.DEEPSLATE_MAGMITITE_ORE)
                .add(ArkoniaBlocks.DEEPSLATE_XYOPHITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ArkoniaBlocks.DEEPSLATE_BELITE_ORE)
                .add(ArkoniaBlocks.DEEPSLATE_AVIDITE_ORE)
                .add(ArkoniaBlocks.NETHER_ONYX_ORE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ArkoniaBlocks.MAPLE_LOG)
                .add(ArkoniaBlocks.MAPLE_WOOD)
                .add(ArkoniaBlocks.STRIPPED_MAPLE_LOG)
                .add(ArkoniaBlocks.STRIPPED_MAPLE_WOOD);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ArkoniaBlocks.MAPLE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ArkoniaBlocks.MAPLE_FENCE_GATE);
    }
}
