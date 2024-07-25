package net.norako.arkonia.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;

public class ArkoniaItems {
    // OVERWORLD
    public static final Item RAW_MAGMITITE = registerItem("raw_magmitite", new Item(new FabricItemSettings()));
    public static final Item MAGMITITE_INGOT = registerItem("magmitite_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_XYOPHITE = registerItem("raw_xyophite", new Item(new FabricItemSettings()));
    public static final Item XYOPHITE_INGOT = registerItem("xyophite_ingot", new Item(new FabricItemSettings()));
    public static final Item BELITE_INGOT = registerItem("belite_ingot", new Item(new FabricItemSettings()));
    public static final Item AVIDITE_INGOT = registerItem("avidite_ingot", new Item(new FabricItemSettings()));

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

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Arkonia.MOD_ID, name), item);
    }

    public static void registerArkoniaItems(){
        Arkonia.LOGGER.info("Registering Arkonia Items for " + Arkonia.MOD_ID);
    }
}
