package modmuss50.mods.transcraft.addons.fmp;

import codechicken.lib.packet.PacketCustom;
import codechicken.microblock.BlockMicroMaterial;
import codechicken.microblock.MicroMaterialRegistry;
import codechicken.multipart.minecraft.McMultipartCPH;
import cpw.mods.fml.common.FMLCommonHandler;
import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.Blocks.TranscraftOre;
import modmuss50.mods.transcraft.Transcraft;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

public class TranscraftFMP {

	public static void registerBlocks() {
		for (int i = 0; i < TranscraftOre.types.length; i++) {
			BlockMicroMaterial.createAndRegister(TranscraftBlocks.TranscraftOre, i);
		}

		BlockMicroMaterial.createAndRegister(TranscraftBlocks.OilOre, 0);

		BlockMicroMaterial.createAndRegister(TranscraftBlocks.BunkerBlock, 0);

		BlockMicroMaterial.createAndRegister(TranscraftBlocks.SmoothBunkerBlock, 0);
		BlockMicroMaterial.createAndRegister(TranscraftBlocks.DriedTransmutter, 0);
		BlockMicroMaterial.createAndRegister(TranscraftBlocks.FancyCrystalGlass, 0);

		BlockMicroMaterial.createAndRegister(TranscraftBlocks.BlueLight, 0);
		BlockMicroMaterial.createAndRegister(TranscraftBlocks.GreenLight, 0);
		BlockMicroMaterial.createAndRegister(TranscraftBlocks.OrangeLight, 0);
		BlockMicroMaterial.createAndRegister(TranscraftBlocks.DarkLight, 0);

		BlockMicroMaterial.createAndRegister(TranscraftBlocks.ComIronOre, 0);
		BlockMicroMaterial.createAndRegister(TranscraftBlocks.ComGoldOre, 0);
		BlockMicroMaterial.createAndRegister(TranscraftBlocks.ComTransmutterOre, 0);
		BlockMicroMaterial.createAndRegister(TranscraftBlocks.ComOilOre, 0);

		registerColorBlock(TranscraftBlocks.ClearGlass);
		registerColorBlock(TranscraftBlocks.FancyCrystalGlass);
		registerColorBlock(TranscraftBlocks.enderQuartzBlock);
		registerColorBlock(TranscraftBlocks.CutenderQuartz);
		registerColorBlock(TranscraftBlocks.EnderQuartzBrick);
		registerColorBlock(TranscraftBlocks.EnderQuartzBigBrick);

		// MicroMaterialRegistry.registerMaterial(new IronTorchPart(), "test");

		new TorchPartFactory().init();
		MinecraftForge.EVENT_BUS.register(new PartEventHandler());
		PacketCustom.assignHandler(Transcraft.instance, new TcMultipartSPH());
		if (FMLCommonHandler.instance().getSide().isClient())
			PacketCustom.assignHandler(Transcraft.instance, new McMultipartCPH());
	}

	public static void registerColorBlock(Block block) {
		if (block != null)
			for (int m = 0; m < 16; m++) {
				MicroMaterialRegistry.registerMaterial(new ColorMultipart(block, m), block.getUnlocalizedName() + (m > 0 ? "_" + m : ""));
			}
	}

	public static void registerTorchBlock(Block block, MicroMaterialRegistry.IMicroMaterial material) {
		MicroMaterialRegistry.registerMaterial(material, new String(block.getUnlocalizedName()));
	}

}
