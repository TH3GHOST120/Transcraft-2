/**
 * This class is part of the mod Transcraft. 
 *
 * Transcraft is Open Source but you cant use any code without permission!
 *
 */

package modmuss50.mods.transcraft.Utils;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Arrays;
import java.util.List;

public class TranscraftUtil {

	public static final String				VERSION			= "1.7.2_V2.1.0_";
	public static final String				STATE			= "RELEASE_1";

	public static boolean					devstuff		= true;

	public static final String				UPDATEVERSION	= VERSION + STATE;

	public static ToolMaterial				PlasticTool		= EnumHelper.addToolMaterial("PlasticTool", 2, 750, 5.0F, 2, 0);
	public static ToolMaterial				BunkerToolEnum	= EnumHelper.addToolMaterial("BunkerToolEnum", 4, 1000, 20.0F, 4, 0);
	public static ToolMaterial				EnderToolEnum	= EnumHelper.addToolMaterial("EnderToolEnum", 400, 10000, 80.0F, 46, 100);

	public static List<String>				authorList		= Arrays.asList("mark123mark", "tattyseal", "shifu_", "klmDF14J", "Ayresy");

	public static ItemArmor.ArmorMaterial	PlasticEnum		= EnumHelper.addArmorMaterial("Plastic", 15, new int[]{3, 5, 5, 2}, 5);

	public static ItemArmor.ArmorMaterial	TechniumEnum	= EnumHelper.addArmorMaterial("Technium", 32, new int[]{3, 8, 5, 2}, 0);

	public static ItemArmor.ArmorMaterial	EnderEnum		= EnumHelper.addArmorMaterial("Ender", 9850, new int[]{10, 20, 14, 10}, 100);

}
