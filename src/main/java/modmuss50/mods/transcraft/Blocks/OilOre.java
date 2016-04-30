package modmuss50.mods.transcraft.Blocks;

import modmuss50.mods.transcraft.Items.TranscraftItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class OilOre extends Block {

	public OilOre() {
		super(Material.rock);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return TranscraftItems.Oil;
	}

}
