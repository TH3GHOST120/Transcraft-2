package modmuss50.mods.transcraft.Blocks;

import modmuss50.mods.transcraft.Blocks.TileEntitys.TileEntityTransmutterFlower;
import modmuss50.mods.transcraft.Transcraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

import static net.minecraftforge.common.EnumPlantType.Plains;

public class TransmutterFlower extends BlockBush implements IPlantable, ITileEntityProvider {

	public int	radius	= 5;

	public TransmutterFlower() {
		super(Material.plants);
		setHardness(0F);
		setStepSound(soundTypeGrass);
		setTickRandomly(true);
		setCreativeTab(Transcraft.Transtab);
		setBlockBounds(0.3F, 0.0F, 0.3F, 0.8F, 1, 0.8F);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		// growCropsNearby(world, x, y, z);
		super.updateTick(world, x, y, z, rand);
	}

	public void growCropsNearby(World world, int xO, int yO, int zO) {
		for (int xD = -radius; xD <= radius; xD++) {
			for (int yD = -radius; yD <= radius; yD++) {
				for (int zD = -radius; zD <= radius; zD++) {
					int x = xO + xD;
					int y = yO + yD;
					int z = zO + zD;
					Block block = world.getBlock(x, y, z);

					if (block instanceof IGrowable) {
						block.updateTick(world, x, y, z, world.rand);
						// FXSparkleRun.simple(world, x, y, x);
					}
				}
			}
		}
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {

		return Plains;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityTransmutterFlower();
	}
}
