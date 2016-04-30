package modmuss50.mods.transcraft.world;

import modmuss50.mods.transcraft.Blocks.TileEntitys.TileEntityPortal;
import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.Utils.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DimTeleporter extends Teleporter {
	private final WorldServer	worldserver;
	private final Random		seed;
	private final LongHashMap	field_85191_c	= new LongHashMap();

	private final List			field_85190_d	= new ArrayList();

	public DimTeleporter(WorldServer par1WorldServer) {
		super(par1WorldServer);
		this.worldserver = par1WorldServer;
		this.seed = new Random(par1WorldServer.getSeed());
	}

	public void placeInPortal(Entity entity, double x, double y, double z, float r) {
		if (!placeInExistingPortal(entity, x, y, z, r)) {
			if (this.worldserver.provider.dimensionId != Config.DimId) {
				y = this.worldserver.getTopSolidOrLiquidBlock((int) x, (int) z);
				if (entity instanceof EntityPlayerMP) {
					entity.setLocationAndAngles(x, y, z, entity.rotationYaw, 0.0F);
				}
				else {
					entity.setLocationAndAngles(x, y, z, entity.rotationYaw, 0.0F);
				}
			}
			else {
				makePortal(entity);
			}
		}
	}

	public TileEntity findPortalInChunk(double x, double z) {
		Chunk chunk = this.worldserver.getChunkFromBlockCoords((int) x, (int) z);
		Iterator t = chunk.chunkTileEntityMap.values().iterator();

		while (t.hasNext()) {
			Object tile = t.next();

			if ((tile instanceof TileEntityPortal)) {
				return (TileEntity) tile;
			}
		}

		return null;
	}

	public boolean placeInExistingPortal(Entity entity, double x, double y, double z, float r) {
		TileEntity destPortal = null;

		for (int s = 0; (s <= 5) && (destPortal == null); s++) {
			for (int dx = -s; dx <= s; dx++) {
				for (int dz = -s; dz <= s; dz++) {
					if (destPortal == null) {
						destPortal = findPortalInChunk(x + dx * 16, z + dz * 16);
					}
				}
			}
		}

		if (destPortal != null) {
			entity.setLocationAndAngles(destPortal.xCoord + 0.5D, destPortal.yCoord + 1, destPortal.zCoord + 0.5D, entity.rotationYaw, entity.rotationPitch);
			entity.motionX = (entity.motionY = entity.motionZ = 0.0D);
			return true;
		}

		return false;
	}

	public boolean makePortal(Entity entity) {
		int ex = MathHelper.floor_double(entity.posX);
		int ey = MathHelper.floor_double(entity.posY) - 1;
		int ez = MathHelper.floor_double(entity.posZ);

		ey /= 5;
		ey += 60;

		if (ey > 247) {
			ey = 247;
		}

		int size = 5;

		for (int x = -size; x <= size; x++) {
			for (int z = -size; z <= size; z++) {
				for (int y = -2; y <= 4; y++) {
					if ((x == 0) && (y == -1) && (z == 0)) {
						this.worldserver.setBlock(ex + x, ey + y, ez + z, TranscraftBlocks.DriedTransmutter, 1, 2);
						this.worldserver.scheduleBlockUpdate(ex + x, ey + y, ez + z, TranscraftBlocks.DriedTransmutter, 1);
					}
					else
						if ((y == -1)) {
							this.worldserver.setBlock(ex + x, ey + y, ez + z, Blocks.stone);
						}
						else {
							this.worldserver.setBlock(ex + x, ey + y, ez + z, Blocks.air);
						}

				}

			}

		}

		entity.setLocationAndAngles(ex + 0.5D, ey, ez + 0.5D, entity.rotationYaw, 0.0F);
		entity.motionX = (entity.motionY = entity.motionZ = 0.0D);

		return true;
	}

	public void removeStalePortalLocations(long par1) {
		if (par1 % 100L == 0L) {
			Iterator iterator = this.field_85190_d.iterator();
			long j = par1 - 600L;

			while (iterator.hasNext()) {
				Long olong = (Long) iterator.next();
				PortalPosition portalposition = (PortalPosition) this.field_85191_c.getValueByKey(olong.longValue());

				if ((portalposition == null) || (portalposition.lastUpdateTime < j)) {
					iterator.remove();
					this.field_85191_c.remove(olong.longValue());
				}
			}
		}
	}
}
