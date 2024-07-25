package net.norako.arkonia;

import net.fabricmc.api.ModInitializer;

import net.norako.arkonia.item.ArkoniaItemGroup;
import net.norako.arkonia.item.ArkoniaItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Arkonia implements ModInitializer {
	public static final String MOD_ID = "arkonia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ArkoniaItemGroup.registerItemGroups();
		ArkoniaItems.registerModItems();
	}
}