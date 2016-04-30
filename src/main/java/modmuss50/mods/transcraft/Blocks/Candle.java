package modmuss50.mods.transcraft.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modmuss50.mods.transcraft.Blocks.TileEntitys.CandleTile;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class Candle extends BlockContainer {
	public Candle() {
		super(Material.anvil);
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass() {
		return -1;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new CandleTile();
	}

	public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 0.5F, 0.625F);
		super.setBlockBoundsBasedOnState(par1iBlockAccess, par2, par3, par4);
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		double var7 = par2 + 0.5F;
		double var9 = par3 + 0.7F;
		double var11 = par4 + 0.5F;

		par1World.spawnParticle("smoke", var7, var9, var11, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", var7, var9, var11, 0.0D, 0.0D, 0.0D);
	}

}
