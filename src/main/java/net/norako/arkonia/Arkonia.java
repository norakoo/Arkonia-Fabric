package net.norako.arkonia;

import net.fabricmc.api.ModInitializer;

import net.norako.arkonia.block.ArkoniaBlocks;
import net.norako.arkonia.item.ArkoniaItemGroup;
import net.norako.arkonia.item.ArkoniaItems;
import net.norako.arkonia.world.gen.ArkoniaOreGeneration;
import net.norako.arkonia.world.gen.ArkoniaWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Arkonia implements ModInitializer {
	public static final String MOD_ID = "arkonia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ArkoniaBlocks.registerArkoniaBlocks();
		ArkoniaItemGroup.registerItemGroups();
		ArkoniaItems.registerArkoniaItems();

		ArkoniaWorldGeneration.generateArkoniaWorldGen();
	}
}