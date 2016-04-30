package modmuss50.mods.transcraft.Items.armor;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorEnderBoots extends ItemArmor // implements
// IArmorTextureProvider
{

	private String	LocationFile;
	private String	textureFile;
	public String	IconName;
	private int		repairItemID	= 0;

	public ArmorEnderBoots(ArmorMaterial enumarmormaterial, int renderIndex, int armorType) {
		super(enumarmormaterial, renderIndex, armorType);

	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("Transcraft:EnderBoots");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

		return "transcraft:textures/armor/EnderArmor_1.png";
	}

}
