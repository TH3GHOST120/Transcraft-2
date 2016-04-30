package modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter;

import modmuss50.mods.transcraft.Transcraft;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class Transcrafter extends BlockContainer {
	public static IIcon[]	icons	= new IIcon[2];
	public int				multiblock;

	public Transcrafter() {
		super(Material.anvil);
		this.setHardness(2F);

	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (side == 1 || side == 0) {
			return icons[0];
		}
		else {
			return icons[1];
		}
	}

	public int tickRate(World par1World) {
		return 2;
	}

	@Override
	public void registerBlockIcons(IIconRegister i) {
		icons[0] = i.registerIcon("transcraft:TC_top");
		icons[1] = i.registerIcon("transcraft:TC_side");
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int par6, float par7, float par8, float par9) {

		if (p.isSneaking()) {
			return true;
		}
		else {
			p.openGui(Transcraft.instance, 1, w, x, y, z);
		}

		return true;

	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileTC();
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

}
