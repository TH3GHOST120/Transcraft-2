package modmuss50.mods.transcraft.addons.Thumcraft;

import codechicken.microblock.BlockMicroMaterial;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;

public class Thumcraft_ForgeMultipart {

	public static void load() {
		for (int i = 0; i < 2; i++) {
			BlockMicroMaterial.createAndRegister(getBlock("blockMagicalLog"), i);
		}

		BlockMicroMaterial.createAndRegister(getBlock("blockWoodenDevice"), 6);
		BlockMicroMaterial.createAndRegister(getBlock("blockWoodenDevice"), 7);
	}

	public static Block getBlock(String itemString) {
		Block tempblock = null;

		try {
			String itemClass = "thaumcraft.common.config.ConfigBlocks";
			Object obj = Class.forName(itemClass).getField(itemString).get(null);
			if (obj instanceof Block) {
				tempblock = (Block) obj;
			}
		}
		catch (Exception ex) {
			FMLLog.warning("[Thaumcraft] Could not retrieve block identified by: " + itemString);
		}

		// System.out.println("TEMP" + tempblock.getUnlocalizedName());
		return tempblock;
	}

}
