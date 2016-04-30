package modmuss50.mods.transcraft.loaders;

import cpw.mods.fml.common.registry.GameRegistry;
import modmuss50.mods.transcraft.Blocks.ColoredItemBlock;
import modmuss50.mods.transcraft.Blocks.FancyCrystalGlass.ItemFancyCryastalGlass;
import modmuss50.mods.transcraft.Blocks.ItemThinCrystalGlass;
import modmuss50.mods.transcraft.Blocks.Quartz.ItemCutEnderQuartzBlock;
import modmuss50.mods.transcraft.Blocks.Quartz.ItemEnderQuartzBigBrick;
import modmuss50.mods.transcraft.Blocks.Quartz.ItemEnderQuartzBlock;
import modmuss50.mods.transcraft.Blocks.Quartz.ItemEnderQuartzBrick;
import modmuss50.mods.transcraft.Blocks.TileEntitys.CandleTile;
import modmuss50.mods.transcraft.Blocks.TileEntitys.EnderDigger.TileEntiyEnderDigger;
import modmuss50.mods.transcraft.Blocks.TileEntitys.ItemGrinder.ItemGrinderTile;
import modmuss50.mods.transcraft.Blocks.TileEntitys.MagicalInfuser.MagicalTile;
import modmuss50.mods.transcraft.Blocks.TileEntitys.TileEntityPortal;
import modmuss50.mods.transcraft.Blocks.TileEntitys.TileEntityTransmutterFlower;
import modmuss50.mods.transcraft.Blocks.TileEntitys.TileEntiyQuartzBlock;
import modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter.TileTC;
import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.Blocks.TranscraftOreItem;
import modmuss50.mods.transcraft.Items.TranscraftItems;
import modmuss50.mods.transcraft.Utils.TranscraftUtil;
import net.minecraft.item.Item;

public class RegisterBlocksItems {

