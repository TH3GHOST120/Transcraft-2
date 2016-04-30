package modmuss50.mods.transcraft.Utils;

import cpw.mods.fml.common.IFuelHandler;
import modmuss50.mods.transcraft.Items.TranscraftItems;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler {
	@Override
	public int getBurnTime(ItemStack fuel) {

		if (fuel.getItem() == TranscraftItems.Oil) {
			return 1000;
		}
		else {
			return 0;
		}
	}

}
