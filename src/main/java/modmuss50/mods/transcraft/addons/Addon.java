package modmuss50.mods.transcraft.addons;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

public class Addon {

	public String	modid;

	public int		loadStage;

	public boolean	loaded	= false;

	/**
	 * @param modid
	 *            The mod id of the mod that this addon adds content for.
	 * @param loadStage
	 *            The mod loading stage that this addon is loaded at. 0 is
	 *            preInit, 1 is init and 2 is postInit.
	 */
	public Addon(String modid, int loadStage) {
		this.modid = modid;
		this.loadStage = loadStage;
	}

	public void load() {

	}

	/**
	 * Do not override me or call me unless neccessary. I am here to check for
	 * addon construction issues
	 */
	public void preLoad() {
		FMLLog.info("[Transcraft] Attempting to load the " + modid + " addon");
		if (Loader.isModLoaded(modid)) {
			loaded = true;
			load();
			FMLLog.info("[Transcraft] Successfully loaded the " + modid + " addon");
		}
	}
}
