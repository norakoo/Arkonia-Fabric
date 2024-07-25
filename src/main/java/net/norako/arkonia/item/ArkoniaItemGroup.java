package net.norako.arkonia.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.norako.arkonia.Arkonia;

public class ArkoniaItemGroup {
    public static final ItemGroup ARKONIA_VANILLA = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Arkonia.MOD_ID, "arkonia_vanilla"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.arkonia_vanilla"))
                    .icon(() -> new ItemStack(ArkoniaItems.RAW_MAGMITITE)).entries((displayContext, entries) -> {
                        entries.add(ArkoniaItems.RAW_MAGMITITE);
                        entries.add(ArkoniaItems.MAGMITITE_INGOT);
                        entries.add(ArkoniaItems.RAW_XYOPHITE);
                        entries.add(ArkoniaItems.XYOPHITE_INGOT);
                        entries.add(ArkoniaItems.BELITE_INGOT);
                        entries.add(ArkoniaItems.AVIDITE_INGOT);
                    }).build());

    public static void registerItemGroups() {
        Arkonia.LOGGER.info("Registering Item Groups for " + Arkonia.MOD_ID);
    }
}
