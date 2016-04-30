package modmuss50.mods.transcraft.WorldGen.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class TransmutterBiome extends BiomeGenBase

{
	private TranscraftBiomeDec	customBiomeDecorator;

	public TransmutterBiome(int par1) {
		super(par1);
		theBiomeDecorator = new TranscraftBiomeDec(this);
		customBiomeDecorator = (TranscraftBiomeDec) theBiomeDecorator;
		customBiomeDecorator.TransmutterPerChunk = 15;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = 12;
		this.theBiomeDecorator.grassPerChunk = 10;

		topBlock = Blocks.stone;
		fillerBlock = Blocks.stone;
	}

}
