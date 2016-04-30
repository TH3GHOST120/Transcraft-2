package modmuss50.mods.transcraft.WorldGen.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created with IntelliJ IDEA. User: Mark Date: 12/03/14 Time: 16:58
 */
public class plateauBiome extends BiomeGenBase

{

	public plateauBiome(int par1) {
		super(par1);
		this.theBiomeDecorator.treesPerChunk = 1;
		this.theBiomeDecorator.flowersPerChunk = 40;
		this.theBiomeDecorator.grassPerChunk = 20;
		topBlock = Blocks.grass;
		fillerBlock = Blocks.gravel;
	}
}
