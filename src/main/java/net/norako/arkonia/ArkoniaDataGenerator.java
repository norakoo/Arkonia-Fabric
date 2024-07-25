package net.norako.arkonia;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.norako.arkonia.datagen.*;
import net.norako.arkonia.world.ArkoniaConfiguredFeatures;
import net.norako.arkonia.world.ArkoniaPlacedFeatures;

public class ArkoniaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ArkoniaBlockTagProvider::new);
		pack.addProvider(ArkoniaItemTagProvider::new);
		pack.addProvider(ArkoniaLootTableProvider::new);
		pack.addProvider(ArkoniaModelPovider::new);
		pack.addProvider(ArkoniaRecipeProvider::new);
		pack.addProvider(ArkoniaWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ArkoniaConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ArkoniaPlacedFeatures::bootstrap);
	}
}
