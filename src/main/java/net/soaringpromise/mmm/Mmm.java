package net.soaringpromise.mmm;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import net.soaringpromise.mmm.registry.*;
import net.soaringpromise.mmm.worldgen.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mmm implements ModInitializer {
	public static final String MOD_ID = "modular-metallurgy";
	public static final String MOD_NAME = "Mia's Modular Metallurgy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfigs.init();

		ModItems.register();
		ModBlocks.register();
		ModCreativeTabs.register();

		ModTools.register();

		ModWorldGen.init();

		LOGGER.info("{} successfully initialized.", MOD_NAME);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}