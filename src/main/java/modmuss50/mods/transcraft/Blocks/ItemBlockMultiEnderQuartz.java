package modmuss50.mods.transcraft.Blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockMultiEnderQuartz extends ItemBlock {

	public ItemBlockMultiEnderQuartz(Block par1) {
		super(par1);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int dmg) {
		return dmg;
	}

	// @Override
	// public String getUnlocalizedName(ItemStack stack) {
	// return "present_" + stack.getItemDamage();
	// }
}
