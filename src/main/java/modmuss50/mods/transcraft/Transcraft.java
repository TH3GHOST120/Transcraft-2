package modmuss50.mods.transcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.Client.TranscraftClientProxy;
import modmuss50.mods.transcraft.Utils.TranscraftUtil;
import modmuss50.mods.transcraft.loaders.LoadMod;
import modmuss50.mods.transcraft.netty.PacketPipeline;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

@Mod(modid = "transcraft", name = "Transcraft", version = TranscraftUtil.VERSION + TranscraftUtil.STATE, useMetadata = false, guiFactory = "modmuss50.mods.transcraft.Client.ConfigGuiFactory")
public class Transcraft {

	@Instance("transcraft")
	public static Transcraft			instance;

	@SidedProxy(clientSide = "modmuss50.mods.transcraft.Client.TranscraftClientProxy", serverSide = "modmuss50.mods.transcraft.TranscraftCommonProxy")
	public static TranscraftCommonProxy	Coproxy;
	public static TranscraftClientProxy	Clproxy;

	public static final PacketPipeline	packetPipeline	= new PacketPipeline();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LoadMod.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		LoadMod.init(event);
		packetPipeline.initalise();
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		LoadMod.postInit(event);
		packetPipeline.postInitialise();
	}

	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event) {
		LoadMod.onServerStarting(event);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		LoadMod.load(event);
	}

	public static CreativeTabs	Transtab	= new CreativeTabs("Transtab") {
												@Override
												public Item getTabIconItem() {
													return ItemBlock.getItemFromBlock(TranscraftBlocks.Transcrafter);
												}
											};

}
