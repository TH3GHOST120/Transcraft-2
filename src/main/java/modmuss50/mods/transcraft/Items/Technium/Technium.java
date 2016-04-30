package modmuss50.mods.transcraft.Items.Technium;

import modmuss50.mods.transcraft.Transcraft;
import net.minecraft.item.Item;

/**
 * Created by Mark on 20/02/14.
 */
public class Technium extends Item {

	public Technium() {
		super();
		maxStackSize = 64;
		setCreativeTab(Transcraft.Transtab);
		setUnlocalizedName("Technium");
	}

}
