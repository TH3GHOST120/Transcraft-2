package modmuss50.mods.transcraft.Utils;

import net.minecraft.item.ItemStack;

public interface IStackFilter {

	public boolean matches(ItemStack stack);
}
