package net.norako.arkonia.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;

public class ArkoniaBlocks {
    // OVERWORLD
    public static final Block DEEPSLATE_MAGMITITE_ORE = registerBlock("deepslate_magmitite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block DEEPSLATE_XYOPHITE_ORE = registerBlock("deepslate_xyophite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block DEEPSLATE_BELITE_ORE = registerBlock("deepslate_belite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block DEEPSLATE_AVIDITE_ORE = registerBlock("deepslate_avidite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE)));
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

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Arkonia.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Arkonia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerArkoniaBlocks() {
        Arkonia.LOGGER.info("Registering Arkonia Blocks for " + Arkonia.MOD_ID);
    }
}
