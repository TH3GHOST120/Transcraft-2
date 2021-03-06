package modmuss50.mods.transcraft.Items.Technium;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by Mark on 20/02/14.
 */
public class TechniumLeggs extends ItemArmor

{

	private String	LocationFile;
	private String	textureFile;
	public String	IconName;
	private int		repairItemID	= 0;

	public TechniumLeggs(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("Transcraft:TechniumLeggs");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

		return "transcraft:textures/armor/TechniumArmor_2.png";
	}

}
