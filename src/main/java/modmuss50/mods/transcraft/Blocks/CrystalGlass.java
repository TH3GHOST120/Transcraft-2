package modmuss50.mods.transcraft.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modmuss50.mods.transcraft.api.BetterColoredBlock;

public class CrystalGlass extends BetterColoredBlock {

	public static String	texName;

	public CrystalGlass() {
		super();
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass() {
		return 0;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	/*
	 * 
	 * 
	 * @Override public boolean shouldSideBeRendered(IBlockAccess
	 * par1IBlockAccess, int par2, int par3, int par4, int par5) // Renders //
	 * blocks { int i = par1IBlockAccess.getBlockId(par2, par3, par4);
	 * 
	 * return i == blockID ? false : true; }
	 */

}
