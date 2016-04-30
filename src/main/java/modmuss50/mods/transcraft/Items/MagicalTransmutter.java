package modmuss50.mods.transcraft.Items;

import modmuss50.mods.transcraft.Utils.Config;
import modmuss50.mods.transcraft.api.IItemTransmutter;
import modmuss50.mods.transcraft.world.DimTp;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Mark on 17/04/14.
 */
public class MagicalTransmutter extends IItemTransmutter {

	public MagicalTransmutter() {
		super();
		maxStackSize = 4;
		setUnlocalizedName("MagicalTransmutter");
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("Transcraft:MagicalTransmutter");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

		if (par3EntityPlayer.ridingEntity == null && par3EntityPlayer.riddenByEntity == null) {
			if (par3EntityPlayer instanceof EntityPlayerMP) {
				EntityPlayerMP thePlayer = (EntityPlayerMP) par3EntityPlayer;
				if (par3EntityPlayer.dimension != Config.DimId) {
					// thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer,
					// Config.DimId, new
					// DimTp(thePlayer.mcServer.worldServerForDimension(Config.DimId)));
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Config.DimId);

					return par1ItemStack;
				}
				else {
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new DimTp(thePlayer.mcServer.worldServerForDimension(0)));
					return par1ItemStack;
				}
			}
		}
		return par1ItemStack;
	}

}
