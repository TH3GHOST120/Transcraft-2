package modmuss50.mods.transcraft.WorldGen.biomes;

import modmuss50.mods.transcraft.Utils.Config;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;


public class TranscraftBiomes {

	protected static final BiomeGenBase.Height	plateau					= new BiomeGenBase.Height(5.0F, 0.015F);

	protected static final BiomeGenBase.Height	mordor					= new BiomeGenBase.Height(0.1F, 0.100F);

	protected static final BiomeGenBase.Height	translandsHeight		= new BiomeGenBase.Height(0.8F, 1.5F);

	protected static final BiomeGenBase.Height	FlattranslandsHeight	= new BiomeGenBase.Height(1F, 0.4F);

	public static final BiomeGenBase			TransmutterBiome		= (new TransmutterBiome(Config.stoneBiomeID)).setBiomeName("StoneBiome").setTemperatureRainfall(0.8F, 0.4F);

	public static final BiomeGenBase			plateauBiome			= (new plateauBiome(Config.plateauBiomeID)).setBiomeName("Plateau").setTemperatureRainfall(0.8F, 0.4F).setHeight(plateau);

	public static final BiomeGenBase			mordorBiome				= (new MordorBiome(Config.mordorBiomeID)).setBiomeName("Mordor").setTemperatureRainfall(0.8F, 0.4F).setHeight(mordor);

	public static final BiomeGenBase			Translands				= (new TranslandsBiome(Config.mordorBiomeID)).setBiomeName("Translands").setTemperatureRainfall(0.8F, 0.0F).setHeight(FlattranslandsHeight);

	public static void loadBiomes() {
        BiomeDictionary.registerBiomeType(TranscraftBiomes.TransmutterBiome, BiomeDictionary.Type.SPOOKY);
		// BiomeManager.addSpawnBiome(TranscraftBiomes.TransmutterBiome);
		BiomeManager.addStrongholdBiome(TranscraftBiomes.TransmutterBiome);
		BiomeManager.addVillageBiome(TranscraftBiomes.TransmutterBiome, true);
		BiomeDictionary.registerBiomeType(TranscraftBiomes.TransmutterBiome, BiomeDictionary.Type.PLAINS);

        BiomeDictionary.registerBiomeType(TranscraftBiomes.plateauBiome, BiomeDictionary.Type.HILLS);
		// BiomeManager.addSpawnBiome(TranscraftBiomes.plateauBiome);
		BiomeManager.addStrongholdBiome(TranscraftBiomes.plateauBiome);
		BiomeManager.addVillageBiome(TranscraftBiomes.plateauBiome, true);
		BiomeDictionary.registerBiomeType(TranscraftBiomes.plateauBiome, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);

        BiomeDictionary.registerBiomeType(TranscraftBiomes.mordorBiome, BiomeDictionary.Type.SPOOKY);
		// BiomeManager.addSpawnBiome(TranscraftBiomes.mordorBiome);
		BiomeManager.addStrongholdBiome(TranscraftBiomes.mordorBiome);
		BiomeDictionary.registerBiomeType(TranscraftBiomes.mordorBiome, BiomeDictionary.Type.PLAINS);

		// BiomeDictionary.registerBiomeType(Translands, new
		// BiomeDictionary.Type[] { BiomeDictionary.Type.MAGICAL });

	}

	public static int findUnusedBiomeID() {
		int freeBiomeID = 0;
		// code to find a free biome
		for (int i = 1; i < 256; i++) {
			if (BiomeGenBase.getBiomeGenArray()[i] == null) {
				freeBiomeID = i;
				return freeBiomeID;
			}
		}
		// failed to find any free biome IDs
		class BiomeIdLimitException extends RuntimeException {
			public BiomeIdLimitException() {
				super(String.format("You have a run out of free Biome Ids!"));
			}
		}

		throw new BiomeIdLimitException();
	}

}
