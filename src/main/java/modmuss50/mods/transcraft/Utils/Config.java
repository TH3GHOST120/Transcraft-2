package modmuss50.mods.transcraft.Utils;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.io.IOException;

public class Config {

	public static boolean		WorldGen			= true;

	public static boolean		enderswordpearl;
	public static boolean		EnderArmorBuffs;
	public static boolean		showAllBlocks;
	public static boolean		updateChecker;

	public static int			stoneBiomeID		= 190;
	public static int			plateauBiomeID		= 191;
	public static int			mordorBiomeID		= 192;

	public static int			BasicItemEssence	= 1024;
	public static int			QuadItemEssence		= 5512;
	public static int			NanoItemEssence		= 25256;

	public static int			DimId				= 25;
	public static Configuration	config;

	public static void init(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
	}

	// config.load();

	public static void initConfig() {

		// File fileDir = new File(proxy.getMinecraftDir() +
		// "/Transcraft/config/");
		// fileDir.mkdir();
		File cfgFile = new File(modmuss50.mods.transcraft.TranscraftCommonProxy.getMinecraftDir() + "/config/Transcraft.cfg");

		try {
			cfgFile.createNewFile();
		}
		catch (IOException e) {
			System.out.println(e);
		}

		config = new Configuration(cfgFile);
		config.load();

		enderswordpearl = config.get("Settings", "Endersword ender pearl right click", true).getBoolean(true);
		EnderArmorBuffs = config.get("Settings", "Ender Armor Buffs", true).getBoolean(true);

		showAllBlocks = config.get("Settings", "Show all coloured blocks in the creative tab", true).getBoolean(true);

		updateChecker = config.get("Settings", "Runs the update checker on login", true).getBoolean(true);

		BasicItemEssence = config.get("Item Essence Value", "Basic Transmutter", 1024).getInt(1024);
		QuadItemEssence = config.get("Item Essence Value", "Quad Transmutter", 5512).getInt(5512);
		NanoItemEssence = config.get("Item Essence Value", "Nano Transmutter", 25256).getInt(25256);

		stoneBiomeID = config.get("Biomes", "Stone Biome id", 190).getInt(190);

		plateauBiomeID = config.get("Biomes", "Plateau Biome id", 191).getInt(191);

		mordorBiomeID = config.get("Biomes", "Mordor Biome id", 192).getInt(192);

		DimId = config.get("Dimension ids", "Transmaina", 25).getInt(25);

		config.save();
	}

	public static Configuration getConfig() {
		return config;
	}
}
