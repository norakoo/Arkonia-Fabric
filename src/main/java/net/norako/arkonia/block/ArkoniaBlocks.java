package net.norako.arkonia.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
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

    public static final Block MAPLE_LOG = registerBlock("maple_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LOG)));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WOOD)));
    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_LOG)));
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_WOOD)));
    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));
    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES).nonOpaque()));

    public static final Identifier MAPLE_SIGN_TEXTURE = new Identifier(Arkonia.MOD_ID, "entity/signs/maple");
    public static final Identifier MAPLE_HANGING_SIGN_TEXTURE = new Identifier(Arkonia.MOD_ID, "entity/signs/hanging/maple");
    public static final Identifier MAPLE_HANGING_GUI_SIGN_TEXTURE = new Identifier(Arkonia.MOD_ID, "textures/gui/hanging_signs/maple");

    public static final Block STANDING_MAPLE_SIGN = Registry.register(Registries.BLOCK, new Identifier(Arkonia.MOD_ID, "maple_standing_sign"),
            new TerraformSignBlock(MAPLE_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.CHERRY_SIGN)));
    public static final Block WALL_MAPLE_SIGN = Registry.register(Registries.BLOCK, new Identifier(Arkonia.MOD_ID, "maple_wall_sign"),
            new TerraformWallSignBlock(MAPLE_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.CHERRY_WALL_SIGN).dropsLike(STANDING_MAPLE_SIGN)));
    public static final Block HANGING_MAPLE_SIGN = Registry.register(Registries.BLOCK, new Identifier(Arkonia.MOD_ID, "maple_hanging_sign"),
            new TerraformHangingSignBlock(MAPLE_HANGING_SIGN_TEXTURE, MAPLE_HANGING_GUI_SIGN_TEXTURE,FabricBlockSettings.copyOf(Blocks.CHERRY_SIGN)));
    public static final Block WALL_HANGING_MAPLE_SIGN = Registry.register(Registries.BLOCK, new Identifier(Arkonia.MOD_ID, "maple_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(MAPLE_HANGING_SIGN_TEXTURE, MAPLE_HANGING_GUI_SIGN_TEXTURE,FabricBlockSettings.copyOf(Blocks.CHERRY_SIGN).dropsLike(HANGING_MAPLE_SIGN)));

    public static final BlockFamily MAPLE_FAMILY = BlockFamilies.register(ArkoniaBlocks.MAPLE_PLANKS)
            .sign(ArkoniaBlocks.STANDING_MAPLE_SIGN, ArkoniaBlocks.WALL_MAPLE_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();
    // NETHER

    // END

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
