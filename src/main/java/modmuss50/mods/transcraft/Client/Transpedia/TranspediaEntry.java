package modmuss50.mods.transcraft.Client.Transpedia;

import net.minecraft.item.ItemStack;

public class TranspediaEntry {

	public String		title;
	public ItemStack	image;
	public String		l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;

	public TranspediaEntry(String tille, ItemStack image, String l0, String l1, String l2, String l3, String l4, String l5, String l6, String l7, String l8, String l9, String l10) {
		this.title = tille;
		this.image = image;
		this.l0 = l0;
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
		this.l5 = l5;
		this.l6 = l6;
		this.l7 = l7;
		this.l8 = l8;
		this.l9 = l9;
		this.l10 = l10;
	}

	public String getTitle() {
		return title;
	}

	public ItemStack getImage() {
		return image;
	}

	public String getL0() {
		return l0;
	}

	public String getL1() {
		return l1;
	}

	public String getL2() {
		return l2;
	}

	public String getL3() {
		return l3;
	}

	public String getL4() {
		return l4;
	}

	public String getL5() {
		return l5;
	}

	public String getL6() {
		return l6;
	}

	public String getL7() {
		return l7;
	}

	public String getL8() {
		return l8;
	}

	public String getL9() {
		return l9;
	}

	public String getL10() {
		return l10;
	}

}
