package modmuss50.mods.transcraft.Items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class EnderQuartz extends Item {

	public EnderQuartz() {
		super();
		// Constructor Configuration
		maxStackSize = 16;
		// setCreativeTab(Transcraft.Transtab);
		setUnlocalizedName("EnderQuartz");
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("Transcraft:EnderQuartz");
	}

}
