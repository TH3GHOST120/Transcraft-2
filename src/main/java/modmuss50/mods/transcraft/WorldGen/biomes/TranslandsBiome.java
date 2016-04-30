package modmuss50.mods.transcraft.WorldGen.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.biome.BiomeGenBase;

public class TranslandsBiome extends BiomeGenBase {
	public TranslandsBiome(int par1) {
		super(par1);
		this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));
		this.theBiomeDecorator.treesPerChunk = 1;
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.grassPerChunk = 8;
		this.spawnableMonsterList.clear();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return 0x07D7FF;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getBiomeFoliageColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return 0x07D7FF;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float par1) {
		return 0x07D7FF;
	}
}
