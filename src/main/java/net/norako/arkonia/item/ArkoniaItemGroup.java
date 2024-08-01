package net.norako.arkonia.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;
import net.norako.arkonia.block.ArkoniaBlocks;

public class ArkoniaItemGroup {
    public static final ItemGroup ARKONIA_VANILLA = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Arkonia.MOD_ID, "arkonia_vanilla"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.arkonia_vanilla"))
                    .icon(() -> new ItemStack(ArkoniaItems.RAW_MAGMITITE)).entries((displayContext, entries) -> {
                        entries.add(ArkoniaBlocks.MAPLE_LOG);
                        entries.add(ArkoniaBlocks.MAPLE_WOOD);
                        entries.add(ArkoniaBlocks.STRIPPED_MAPLE_LOG);
                        entries.add(ArkoniaBlocks.STRIPPED_MAPLE_WOOD);
                        entries.add(ArkoniaBlocks.MAPLE_PLANKS);
                        entries.add(ArkoniaBlocks.MAPLE_LEAVES);
                        entries.add(ArkoniaItems.MAPLE_SIGN);
                        entries.add(ArkoniaItems.HANGING_MAPLE_SIGN);

                        entries.add(ArkoniaBlocks.DEEPSLATE_MAGMITITE_ORE);
                        entries.add(ArkoniaItems.RAW_MAGMITITE);
                        entries.add(ArkoniaItems.MAGMITITE_INGOT);
                        entries.add(ArkoniaBlocks.DEEPSLATE_XYOPHITE_ORE);
                        entries.add(ArkoniaItems.RAW_XYOPHITE);
                        entries.add(ArkoniaItems.XYOPHITE_INGOT);
                        entries.add(ArkoniaBlocks.DEEPSLATE_BELITE_ORE);
                        entries.add(ArkoniaItems.BELITE_INGOT);
                        entries.add(ArkoniaBlocks.DEEPSLATE_AVIDITE_ORE);
                        entries.add(ArkoniaItems.AVIDITE_INGOT);

                        entries.add(ArkoniaItems.FROZEN_ZOMBIE_SPAWN_EGG);
                        entries.add(ArkoniaItems.MOUNTAINEER_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {
        Arkonia.LOGGER.info("Registering Item Groups for " + Arkonia.MOD_ID);
    }
}
