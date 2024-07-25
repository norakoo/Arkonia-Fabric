package net.norako.arkonia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
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

        // NETHER

        // END

        // ARKONIA

        // BIRUNIA

        // ICEOLIA

        // IRIDIA

        // LUMINIA

        // STELLARIA

        // VELIA

        // ZYPHIA

        // XYLOGIA
    }
}