	public static void RegisterBlocks() {

		GameRegistry.registerBlock(TranscraftBlocks.OilOre, "Oil Ore");
		GameRegistry.registerBlock(TranscraftBlocks.BlueLight, "Blue Light");
		GameRegistry.registerBlock(TranscraftBlocks.GreenLight, "Green Light");
		GameRegistry.registerBlock(TranscraftBlocks.OrangeLight, "Orange Light");
		GameRegistry.registerBlock(TranscraftBlocks.DarkLight, "Dark Light");
		GameRegistry.registerBlock(TranscraftBlocks.IronTorch, "IronTorch");

		GameRegistry.registerBlock(TranscraftBlocks.BunkerBlock, "Bunker Block");
		GameRegistry.registerBlock(TranscraftBlocks.SmoothBunkerStair, "Smooth Bunker Stair");
		GameRegistry.registerBlock(TranscraftBlocks.DriedTransmutter, "Dried Transmuter");
		GameRegistry.registerBlock(TranscraftBlocks.ComIronOre, "Packed Iron Ore");
		GameRegistry.registerBlock(TranscraftBlocks.ComGoldOre, "Packed Gold Ore");
		GameRegistry.registerBlock(TranscraftBlocks.ComTransmutterOre, "Packed Transmuter Ore");
		GameRegistry.registerBlock(TranscraftBlocks.ComOilOre, "Packed Oil Ore");
		GameRegistry.registerBlock(TranscraftBlocks.BunkerStair, "Bunker Stair");
		GameRegistry.registerBlock(TranscraftBlocks.ObsidianLever, "Obsidian Lever");
		GameRegistry.registerBlock(TranscraftBlocks.SmoothBunkerBlock, "Smooth Bunker Block");

		GameRegistry.registerBlock(TranscraftBlocks.enderQuartzBlock, ItemEnderQuartzBlock.class, "ItemEnderQuartzBlock");

		GameRegistry.registerBlock(TranscraftBlocks.CutenderQuartz, ItemCutEnderQuartzBlock.class, "ItemCutEnderQuartzBlock");

		GameRegistry.registerBlock(TranscraftBlocks.EnderQuartzBrick, ItemEnderQuartzBrick.class, "ItemEnderQuartzBrick");

		GameRegistry.registerBlock(TranscraftBlocks.EnderQuartzBigBrick, ItemEnderQuartzBigBrick.class, "ItemEnderQuartzBigBrick");

		GameRegistry.registerBlock(TranscraftBlocks.FancyCrystalGlass, ItemFancyCryastalGlass.class, "ItemFancyCryastalGlass");

		GameRegistry.registerBlock(TranscraftBlocks.TranscraftOre, TranscraftOreItem.class, "ItemTranscraftOreItem");

		GameRegistry.registerBlock(TranscraftBlocks.ClearGlass, ColoredItemBlock.class, "Clear Glass");

		GameRegistry.registerBlock(TranscraftBlocks.ThinClearGlass, ItemThinCrystalGlass.class, "ThinClearGlass");

		GameRegistry.registerBlock(TranscraftBlocks.Transcrafter, "Transcrafter");

		GameRegistry.registerBlock(TranscraftBlocks.ixpGrinder, "ItemGrinder");
		// GameRegistry.registerBlock(TranscraftBlocks.BlockColour,
		// "BlockColour");
		// GameRegistry.registerBlock(TranscraftBlocks.ImplostionCrafter,
		// "ImplostionCrafter");
		GameRegistry.registerBlock(TranscraftBlocks.Candle, "Candel");

		// GameRegistry.registerBlock(TranscraftBlocks.TransmutterPlant,
		// "TransmutterPlant");

		GameRegistry.registerBlock(TranscraftBlocks.TechniumBlock, "TechniumBlock");

		GameRegistry.registerBlock(TranscraftBlocks.SinisterBlock, "SinisterBlock");

		GameRegistry.registerBlock(TranscraftBlocks.MultiEnderQuartz_CutEnderQuartz, "MultiEnderQuartz_CutEnderQuartz");
		GameRegistry.registerBlock(TranscraftBlocks.MultiEnderQuartz_EnderQuartzBrick, "MultiEnderQuartz_EnderQuartzBrick");
		GameRegistry.registerBlock(TranscraftBlocks.MultiEnderQuartz_EnderQuartzBrick2, "MultiEnderQuartz_EnderQuartzBrick2");
		GameRegistry.registerBlock(TranscraftBlocks.MultiEnderQuartz_enderquartz, "MultiEnderQuartz_enderquartz");

		if (TranscraftUtil.devstuff)
			GameRegistry.registerBlock(TranscraftBlocks.EnderDigger, "EnderDigger");

		GameRegistry.registerBlock(TranscraftBlocks.TransmutterFlower, "TransmutterFlower");
		if (TranscraftUtil.devstuff)
			GameRegistry.registerBlock(TranscraftBlocks.MagicalInfuser, "MagicalInfuser");

		registerItem(TranscraftItems.BasicTransmuter);
		registerItem(TranscraftItems.QuadTransmuter);
		registerItem(TranscraftItems.NanoTransmuter);
		registerItem(TranscraftItems.HotDog);
		registerItem(TranscraftItems.Oil);
		registerItem(TranscraftItems.Plastic);
		registerItem(TranscraftItems.IronStick);
		registerItem(TranscraftItems.HardendPlastic);
		registerItem(TranscraftItems.EnderGem);
		registerItem(TranscraftItems.EnderQuartz);
		registerItem(TranscraftItems.DarkEndershard);
		if (TranscraftUtil.devstuff)
			registerItem(TranscraftItems.Transpedia);
		registerItem(TranscraftItems.Technium);
		if (TranscraftUtil.devstuff)
			registerItem(TranscraftItems.MagicalTransmutter);
		registerItem(TranscraftItems.BunkerPick);
		registerItem(TranscraftItems.EnderSword);
		registerItem(TranscraftItems.TechniumHelmet);
		registerItem(TranscraftItems.TechniumChestplate);
		registerItem(TranscraftItems.TechniumLeggs);
		registerItem(TranscraftItems.TechniumBoots);
		registerItem(TranscraftItems.EnderHelmet);
		registerItem(TranscraftItems.EnderChest);
		registerItem(TranscraftItems.EnderLegs);
		registerItem(TranscraftItems.EnderBoots);
		registerItem(TranscraftItems.FireStaff);

		registerItem(TranscraftItems.PlasticAxe);
		registerItem(TranscraftItems.PlasticHoe);
		registerItem(TranscraftItems.PlasticPickaxe);
		registerItem(TranscraftItems.PlasticShovel);
		registerItem(TranscraftItems.PlasticSword);

		registerItem(TranscraftItems.PlasticHelmet);
		registerItem(TranscraftItems.PlasticChest);
		registerItem(TranscraftItems.PlasticLegs);
		registerItem(TranscraftItems.PlasticBoots);
		registerItem(TranscraftItems.ColorCopier);

		GameRegistry.registerTileEntity(TileTC.class, "TileEntityTC");
		GameRegistry.registerTileEntity(ItemGrinderTile.class, "TileItemGrinder");

		GameRegistry.registerTileEntity(CandleTile.class, "CandleTile");
		GameRegistry.registerTileEntity(TileEntiyQuartzBlock.class, "TileEntiyQuartzBlock");
		if (TranscraftUtil.devstuff)
			GameRegistry.registerTileEntity(TileEntiyEnderDigger.class, "TileEntiyEnderDigger");
		GameRegistry.registerTileEntity(TileEntityTransmutterFlower.class, "TileEntityTransmutterFlower");
		if (TranscraftUtil.devstuff)
			GameRegistry.registerTileEntity(MagicalTile.class, "MagicalTile");

		GameRegistry.registerTileEntity(TileEntityPortal.class, "TransmainaPortal");
	}

	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}

}
