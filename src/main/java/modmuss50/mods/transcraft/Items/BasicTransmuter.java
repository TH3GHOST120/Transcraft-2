package modmuss50.mods.transcraft.Items;

import modmuss50.mods.transcraft.api.IItemTransmutter;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BasicTransmuter extends IItemTransmutter {

	public BasicTransmuter() {
		super();
		// Constructor Configuration
		maxStackSize = 64;
		// setCreativeTab(Transcraft.Transtab);
		setUnlocalizedName("BasicTransmuter");
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("Transcraft:BasicTransmuter");
	}

}
