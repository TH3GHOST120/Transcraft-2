package modmuss50.mods.transcraft.WorldGen;

import cpw.mods.fml.common.IWorldGenerator;
import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.Blocks.TranscraftOre;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class TranscraftGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
				break;
		}

	}

	private void generateEnd(World worlde, Random random, int i, int j) {

	}

	private void generateSurface(World world, Random random, int i, int j) {

		for (int k = 0; k < 7; k++) {
			int TranscraftOreXCoord = i + random.nextInt(16);
			int TranscraftOreYCoord = random.nextInt(32);
			int TranscraftOreZCoord = j + random.nextInt(16);

			for (int l = 0; l < TranscraftOre.types.length; l++) {
				new WorldGenMinable(TranscraftBlocks.TranscraftOre, l, 7, Blocks.stone).generate(world, random, TranscraftOreXCoord, TranscraftOreYCoord, TranscraftOreZCoord);
			}

		}
		for (int k = 0; k < 10; k++) {
			int TranscraftOreXCoord = i + random.nextInt(16);
			int TranscraftOreYCoord = random.nextInt(64);
			int TranscraftOreZCoord = j + random.nextInt(16);

			(new WorldGenMinable(TranscraftBlocks.OilOre, 10)).generate(world, random, TranscraftOreXCoord, TranscraftOreYCoord, TranscraftOreZCoord);
		}

	}

	private void generateNether(World world, Random random, int i, int j) {}

}
