package modmuss50.mods.transcraft.loaders;

import modmuss50.mods.transcraft.Blocks.*;
import modmuss50.mods.transcraft.Blocks.Quartz.CutEnderQuartz;
import modmuss50.mods.transcraft.Blocks.Quartz.EnderQuartz;
import modmuss50.mods.transcraft.Blocks.Quartz.EnderQuartzBigBrick;
import modmuss50.mods.transcraft.Blocks.Quartz.EnderQuartzBrick;
import modmuss50.mods.transcraft.Blocks.Technium.TechniumBlock;
import modmuss50.mods.transcraft.Blocks.TileEntitys.EnderDigger.BlockEnderDigger;
import modmuss50.mods.transcraft.Blocks.TileEntitys.ItemGrinder.ItemGrinder;
import modmuss50.mods.transcraft.Blocks.TileEntitys.MagicalInfuser.BlockMagicalInfuser;
import modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter.Transcrafter;
import modmuss50.mods.transcraft.Transcraft;
import modmuss50.mods.transcraft.Utils.TranscraftUtil;

public class LoadBlocks {

	public static void LoadBlocks() {

		TranscraftBlocks.TranscraftOre = new TranscraftOre().setBlockName("Transcraft:TranscraftOre").setHardness(1.5F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:TranscraftOre");

		TranscraftBlocks.OilOre = new modmuss50.mods.transcraft.Blocks.OilOre().setBlockName("Transcraft:OilOre").setHardness(1.5F).setBlockTextureName("Transcraft:OilOre").setCreativeTab(Transcraft.Transtab);

		TranscraftBlocks.BlueLight = new modmuss50.mods.transcraft.Blocks.Lights.BlueLight().setBlockName("Transcraft:BlueLight").setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setLightLevel(1.0F).setLightOpacity(0).setBlockTextureName("Transcraft:BlueLight");

		TranscraftBlocks.GreenLight = new modmuss50.mods.transcraft.Blocks.Lights.GreenLight().setBlockName("Transcraft:GreenLight").setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setLightLevel(1.0F).setLightOpacity(0).setBlockTextureName("Transcraft:GreenLight");

		TranscraftBlocks.OrangeLight = new modmuss50.mods.transcraft.Blocks.Lights.OrangeLight().setBlockName("Transcraft:OrangeLight").setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setLightLevel(1.0F).setLightOpacity(0).setBlockTextureName("Transcraft:OrangeLight");

		TranscraftBlocks.DarkLight = new modmuss50.mods.transcraft.Blocks.Lights.DarkLight().setBlockName("Transcraft:DarkLight").setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setLightLevel(1.0F).setLightOpacity(0).setBlockTextureName("Transcraft:DarkLight");

		TranscraftBlocks.IronTorch = new modmuss50.mods.transcraft.Blocks.IronTorch().setBlockName("Transcraft:IronTorch").setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setLightLevel(1.0F).setLightOpacity(0).setBlockTextureName("Transcraft:IronTorch");

		TranscraftBlocks.ClearGlass = new modmuss50.mods.transcraft.Blocks.CrystalGlass().setBlockName("Transcraft:ClearGlass").setHardness(1.5F).setCreativeTab(Transcraft.Transtab).setLightLevel(0.0F).setLightOpacity(0).setBlockTextureName("Transcraft:ClearGlass");

		TranscraftBlocks.FancyCrystalGlass = new modmuss50.mods.transcraft.Blocks.FancyCrystalGlass.FancyCrystalGlass("clear", false)

		.setBlockName("Transcraft:FancyCrystalGlass").setHardness(1.5F).setCreativeTab(Transcraft.Transtab).setLightLevel(0.0F).setLightOpacity(0).setBlockTextureName("Transcraft:FancyCrystalGlass");

		TranscraftBlocks.ThinClearGlass = new ThinCrystalGlass().setBlockName("Transcraft:ThinClearGlass").setHardness(1.5F).setCreativeTab(Transcraft.Transtab).setLightLevel(0.0F).setLightOpacity(0).setBlockTextureName("Transcraft:ClearGlass");

		TranscraftBlocks.BunkerBlock = new modmuss50.mods.transcraft.Blocks.BunkerBlock().setBlockName("Transcraft:BunkerBlock").setHardness(10.0F).setResistance(999999999999999999999.0F).setCreativeTab(Transcraft.Transtab).setLightLevel(0.0F).setLightOpacity(0).setBlockTextureName("Transcraft:BunkerBlock");

		TranscraftBlocks.BunkerStair = (new modmuss50.mods.transcraft.Blocks.BunkerStair(TranscraftBlocks.BunkerBlock, 0)).setBlockName("Transcraft:BunkerStair").setCreativeTab(Transcraft.Transtab).setHardness(10.0F).setResistance(999999999999.0F).setBlockTextureName("Transcraft:BunkerStair");

		TranscraftBlocks.ObsidianLever = new modmuss50.mods.transcraft.Blocks.ObsidianLever().setBlockName("Transcraft:ObsidianLever").setHardness(50.0F).setResistance(999999999999999999999.0F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:ObsidianLever");

		TranscraftBlocks.SmoothBunkerBlock = new modmuss50.mods.transcraft.Blocks.SmoothBunkerBlock().setBlockName("Transcraft:SmoothBunkerBlock").setHardness(10.0F).setResistance(999999999999999999999.0F).setCreativeTab(Transcraft.Transtab).setLightLevel(0.0F).setLightOpacity(0).setBlockTextureName("Transcraft:SmoothBunkerBlock");

		TranscraftBlocks.SmoothBunkerStair = (new modmuss50.mods.transcraft.Blocks.SmoothBunkerStair(TranscraftBlocks.SmoothBunkerBlock, 0)).setBlockName("Transcraft:SmoothBunkerStair").setCreativeTab(Transcraft.Transtab).setHardness(10.0F).setResistance(999999999999999999999.0F).setBlockTextureName("Transcraft:SmoothBunkerStair");

		TranscraftBlocks.DriedTransmutter = (new modmuss50.mods.transcraft.Blocks.DriedTransmutter().setBlockName("Transcraft:DriedTransmutter").setCreativeTab(Transcraft.Transtab).setHardness(3.0F).setResistance(9.0F).setLightLevel(1.0F).setBlockTextureName("Transcraft:DriedTransmutter"));

		TranscraftBlocks.ComIronOre = new modmuss50.mods.transcraft.Blocks.ComOres.ComIronOre().setBlockName("Transcraft:ComIronOre").setHardness(1.5F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:ComIronOre");

		TranscraftBlocks.ComGoldOre = new modmuss50.mods.transcraft.Blocks.ComOres.ComGoldOre().setBlockName("Transcraft:ComGoldOre").setHardness(1.5F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:ComGoldOre");

		TranscraftBlocks.ComTransmutterOre = new modmuss50.mods.transcraft.Blocks.ComOres.ComTransmutterOre().setBlockName("Transcraft:ComTransmutterOre").setHardness(1.5F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:ComTransmutterOre");

		TranscraftBlocks.ComOilOre = new modmuss50.mods.transcraft.Blocks.ComOres.ComOilOre().setBlockName("Transcraft:ComOilOre").setHardness(1.5F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:ComOilOre");

		TranscraftBlocks.Transcrafter = new Transcrafter().setCreativeTab(Transcraft.Transtab).setHardness(1.0F).setBlockName("Transcraft:Transcrafter");

		TranscraftBlocks.enderQuartzBlock = new EnderQuartz().setBlockName("Transcraft:plasticblock").setBlockTextureName("Transcraft:enderquartz").setHardness(1.0F).setCreativeTab(Transcraft.Transtab);

		TranscraftBlocks.CutenderQuartz = new CutEnderQuartz().setBlockName("Transcraft:Cutplastic").setBlockTextureName("Transcraft:CutEnderQuartz").setHardness(1.0F).setCreativeTab(Transcraft.Transtab);

		TranscraftBlocks.EnderQuartzBrick = new EnderQuartzBrick().setBlockName("Transcraft:plasticBrick").setBlockTextureName("Transcraft:EnderQuartzBrick").setHardness(1.0F).setCreativeTab(Transcraft.Transtab);

		TranscraftBlocks.EnderQuartzBigBrick = new EnderQuartzBigBrick().setBlockName("Transcraft:plasticBigBricks").setBlockTextureName("Transcraft:EnderQuartzBrick2").setHardness(1.0F).setCreativeTab(Transcraft.Transtab);

		TranscraftBlocks.ixpGrinder = new ItemGrinder(0).setBlockName("Transcraft:ixpGrinder").setHardness(1.0F).setBlockTextureName("Transcraft:ixpGrinder").setCreativeTab(Transcraft.Transtab);

		// TranscraftBlocks.TransmutterPlant = new TransmutterPlant()
		// .setHardness(1.0F).setCreativeTab(Transcraft.Transtab)
		// .setBlockTextureName("Transcraft:TransmutterPlant")
		// .setBlockName("Transcraft:TransmutterPlant");

		TranscraftBlocks.Candle = new Candle().setHardness(0.3F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:Candle").setBlockName("Transcraft:Candle").setLightLevel(0.25F);

		TranscraftBlocks.TechniumBlock = new TechniumBlock().setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:TechniumBlock").setBlockName("Transcraft:TechniumBlock");

		TranscraftBlocks.SinisterBlock = new SinisterBlock().setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:SinisterBlock").setBlockName("Transcraft:SinisterBlock");

		TranscraftBlocks.MultiEnderQuartz_CutEnderQuartz = new MultiEnderQuartz().setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:CutEnderQuartz").setBlockName("Transcraft:MultiEnderQuartz_CutEnderQuartz");

		TranscraftBlocks.MultiEnderQuartz_EnderQuartzBrick = new MultiEnderQuartz().setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:EnderQuartzBrick").setBlockName("Transcraft:MultiEnderQuartz_EnderQuartzBrick");

		TranscraftBlocks.MultiEnderQuartz_EnderQuartzBrick2 = new MultiEnderQuartz().setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:EnderQuartzBrick2").setBlockName("Transcraft:MultiEnderQuartz_EnderQuartzBrick2");

		TranscraftBlocks.MultiEnderQuartz_enderquartz = new MultiEnderQuartz().setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:enderquartz").setBlockName("Transcraft:MultiEnderQuartz_enderquartz");

		if (TranscraftUtil.devstuff)
			TranscraftBlocks.EnderDigger = new BlockEnderDigger().setHardness(1.0F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:EnderDigger").setBlockName("Transcraft:EnderDigger");

		TranscraftBlocks.TransmutterFlower = new TransmutterFlower().setHardness(0.2F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:transmutterFlower").setBlockName("Transcraft:TransmutterFlower");

		if (TranscraftUtil.devstuff)
			TranscraftBlocks.MagicalInfuser = new BlockMagicalInfuser().setHardness(1.2F).setCreativeTab(Transcraft.Transtab).setBlockTextureName("Transcraft:MagicalInfuser").setBlockName("Transcraft:MagicalInfuser");

	}
}
