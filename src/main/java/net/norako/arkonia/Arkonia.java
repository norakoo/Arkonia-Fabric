package net.norako.arkonia;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.norako.arkonia.block.ArkoniaBlocks;
import net.norako.arkonia.entity.ArkoniaEntities;
import net.norako.arkonia.entity.client.overworld.FrozenZombieRenderer;
import net.norako.arkonia.entity.client.overworld.illager.MountaineerRenderer;
import net.norako.arkonia.entity.custom.overworld.FrozenZombieEntity;
import net.norako.arkonia.entity.custom.overworld.illager.MountaineerEntity;
import net.norako.arkonia.item.ArkoniaItemGroup;
import net.norako.arkonia.item.ArkoniaItems;
import net.norako.arkonia.sound.ArkoniaSounds;
import net.norako.arkonia.world.gen.ArkoniaWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class Arkonia implements ModInitializer {
	public static final String MOD_ID = "arkonia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ArkoniaBlocks.registerArkoniaBlocks();
		ArkoniaItemGroup.registerItemGroups();
		ArkoniaItems.registerArkoniaItems();
		ArkoniaWorldGeneration.generateArkoniaWorldGen();
		ArkoniaEntities.registerArkoniaEntities();
		ArkoniaSounds.registerSounds();

		GeckoLib.initialize();

		StrippableBlockRegistry.register(ArkoniaBlocks.MAPLE_LOG, ArkoniaBlocks.STRIPPED_MAPLE_LOG);
		StrippableBlockRegistry.register(ArkoniaBlocks.MAPLE_WOOD, ArkoniaBlocks.STRIPPED_MAPLE_WOOD);

		FabricDefaultAttributeRegistry.register(ArkoniaEntities.FROZEN_ZOMBIE, FrozenZombieEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ArkoniaEntities.MOUNTAINEER, MountaineerEntity.setAttributes());

		EntityRendererRegistry.register(ArkoniaEntities.FROZEN_ZOMBIE, FrozenZombieRenderer::new);
		EntityRendererRegistry.register(ArkoniaEntities.MOUNTAINEER, MountaineerRenderer::new);

		FlammableBlockRegistry.getDefaultInstance().add(ArkoniaBlocks.MAPLE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ArkoniaBlocks.MAPLE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ArkoniaBlocks.STRIPPED_MAPLE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ArkoniaBlocks.STRIPPED_MAPLE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ArkoniaBlocks.MAPLE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ArkoniaBlocks.MAPLE_LEAVES, 30, 60);
	}
}