package modmuss50.mods.transcraft.Blocks.TileEntitys.MagicalInfuser;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class MultiBlockHelper {

	public static boolean isMultiBlockStructure(World world, int xO, int yO, int zO, int w, int d, int h, Block block) {

		boolean hasfoundnonemultiblock = false;
		for (int xD = 0; xD <= w; xD++) {
			for (int yD = 0; yD <= d; yD++) {
				for (int zD = 0; zD <= h; zD++) {
					int x = xO + xD;
					int y = yO + yD;
					int z = zO + zD;
					Block block2 = world.getBlock(x, y, z);

					if (block2 != block) {
						hasfoundnonemultiblock = false;
					}
				}
			}
		}
		if (hasfoundnonemultiblock = true) {
			return true;
		}

		hasfoundnonemultiblock = false;
		for (int xD = 0; xD <= w; xD--) {
			for (int yD = 0; yD <= d; yD--) {
				for (int zD = 0; zD <= h; zD--) {
					int x = xO + xD;
					int y = yO + yD;
					int z = zO + zD;
					Block block2 = world.getBlock(x, y, z);

					if (block2 != block) {
						hasfoundnonemultiblock = false;
					}
				}
			}
		}
		if (hasfoundnonemultiblock = true) {
			return true;
		}

		hasfoundnonemultiblock = false;
		for (int xD = 0; xD <= w; xD++) {
			for (int yD = 0; yD <= d; yD--) {
				for (int zD = 0; zD <= h; zD--) {
					int x = xO + xD;
					int y = yO + yD;
					int z = zO + zD;
					Block block2 = world.getBlock(x, y, z);

					if (block2 != block) {
						hasfoundnonemultiblock = false;
					}
				}
			}
		}
		if (hasfoundnonemultiblock = true) {
			return true;
		}

		hasfoundnonemultiblock = false;
		for (int xD = 0; xD <= w; xD++) {
			for (int yD = 0; yD <= d; yD++) {
				for (int zD = 0; zD <= h; zD--) {
					int x = xO + xD;
					int y = yO + yD;
					int z = zO + zD;
					Block block2 = world.getBlock(x, y, z);

					if (block2 != block) {
						hasfoundnonemultiblock = false;
					}
				}
			}
		}
		if (hasfoundnonemultiblock = true) {
			return true;
		}

		hasfoundnonemultiblock = false;
		for (int xD = 0; xD <= w; xD++) {
			for (int yD = 0; yD <= d; yD--) {
				for (int zD = 0; zD <= h; zD++) {
					int x = xO + xD;
					int y = yO + yD;
					int z = zO + zD;
					Block block2 = world.getBlock(x, y, z);

					if (block2 != block) {
						hasfoundnonemultiblock = false;
					}
				}
			}
		}
		if (hasfoundnonemultiblock = true) {
			return true;
		}

		hasfoundnonemultiblock = false;
		for (int xD = 0; xD <= w; xD--) {
			for (int yD = 0; yD <= d; yD--) {
				for (int zD = 0; zD <= h; zD++) {
					int x = xO + xD;
					int y = yO + yD;
					int z = zO + zD;
					Block block2 = world.getBlock(x, y, z);

					if (block2 != block) {
						hasfoundnonemultiblock = false;
					}
				}
			}
		}
		if (hasfoundnonemultiblock = true) {
			return true;
		}

		hasfoundnonemultiblock = false;
		for (int xD = 0; xD <= w; xD--) {
			for (int yD = 0; yD <= d; yD++) {
				for (int zD = 0; zD <= h; zD++) {
					int x = xO + xD;
					int y = yO + yD;
					int z = zO + zD;
					Block block2 = world.getBlock(x, y, z);

					if (block2 != block) {
						hasfoundnonemultiblock = false;
					}
				}
			}
		}
		if (hasfoundnonemultiblock = true) {
			return true;
		}

		return false;
	}

}
