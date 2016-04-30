package modmuss50.mods.transcraft.Client.Transpedia;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class TranspediaRegistry {

	public static ArrayList<TranspediaEntry>	pages;
	static boolean								hasinted	= false;

	public static void addPage(String tile, ItemStack image, String l0, String l1, String l2, String l3, String l4, String l5, String l6, String l7, String l8, String l9, String l10) {
		if (!hasinted) {
			pages = new ArrayList<TranspediaEntry>();
			hasinted = true;
		}
		pages.add(new TranspediaEntry(tile, image, l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10));
	}

	public static TranspediaEntry getPage(int i) {
		if (!hasinted) {
			pages = new ArrayList<TranspediaEntry>();
			hasinted = true;
		}

		if (pages.get(i) == null || i == pages.size()) {
			return null;
		}
		else {
			return pages.get(i);
		}
	}

}
