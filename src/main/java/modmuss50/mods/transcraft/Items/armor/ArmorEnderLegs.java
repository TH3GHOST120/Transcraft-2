package modmuss50.mods.transcraft.Items.armor;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorEnderLegs extends ItemArmor // implements
// IArmorTextureProvider
{

	private String	LocationFile;
	private String	textureFile;
	public String	IconName;
	private int		repairItemID	= 0;

	public ArmorEnderLegs(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("Transcraft:EnderLegs");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

		return "transcraft:textures/armor/EnderArmor_2.png";
	}

}
