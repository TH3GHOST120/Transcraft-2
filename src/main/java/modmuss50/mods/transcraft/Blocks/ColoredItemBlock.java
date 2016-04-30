package modmuss50.mods.transcraft.Blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ColoredItemBlock extends ItemBlock {

	public static String[]	subNames	= { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "Silver", "Gray", "Pink", "Lime", "Yellow", "Light Blue", "Magenta", "Orange", "White" };

	public ColoredItemBlock(Block id) {
		super(id);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}

	@Override
	public int getColorFromItemStack(ItemStack i, int i2) {
		switch (i.getItemDamage()) {
			case 15:
				return 0xFFFFFF;
			case 14:
				return 0xFF9900;
			case 13:
				return 0xCC00CC;
			case 12:
				return 0x6699FF;
			case 11:
				return 0xFFFF00;
			case 10:
				return 0x99CC00;
			case 9:
				return 0xFF66FF;
			case 8:
				return 0x585858;
			case 7:
				return 0xA8A8A8;
			case 6:
				return 0x00CC99;
			case 5:
				return 0x990066;
			case 4:
				return 0x3333CC;
			case 3:
				return 0x663300;
			case 2:
				return 0x336600;
			case 1:
				return 0xCC0000;
			case 0:
				return 0x383838;
			default:
				return 0xFFFFFF;
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName();
	}

}
