package net.norako.arkonia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.norako.arkonia.block.ArkoniaBlocks;
import net.norako.arkonia.item.ArkoniaItems;

import java.util.List;
import java.util.function.Consumer;

public class ArkoniaRecipeProvider extends FabricRecipeProvider {
    // OVERWORLD
    private static final List<ItemConvertible> MAGMITITE_SMELTABLE = List.of(ArkoniaItems.RAW_MAGMITITE,
            ArkoniaBlocks.DEEPSLATE_MAGMITITE_ORE);
    private static final List<ItemConvertible> XYOPHITE_SMELTABLE = List.of(ArkoniaItems.RAW_XYOPHITE,
            ArkoniaBlocks.DEEPSLATE_XYOPHITE_ORE);
    private static final List<ItemConvertible> BELITE_SMELTABLE = List.of(ArkoniaBlocks.DEEPSLATE_BELITE_ORE);
    private static final List<ItemConvertible> AVIDITE_SMELTABLE = List.of(ArkoniaBlocks.DEEPSLATE_AVIDITE_ORE);

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

    public ArkoniaRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // OVERWORLD
        offerSmelting(exporter, MAGMITITE_SMELTABLE, RecipeCategory.MISC, ArkoniaItems.MAGMITITE_INGOT,
                0.7f, 200, "magmitite_ingot");
        offerBlasting(exporter, MAGMITITE_SMELTABLE, RecipeCategory.MISC, ArkoniaItems.MAGMITITE_INGOT,
                0.7f, 100, "magmitite_ingot");
        offerSmelting(exporter, XYOPHITE_SMELTABLE, RecipeCategory.MISC, ArkoniaItems.XYOPHITE_INGOT,
                0.7f, 200, "xyophite_ingot");
        offerBlasting(exporter, XYOPHITE_SMELTABLE, RecipeCategory.MISC, ArkoniaItems.XYOPHITE_INGOT,
                0.7f, 100, "xyophite_ingot");
        offerSmelting(exporter, BELITE_SMELTABLE, RecipeCategory.MISC, ArkoniaItems.BELITE_INGOT,
                0.7f, 200, "belite_ingot");
        offerBlasting(exporter, BELITE_SMELTABLE, RecipeCategory.MISC, ArkoniaItems.BELITE_INGOT,
                0.7f, 100, "belite_ingot");
        offerSmelting(exporter, AVIDITE_SMELTABLE, RecipeCategory.MISC, ArkoniaItems.AVIDITE_INGOT,
                0.7f, 200, "avidite_ingot");
        offerBlasting(exporter, AVIDITE_SMELTABLE, RecipeCategory.MISC, ArkoniaItems.AVIDITE_INGOT,
                0.7f, 100, "avidite_ingot");

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
