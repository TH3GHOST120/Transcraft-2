/**
 * This class is part of the mod Transcraft. 
 *
 * Transcraft is Open Source but you cant use any code without permission!
 *
 */

package modmuss50.mods.transcraft.loaders;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.Blocks.fluids.TranscraftFluids;
import modmuss50.mods.transcraft.Client.Transpedia.TranspediaRegistry;
import modmuss50.mods.transcraft.Items.TranscraftItems;
import modmuss50.mods.transcraft.Transcraft;
import modmuss50.mods.transcraft.Utils.*;
import modmuss50.mods.transcraft.Utils.Listener.ListenerRegisterSound;
import modmuss50.mods.transcraft.Utils.command.CommandReloadConfig;
import modmuss50.mods.transcraft.Utils.command.CommandTranscraftVersion;
import modmuss50.mods.transcraft.WorldGen.FlowerGen;
import modmuss50.mods.transcraft.WorldGen.TranscraftGenerator;
import modmuss50.mods.transcraft.WorldGen.biomes.TranscraftBiomes;
import modmuss50.mods.transcraft.addons.Addons;
import modmuss50.mods.transcraft.addons.Thumcraft.Thumcraft_ForgeMultipart;
import modmuss50.mods.transcraft.world.DimWorldProv;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

public class LoadMod {

	public static void preInit(FMLPreInitializationEvent event) {
		event.getModMetadata().version = (TranscraftUtil.VERSION + TranscraftUtil.STATE);

		FMLLog.info("[TRANSCRAFT]	Starting Transcraft verison " + TranscraftUtil.VERSION);

		FMLLog.info("[TRANSCRAFT]	Loading Handlers");
		Transcraft.Coproxy.registerHandlers();
		Transcraft.Coproxy.registerTickHandlers();

		FMLLog.info("[TRANSCRAFT]	Loading Config");
		Config.initConfig();

		FMLLog.info("[TRANSCRAFT]	Loading entities");
		LoadEntity.loadentity();

		FMLLog.info("[TRANSCRAFT]	Loading Biomes");
		TranscraftBiomes.loadBiomes();

		FMLCommonHandler.instance().bus().register(new UpdateChecker());

		if (event.getSide() == Side.CLIENT) {
			MinecraftForge.EVENT_BUS.register(new ListenerRegisterSound());
		}

		FMLLog.info("[TRANSCRAFT]	Loading Addons");

		Addons.addAddons();
		Addons.loadAddons(0);

		NetworkRegistry.INSTANCE.registerGuiHandler(Transcraft.instance, new GuiHand());

		FMLCommonHandler.instance().bus().register(new TickHelper());
		MinecraftForge.EVENT_BUS.register(new TickHelper());

	}

	public static void init(FMLInitializationEvent event) {

		FMLLog.info("[TRANSCRAFT]	Loading Blocks");
		LoadBlocks.LoadBlocks();

		FMLLog.info("[TRANSCRAFT]	Loading Items");
		LoadItems.LoadItems();

		FMLLog.info("[TRANSCRAFT]	Registering Blocks");
		RegisterBlocksItems.RegisterBlocks();

		FMLLog.info("[TRANSCRAFT]	Loading Block Settings");
		LoadBlockSettings.LoadSet();

		FMLLog.info("[TRANSCRAFT]	Adding Recipes");
		RecipeLoader.LoadRecipe();

		// FMLLog.info("[TRANSCRAFT]	Adding Chest gen hooks");
		LoadChestGen.LoadChest();

		// FMLLog.info("[TRANSCRAFT]	Registering world gen");
		GameRegistry.registerWorldGenerator(new TranscraftGenerator(), 0);

		// FMLLog.info("[TRANSCRAFT]	Registering Fuel handler");
		GameRegistry.registerFuelHandler(new FuelHandler());

		Transcraft.Coproxy.renderThings();

		MinecraftForge.EVENT_BUS.register(new EventMobDeath());

		Addons.loadAddons(1);

		if (Loader.isModLoaded("ForgeMultipart") && Loader.isModLoaded("Thaumcraft")) {
			Thumcraft_ForgeMultipart.load();
		}


		MinecraftForge.TERRAIN_GEN_BUS.register(new FlowerGen());

		if (TranscraftUtil.devstuff)
			FMLLog.info("[TRANSCRAFT]	Loading Fluids");
		if (TranscraftUtil.devstuff)
			TranscraftFluids.init();

		TranspediaRegistry.addPage("This is not ready yet!", new ItemStack(TranscraftItems.EnderSword), "WIP", "WIP", "WIP", "WIP", "WIP", "WIP", "WIP", "WIP", "WIP", "WIP", "WIP");

		TranspediaRegistry.addPage("Item Grinder", new ItemStack(TranscraftBlocks.ixpGrinder), "WIP", "WIP", "WIP", "WIP", "WIP", "WIP", "WIP", "WIP", "WIP", "WIP", "WIP");

		// DimensionManager.registerProviderType(25, DimWorldProv.class, false);
		// DimensionManager.registerDimension(25, Config.DimId);

		DimensionManager.registerProviderType(Config.DimId, DimWorldProv.class, false);
	}

	public static void postInit(FMLPostInitializationEvent event) {
		Addons.loadAddons(2);
		// Clproxy.postrenderThings();
		DimensionManager.registerDimension(Config.DimId, Config.DimId);
	}

	public static void onServerStarting(FMLServerStartingEvent event) {
		FMLLog.info("[TRANSCRAFT]	Adding commands");
		event.registerServerCommand(new CommandTranscraftVersion());
		event.registerServerCommand(new CommandReloadConfig());
	}

	public static void load(FMLInitializationEvent event) {

	}

}
