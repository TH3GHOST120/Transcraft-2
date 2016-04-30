package modmuss50.mods.transcraft.addons.fmp;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.World;

public class ColorData {
	public static float[][]	defaultColor	= EntitySheep.fleeceColorTable;

	public static float[] getColorData(World world, int x, int y, int z, int metadata) {
		return defaultColor[metadata];
	}
}
