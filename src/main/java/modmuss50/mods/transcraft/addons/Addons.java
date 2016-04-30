package modmuss50.mods.transcraft.addons;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.LanguageRegistry;
import modmuss50.mods.transcraft.addons.Baubles.TranscraftBaubles;
import modmuss50.mods.transcraft.addons.fmp.TranscraftFMP;
import modmuss50.mods.transcraft.addons.nei.StartNEIPlugin;

import java.util.ArrayList;

public class Addons {

	public static ArrayList<Addon>	addons;

	public static void addAddons() {
		addons = new ArrayList<Addon>();

		addons.add(new Addon("Waila", 0) {
			@Override
			public void load() {
				FMLInterModComms.sendMessage("Waila", "register", "modmuss50.mods.transcraft.addons.waila.TranscraftProvider.callbackRegister");
			}
		});

		addons.add(new Addon("Baubles", 0) {
			@Override
			public void load() {
				TranscraftBaubles.load();
			}
		});

		addons.add(new Addon("ForgeMultipart", 1) {
			@Override
			public void load() {
				TranscraftFMP.registerBlocks();
			}
		});

		addons.add(new Addon("IC2", 2) {
			@Override
			public void load() {
				// ItemStack nuke = Items.getItem("nuke");
				// ItemStack nuke2 = Items.getItem("nuke").copy();
				// nuke2.stackSize = 2;
				// GameRegistry.addRecipe((nuke2), "   ", "ndn", "   ",'n',
				// Transcraft.NanoTransmuter, 'd', nuke);

				// Items.addRecipe(Transcraft.Oil, Transcraft.Plastic);
				// Items.

				// recipes.addMaceratorRecipe(tStack, tOutput);
			}
		});

		addons.add(new Addon("NotEnoughItems", 2) {
			@Override
			public void load() {
				LanguageRegistry.instance().addStringLocalization("nei.Transcrafter", "Transcrafter");
				try {
					StartNEIPlugin.START();
				}
				catch (Exception e) {

				}
			}
		});
	}

	public static void loadAddons(int loadStage) {
		FMLLog.info("[Transcraft] Loading Transcraft Addons");
		for (Addon addon : addons) {
			if (addon.loadStage == loadStage && !addon.loaded) {
				addon.preLoad();
			}
		}
	}
}
