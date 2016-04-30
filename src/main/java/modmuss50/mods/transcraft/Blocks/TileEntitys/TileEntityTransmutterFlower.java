package modmuss50.mods.transcraft.Blocks.TileEntitys;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class TileEntityTransmutterFlower extends TileEntity {

	public int	radius	= 5;
	public int	ticks	= 0;

	@Override
	public void updateEntity() {

		super.updateEntity();

		if (ticks == 20) {
			growCropsNearby(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			ticks = 0;
		}
		else {
			ticks += 1;
		}

	}

	public void growCropsNearby(World world, int xO, int yO, int zO) {
		for (int xD = -radius; xD <= radius; xD++) {
			for (int yD = -radius; yD <= radius; yD++) {
				for (int zD = -radius; zD <= radius; zD++) {
					int x = xO + xD;
					int y = yO + yD;
					int z = zO + zD;
					Block block = world.getBlock(x, y, z);

					if (block instanceof IPlantable) {
						if (world.getTileEntity(x, y, z) instanceof TileEntityTransmutterFlower) {}
						else {
							block.updateTick(world, x, y, z, world.rand);
						}

					}
				}
			}
		}
	}

}
