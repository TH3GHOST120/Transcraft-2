package modmuss50.mods.transcraft.Blocks.FancyCrystalGlass;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modmuss50.mods.transcraft.Blocks.ColoredItemBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ItemFancyCryastalGlass extends ColoredItemBlock {

	public ItemFancyCryastalGlass(Block par1) {
		super(par1);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			list.add("\u00a72This type of glass has conected textures!");
			list.add("\u00a72It can be broken with any Pickaxe");
		}
		else {
			list.add("\u00a72[\u00a74SHIFT\u00a72]");
		}
	}

}
