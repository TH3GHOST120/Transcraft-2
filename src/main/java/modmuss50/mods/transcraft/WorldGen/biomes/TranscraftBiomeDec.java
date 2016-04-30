package modmuss50.mods.transcraft.WorldGen.biomes;

import modmuss50.mods.transcraft.api.Fluids;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND;

public class TranscraftBiomeDec extends BiomeDecorator {

	/**
	 * The world the BiomeDecorator is currently decorating
	 */
	public World		currentWorld;

	/**
	 * The Biome Decorator's random number generator.
	 */
	public Random		randomGenerator;

	/**
	 * The X-coordinate of the chunk currently being decorated
	 */
	public int			chunk_X;

	/**
	 * The Z-coordinate of the chunk currently being decorated
	 */
	public int			chunk_Z;

	/**
	 * The biome generator object.
	 */
	public BiomeGenBase	biome;

	public int			TransmutterPerChunk;

	public TranscraftBiomeDec(BiomeGenBase par1BiomeGenBase) {
		super();
		TransmutterPerChunk = 0;
		biome = par1BiomeGenBase;
	}

	/**
	 * Decorates the world. Calls code that was formerly (pre-1.8) in
	 * ChunkProviderGenerate.populate
	 */
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		if (currentWorld != null)
			return;
		else {
			currentWorld = par1World;
			randomGenerator = par2Random;
			chunk_X = par3;
			chunk_Z = par4;
			this.decorate();
			currentWorld = null;
			randomGenerator = null;
		}

	}

	/**
	 * The method that does the work of actually decorating chunks
	 */

	protected void decorate() {
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
		// Added
		boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, SAND);

		this.generateOres();

		int var1;
		int var2;
		int var3;
		int var4;
		int var5;

		for (var2 = 0; var2 < TransmutterPerChunk; ++var2) {

			var3 = chunk_X + randomGenerator.nextInt(16) + 8;
			var4 = randomGenerator.nextInt(randomGenerator.nextInt(randomGenerator.nextInt(112) + 8) + 8);
			var5 = chunk_Z + randomGenerator.nextInt(16) + 8;
			(new WorldGenLakes(Fluids.LiquidTransmutter.get())).generate(currentWorld, randomGenerator, var3, var4, var5);

		}

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
	}

}
