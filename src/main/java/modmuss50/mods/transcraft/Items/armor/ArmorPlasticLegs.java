package modmuss50.mods.transcraft.Items.armor;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorPlasticLegs extends ItemArmor {

	private String	LocationFile;
	private String	textureFile;
	public String	IconName;
	private int		repairItemID	= 0;

	public ArmorPlasticLegs(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		maxStackSize = 1;
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("Transcraft:PlasticLegs");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

		return "transcraft:textures/armor/PlasticArmor_2.png";
	}

}
