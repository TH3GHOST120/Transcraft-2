package modmuss50.mods.transcraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modmuss50.mods.transcraft.Utils.Config;
import modmuss50.mods.transcraft.WorldGen.biomes.TranscraftBiomes;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class DimWorldProv extends WorldProvider // implements IWorldProvider
{

	@Override
	public void registerWorldChunkManager() {

		this.worldChunkMgr = new WorldChunkManagerHell(TranscraftBiomes.Translands, 0.0F);
		this.dimensionId = Config.DimId;
		// this.hasNoSky = true;
		setDimension(Config.DimId);

	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new DimChunkProvider(this.worldObj, this.worldObj.getSeed(), false);
	}

	@Override
	public String getDimensionName() {
		return "TransMania";
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public double getMovementFactor() {
		return 116.0;
	}

	@Override
	public float calculateCelestialAngle(long par1, float par3) {
		return 1.0F;
	}

	@SideOnly(Side.CLIENT)
	public int getSkyColor() {
		return 0x07D7FF;
	}

	public boolean darkenSkyDuringRain() {
		return false;
	}

	@Override
	public ChunkCoordinates getEntrancePortalLocation() {
		return new ChunkCoordinates(100, 65, 0);
	}

	@Override
	public int getAverageGroundLevel() {
		return 64;
	}

	@Override
	public double getHorizon() {
		return 0.0D;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasVoidParticles(boolean var1) {
		return false;
	}

	@Override
	public boolean canCoordinateBeSpawn(int par1, int par2) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isSkyColored() {
		return true;
	}

	@Override
	public double getVoidFogYFactor() {
		return 1.0D;
	}

	@SideOnly(Side.CLIENT)
	public int getFogColor() {
		return 0x07D7FF;
	}

	@Override
	public void setAllowedSpawnTypes(boolean allowHostile, boolean allowPeaceful) {
		allowPeaceful = true;
	}

	public String getWelcomeMessage() {
		return "Entering Transmina...";
	}

	public String getDepartMessage() {
		return "Leaving Transmina";
	}

}
