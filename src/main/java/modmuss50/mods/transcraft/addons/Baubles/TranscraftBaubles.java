package modmuss50.mods.transcraft.addons.Baubles;

import cpw.mods.fml.common.registry.LanguageRegistry;
import modmuss50.mods.transcraft.Transcraft;
import modmuss50.mods.transcraft.loaders.RegisterBlocksItems;
import net.minecraft.item.Item;

/**
 * Created with IntelliJ IDEA. User: Mark Date: 02/04/14 Time: 15:40
 */
public class TranscraftBaubles {

	public static Item	EnderBauble;

	public static void load() {
		EnderBauble = new EnderBauble().setUnlocalizedName("transcraft:EnderBauble").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:EnderBauble");

		RegisterBlocksItems.registerItem(EnderBauble);
		LanguageRegistry.addName(EnderBauble, "Ender Belt");
	}

}
