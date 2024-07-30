package net.norako.arkonia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.norako.arkonia.block.ArkoniaBlocks;

import java.util.concurrent.CompletableFuture;

public class ArkoniaItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ArkoniaItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ArkoniaBlocks.MAPLE_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ArkoniaBlocks.MAPLE_LOG.asItem())
                .add(ArkoniaBlocks.MAPLE_WOOD.asItem())
                .add(ArkoniaBlocks.STRIPPED_MAPLE_LOG.asItem())
                .add(ArkoniaBlocks.STRIPPED_MAPLE_WOOD.asItem());
    }
}
