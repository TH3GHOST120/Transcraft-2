package modmuss50.mods.transcraft.Items;

import modmuss50.mods.transcraft.Transcraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Transpeadia extends Item {

	public Transpeadia() {
		super();
		maxStackSize = 1;
		setCreativeTab(Transcraft.Transtab);
		setUnlocalizedName("Transpeadia");
	}

	public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p) {
		p.openGui(Transcraft.instance, 3, w, (int) p.posX, (int) p.posY, (int) p.posZ);
		p.playSound("transcraft:paper", 10F, 0.7F);
		return i;
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("Transcraft:Transpeadia");
	}

}
