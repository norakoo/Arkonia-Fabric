package net.norako.arkonia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
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

        addDrop(ArkoniaBlocks.MAPLE_STAIRS);
        addDrop(ArkoniaBlocks.MAPLE_TRAPDOOR);
        addDrop(ArkoniaBlocks.MAPLE_BUTTON);
        addDrop(ArkoniaBlocks.MAPLE_PRESSURE_PLATE);
        addDrop(ArkoniaBlocks.MAPLE_FENCE);
        addDrop(ArkoniaBlocks.MAPLE_FENCE_GATE);

        addDrop(ArkoniaBlocks.MAPLE_DOOR, doorDrops(ArkoniaBlocks.MAPLE_DOOR));
        addDrop(ArkoniaBlocks.MAPLE_SLABS, slabDrops(ArkoniaBlocks.MAPLE_SLABS));

        // NETHER

        addDrop(ArkoniaBlocks.NETHER_ONYX_ORE, oreDrops(ArkoniaBlocks.NETHER_ONYX_ORE, Items.FEATHER));

        // END

    }
}
