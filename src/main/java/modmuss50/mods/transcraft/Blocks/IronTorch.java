package modmuss50.mods.transcraft.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockTorch;
import net.minecraft.world.World;

import java.util.Random;

public class IronTorch extends BlockTorch {
	public IronTorch() {
		super();
		this.setTickRandomly(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		int l = par1World.getBlockMetadata(par2, par3, par4);
		double d0 = par2 + 0.5F;
		double d1 = par3 + 0.7F;
		double d2 = par4 + 0.5F;
		double d3 = 0.2199999988079071D;
		double d4 = 0.27000001072883606D;

		if (l == 1) {
			par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			// par1World.spawnParticle("enchantmenttable", d0 - d4, d1 + d3, d2,
			// 0.0D, 0.0D, 0.0D);
		}
		else
			if (l == 2) {
				par1World.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				// par1World.spawnParticle("enchantmenttable", d0 + d4, d1 + d3,
				// d2,
				// 0.0D, 0.0D, 0.0D);
			}
			else
				if (l == 3) {
					par1World.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
					// par1World.spawnParticle("enchantmenttable", d0, d1 + d3,
					// d2 - d4,
					// 0.0D, 0.0D, 0.0D);
				}
				else
					if (l == 4) {
						par1World.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
						// par1World.spawnParticle("enchantmenttable", d0, d1 +
						// d3, d2 + d4,
						// 0.0D, 0.0D, 0.0D);
					}
					else {
						par1World.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						// par1World.spawnParticle("enchantmenttable", d0, d1,
						// d2, 0.0D,
						// 0.0D, 0.0D);
					}
	}

}
