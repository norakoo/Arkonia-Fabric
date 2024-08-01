package net.norako.arkonia.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.block.ArkoniaBlocks;
import net.norako.arkonia.entity.ArkoniaEntities;

public class ArkoniaItems {
    // OVERWORLD
    public static final Item RAW_MAGMITITE = registerItem("raw_magmitite", new Item(new FabricItemSettings()));
    public static final Item MAGMITITE_INGOT = registerItem("magmitite_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_XYOPHITE = registerItem("raw_xyophite", new Item(new FabricItemSettings()));
    public static final Item XYOPHITE_INGOT = registerItem("xyophite_ingot", new Item(new FabricItemSettings()));
    public static final Item BELITE_INGOT = registerItem("belite_ingot", new Item(new FabricItemSettings()));
    public static final Item AVIDITE_INGOT = registerItem("avidite_ingot", new Item(new FabricItemSettings()));

    public static final Item MAPLE_SIGN = registerItem("maple_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ArkoniaBlocks.STANDING_MAPLE_SIGN, ArkoniaBlocks.WALL_MAPLE_SIGN));
    public static final Item HANGING_MAPLE_SIGN = registerItem("maple_hanging_sign",
            new HangingSignItem(ArkoniaBlocks.HANGING_MAPLE_SIGN, ArkoniaBlocks.WALL_HANGING_MAPLE_SIGN, new FabricItemSettings().maxCount(16)));

    public static final Item FROZEN_ZOMBIE_SPAWN_EGG = registerItem("frozen_zombie_spawn_egg",
            new SpawnEggItem(ArkoniaEntities.FROZEN_ZOMBIE, 0xD9F2F2, 0x799C65,
                    new FabricItemSettings()));
    public static final Item JUNGLE_ZOMBIE_SPAWN_EGG = registerItem("jungle_zombie_spawn_egg",
            new SpawnEggItem(ArkoniaEntities.JUNGLE_ZOMBIE, 0x97C284, 0x799C65,
                    new FabricItemSettings()));
    public static final Item MOUNTAINEER_SPAWN_EGG = registerItem("mountaineer_spawn_egg",
            new SpawnEggItem(ArkoniaEntities.MOUNTAINEER, 0xE8EDF1, 0x959B9B,
                    new FabricItemSettings()));
    // NETHER

    // END

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Arkonia.MOD_ID, name), item);
    }

    public static void registerArkoniaItems(){
        Arkonia.LOGGER.info("Registering Arkonia Items for " + Arkonia.MOD_ID);
    }
}
