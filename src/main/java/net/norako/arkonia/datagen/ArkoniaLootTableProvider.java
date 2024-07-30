package net.norako.arkonia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.norako.arkonia.block.ArkoniaBlocks;
import net.norako.arkonia.item.ArkoniaItems;

public class ArkoniaLootTableProvider extends FabricBlockLootTableProvider {
    public ArkoniaLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // OVERWORLD
        addDrop(ArkoniaBlocks.DEEPSLATE_MAGMITITE_ORE, oreDrops(ArkoniaBlocks.DEEPSLATE_MAGMITITE_ORE, ArkoniaItems.RAW_MAGMITITE));
        addDrop(ArkoniaBlocks.DEEPSLATE_XYOPHITE_ORE, oreDrops(ArkoniaBlocks.DEEPSLATE_XYOPHITE_ORE, ArkoniaItems.RAW_XYOPHITE));
        addDrop(ArkoniaBlocks.DEEPSLATE_BELITE_ORE, oreDrops(ArkoniaBlocks.DEEPSLATE_BELITE_ORE, ArkoniaItems.BELITE_INGOT));
        addDrop(ArkoniaBlocks.DEEPSLATE_AVIDITE_ORE, oreDrops(ArkoniaBlocks.DEEPSLATE_AVIDITE_ORE, ArkoniaItems.AVIDITE_INGOT));
        addDrop(ArkoniaBlocks.MAPLE_LOG);
        addDrop(ArkoniaBlocks.MAPLE_PLANKS);
        addDrop(ArkoniaBlocks.MAPLE_WOOD);
        addDrop(ArkoniaBlocks.STRIPPED_MAPLE_LOG);
        addDrop(ArkoniaBlocks.STRIPPED_MAPLE_WOOD);
        addDrop(ArkoniaBlocks.MAPLE_LEAVES, leavesDrops(ArkoniaBlocks.MAPLE_LEAVES, Blocks.MANGROVE_PROPAGULE, 0.0025f)); // TODO Maple Sappling
        // NETHER

        // END

    }
}
