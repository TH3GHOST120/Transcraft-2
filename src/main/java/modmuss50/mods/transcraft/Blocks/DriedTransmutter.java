package modmuss50.mods.transcraft.Blocks;

import modmuss50.mods.transcraft.Blocks.TileEntitys.TileEntityPortal;
import modmuss50.mods.transcraft.Utils.Config;
import modmuss50.mods.transcraft.world.DimTeleporter;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class DriedTransmutter extends BlockContainer {

	public DriedTransmutter() {
		super(Material.cloth);
	}

	// @Override
	// public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int
	// par2, int par3, int par4)
	// {
	// return null;
	// }
	//
	// @Override
	// public void onEntityCollidedWithBlock(World par1World, int par2, int
	// par3, int par4, Entity par5Entity)
	// {
	// if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null)
	// {
	// if (par5Entity instanceof EntityPlayerMP)
	// {
	// EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
	// if (par5Entity.dimension != Config.DimId)
	// {
	// thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer,
	// Config.DimId, new
	// DimTp(thePlayer.mcServer.worldServerForDimension(Config.DimId)));
	// //
	// thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer,
	// Config.DimId);
	// }
	// else
	// {
	// thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer,
	// 0, new DimTp(thePlayer.mcServer.worldServerForDimension(0)));
	// //
	// thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer,
	// 0);
	// }
	// }
	// }
	// }

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5Entity, int par6, float par7, float par8, float par9) {
		if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP))) {
			EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;

			if (thePlayer.dimension != Config.DimId) {
				thePlayer.setLocationAndAngles(par2 + 0.5D, thePlayer.posY, par4 + 0.5D, thePlayer.rotationYaw, thePlayer.rotationPitch);
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Config.DimId, new DimTeleporter(thePlayer.mcServer.worldServerForDimension(Config.DimId)));
			}
			else {
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new DimTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
			}

			return true;
		}

		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityPortal();
	}
}
