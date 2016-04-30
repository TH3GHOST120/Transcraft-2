package modmuss50.mods.transcraft.addons.fmp;

import codechicken.microblock.BlockMicroMaterial;
import net.minecraft.block.Block;

//This File was made by Modmuss50 and it can NOT be coped in any way or form.

public class ColorMultipart extends BlockMicroMaterial {

	public ColorMultipart(Block block, int meta) {
		super(block, meta);
	}

	@Override
	public int getColour(int pass) {
		return block().getRenderColor(meta()) << 8 | 0xFF;
	}

}
