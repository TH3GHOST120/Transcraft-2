package modmuss50.mods.transcraft.Blocks.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

import java.util.Random;

public class BlockFluidLiquidTransmuter extends BlockFluidClassic {

	public static IIcon	StillIcon;
	public static IIcon	FlowingIcon;

	public BlockFluidLiquidTransmuter(String fluidName) {
		super(new LiquidTransmutterFluid("LiquidTransmutterFluid"), Material.water);

	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		StillIcon = iconRegister.registerIcon("transcraft:transmutter_liquid_still");
		FlowingIcon = iconRegister.registerIcon("transcraft:transmutter_liquid_flowing");
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return side != 0 && side != 1 ? FlowingIcon : StillIcon;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		int meta = world.getBlockMetadata(x, y, z);

		if (!world.isRemote) {
			if (entity instanceof EntityLivingBase) {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 1));
			}

			if (entity instanceof EntityPlayer) {
				if (world.rand.nextInt(150) == 0) {
					EntityPlayer player = (EntityPlayer) entity;

					if (player.getFoodStats().needFood()) {
						((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 1));
					}
				}
			}
		}
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		growCropsNearby(world, x, y, z);

		int quantaRemaining = quantaPerBlock - world.getBlockMetadata(x, y, z);
		int expQuanta = -101;

		// check adjacent block levels if non-source
		if (quantaRemaining < quantaPerBlock) {
			int y2 = y - densityDir;

			if (world.getBlock(x, y2, z) == this || world.getBlock(x - 1, y2, z) == this || world.getBlock(x + 1, y2, z) == this || world.getBlock(x, y2, z - 1) == this || world.getBlock(x, y2, z + 1) == this) {
				expQuanta = quantaPerBlock - 1;
			}
			else {
				int maxQuanta = -100;
				maxQuanta = getLargerQuanta(world, x - 1, y, z, maxQuanta);
				maxQuanta = getLargerQuanta(world, x + 1, y, z, maxQuanta);
				maxQuanta = getLargerQuanta(world, x, y, z - 1, maxQuanta);
				maxQuanta = getLargerQuanta(world, x, y, z + 1, maxQuanta);

				expQuanta = maxQuanta - 1;
			}

			// decay calculation
			if (expQuanta != quantaRemaining) {
				quantaRemaining = expQuanta;

				if (expQuanta <= 0) {
					world.setBlock(x, y, z, Blocks.air);
				}
				else {
					world.setBlockMetadataWithNotify(x, y, z, quantaPerBlock - expQuanta, 3);
					world.scheduleBlockUpdate(x, y, z, this, tickRate);
					world.notifyBlocksOfNeighborChange(x, y, z, this);
				}
			}
		}
		// This is a "source" block, set meta to zero, and send a server only
		// update
		else
			if (quantaRemaining >= quantaPerBlock) {
				world.setBlockMetadataWithNotify(x, y, z, 0, 2);
			}

		// Flow vertically if possible
		if (canDisplace(world, x, y + densityDir, z)) {
			flowIntoBlock(world, x, y + densityDir, z, 1);
			return;
		}

		// Flow outward if possible
		int flowMeta = quantaPerBlock - quantaRemaining + 1;
		if (flowMeta >= quantaPerBlock) {
			return;
		}

		if (isSourceBlock(world, x, y, z) || !isFlowingVertically(world, x, y, z)) {
			if (world.getBlock(x, y - densityDir, z) == this) {
				flowMeta = 1;
			}
			boolean flowTo[] = getOptimalFlowDirections(world, x, y, z);

			if (flowTo[0])
				flowIntoBlock(world, x - 1, y, z, flowMeta);
			if (flowTo[1])
				flowIntoBlock(world, x + 1, y, z, flowMeta);
			if (flowTo[2])
				flowIntoBlock(world, x, y, z - 1, flowMeta);
			if (flowTo[3])
				flowIntoBlock(world, x, y, z + 1, flowMeta);
		}
	}

	public void growCropsNearby(World world, int xO, int yO, int zO) {
		for (int xD = -4; xD <= 4; xD++) {
			for (int yD = -1; yD <= 4; yD++) {
				for (int zD = -4; zD <= 4; zD++) {
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

}
