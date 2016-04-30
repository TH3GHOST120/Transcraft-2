package modmuss50.mods.transcraft.WorldGen.biomes;

import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.WorldGen.WorldGenCobbleSpike;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

/**
 * Created with IntelliJ IDEA. User: Mark Date: 12/03/14 Time: 17:19
 */
public class MordorBiome extends BiomeGenBase {
	private WorldGenCobbleSpike	cobbleSpike	= new WorldGenCobbleSpike();

	public MordorBiome(int par1) {
		super(par1);
		this.theBiomeDecorator.treesPerChunk = 0;
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.grassPerChunk = 0;
		topBlock = TranscraftBlocks.SinisterBlock;
		fillerBlock = TranscraftBlocks.SinisterBlock;
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		int k;
		int l;
		int i1;

		for (k = 0; k < 3; ++k) {
			l = par3 + par2Random.nextInt(16) + 8;
			i1 = par4 + par2Random.nextInt(16) + 8;
			this.cobbleSpike.generate(par1World, par2Random, l, par1World.getHeightValue(l, i1), i1);
		}
	}
}
