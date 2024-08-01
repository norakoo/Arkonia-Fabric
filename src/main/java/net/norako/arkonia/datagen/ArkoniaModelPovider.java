package net.norako.arkonia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.norako.arkonia.block.ArkoniaBlocks;
import net.norako.arkonia.item.ArkoniaItems;

public class ArkoniaModelPovider extends FabricModelProvider {
    public ArkoniaModelPovider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // OVERWORLD
        blockStateModelGenerator.registerSimpleCubeAll(ArkoniaBlocks.DEEPSLATE_MAGMITITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ArkoniaBlocks.DEEPSLATE_XYOPHITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ArkoniaBlocks.DEEPSLATE_BELITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ArkoniaBlocks.DEEPSLATE_AVIDITE_ORE);

        blockStateModelGenerator.registerLog(ArkoniaBlocks.MAPLE_LOG).log(ArkoniaBlocks.MAPLE_LOG).wood(ArkoniaBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ArkoniaBlocks.STRIPPED_MAPLE_LOG).log(ArkoniaBlocks.STRIPPED_MAPLE_LOG).wood(ArkoniaBlocks.STRIPPED_MAPLE_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ArkoniaBlocks.MAPLE_LEAVES);

        BlockStateModelGenerator.BlockTexturePool maple_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ArkoniaBlocks.MAPLE_PLANKS);
        maple_pool.family(ArkoniaBlocks.MAPLE_FAMILY);

        blockStateModelGenerator.registerParentedItemModel(ArkoniaItems.FROZEN_ZOMBIE_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ArkoniaItems.MOUNTAINEER_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        // NETHER

        // END

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // OVERWORLD
        itemModelGenerator.register(ArkoniaItems.RAW_MAGMITITE, Models.GENERATED);
        itemModelGenerator.register(ArkoniaItems.MAGMITITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ArkoniaItems.RAW_XYOPHITE, Models.GENERATED);
        itemModelGenerator.register(ArkoniaItems.XYOPHITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ArkoniaItems.BELITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ArkoniaItems.AVIDITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ArkoniaItems.HANGING_MAPLE_SIGN, Models.GENERATED);
        // NETHER

        // END

    }
}
