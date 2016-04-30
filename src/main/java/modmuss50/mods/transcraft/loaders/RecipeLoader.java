package modmuss50.mods.transcraft.loaders;

import cpw.mods.fml.common.registry.GameRegistry;
import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.Items.TranscraftItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeLoader {

	public static void LoadRecipe() {
		ItemStack GoldIStack = new ItemStack(Items.gold_ingot);
		ItemStack Water = new ItemStack(Items.water_bucket);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticHelmet, 1), "ppp", "p p", "   ", 'p', TranscraftItems.Plastic);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticChest, 1), "p p", "ppp", "ppp", 'p', TranscraftItems.Plastic);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticLegs, 1), "ppp", "p p", "p p", 'p', TranscraftItems.Plastic);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticBoots, 1), "   ", "p p", "p p", 'p', TranscraftItems.Plastic);

		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.ComIronOre, 1), "ii", "ii", 'i', Blocks.iron_ore);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.ComGoldOre, 1), "ii", "ii", 'i', Blocks.gold_ore);

		ItemStack ComTransmutterOre4 = new ItemStack(TranscraftBlocks.ComTransmutterOre, 4, 0);
		ItemStack TransmutterOre1 = new ItemStack(TranscraftBlocks.TranscraftOre, 1, 0);
		GameRegistry.addRecipe(ComTransmutterOre4, "ii", "ii", 'i', TransmutterOre1);

		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.ComOilOre, 1), "ii", "ii", 'i', TranscraftItems.Oil);
		GameRegistry.addRecipe(TransmutterOre1, "i", 'i', TranscraftBlocks.ComTransmutterOre);

		GameRegistry.addRecipe(new ItemStack(Blocks.iron_ore, 4), "i", 'i', TranscraftBlocks.ComIronOre);
		GameRegistry.addRecipe(new ItemStack(Blocks.gold_ore, 4), "i", 'i', TranscraftBlocks.ComGoldOre);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.Oil, 4), "i", 'i', TranscraftBlocks.ComOilOre);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.HotDog, 8), "bbb", "ppp", "bbb", 'b', Items.bread, 'p', Items.cooked_porkchop);

		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.ObsidianLever, 2), "lb ", "   ", "  ", 'l', Blocks.lever, 'b', TranscraftBlocks.BunkerBlock);

		GameRegistry.addRecipe(new ItemStack(Blocks.sponge, 16), "yxy", "xdx", "yxy", 'x', Water, 'y', GoldIStack, 'd', Items.diamond);

		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.BunkerBlock, 8), "opo", "pdp", "opo", 'o', TranscraftItems.HardendPlastic, 'p', TranscraftItems.Plastic, 'd', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.ThinClearGlass, 8), "   ", "ggg", "ggg", 'g', TranscraftBlocks.ClearGlass);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.BunkerStair, 4), "b  ", "bb ", "bbb", 'b', TranscraftBlocks.BunkerBlock);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.BunkerStair, 4), "  b", " bb", "bbb", 'b', TranscraftBlocks.BunkerBlock);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.SmoothBunkerBlock, 4), "bb", "bb", 'b', TranscraftBlocks.BunkerBlock);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.SmoothBunkerStair, 4), "b  ", "bb ", "bbb", 'b', TranscraftBlocks.SmoothBunkerBlock);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.SmoothBunkerStair, 4), "  b", " bb", "bbb", 'b', TranscraftBlocks.SmoothBunkerBlock);

		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.Transcrafter), "ddd", "ece", "ooo", 'e', Items.emerald, 'd', Items.diamond, 'c', Blocks.chest, 'o', Blocks.obsidian);

		ItemStack BlueDye = new ItemStack(Items.dye, 1, 12);
		ItemStack GreenDye = new ItemStack(Items.dye, 1, 2);
		ItemStack OrangeDye = new ItemStack(Items.dye, 1, 14);

		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.BlueLight, 8), "prp", "pbp", "prp", 'r', Items.redstone, 'p', TranscraftItems.Plastic, 'b', BlueDye);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.GreenLight, 8), "prp", "pbp", "prp", 'r', Items.redstone, 'p', TranscraftItems.Plastic, 'b', GreenDye);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.OrangeLight, 8), "prp", "pbp", "prp", 'r', Items.redstone, 'p', TranscraftItems.Plastic, 'b', OrangeDye);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.DarkLight, 8), "prp", "pbp", "prp", 'r', Items.redstone, 'p', TranscraftItems.Plastic, 'b', Blocks.obsidian);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.HardendPlastic, 8), "pop", "ooo", "pop", 'p', TranscraftItems.Plastic, 'o', Blocks.obsidian);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.IronStick, 4), " i ", " s ", " i ", 'i', Items.iron_ingot, 's', Items.stick);
		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.IronTorch, 16), "o", "i", 'i', TranscraftItems.IronStick, 'o', TranscraftItems.Oil);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticSword), " p ", " p ", " i ", 'i', TranscraftItems.IronStick, 'p', TranscraftItems.Plastic);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticPickaxe), "ppp", " i ", " i ", 'i', TranscraftItems.IronStick, 'p', TranscraftItems.Plastic);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticAxe), " pp", " ip", " i ", 'i', TranscraftItems.IronStick, 'p', TranscraftItems.Plastic);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticAxe), "pp ", "pi ", " i ", 'i', TranscraftItems.IronStick, 'p', TranscraftItems.Plastic);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticHoe), "pp ", " i ", " i ", 'i', TranscraftItems.IronStick, 'p', TranscraftItems.Plastic);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticHoe), " pp", " i ", " i ", 'i', TranscraftItems.IronStick, 'p', TranscraftItems.Plastic);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.PlasticShovel), " p ", " i ", " i ", 'i', TranscraftItems.IronStick, 'p', TranscraftItems.Plastic);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.BunkerPick), "bbb", "dod", "qoq", 'b', TranscraftBlocks.BunkerBlock, 'd', Blocks.diamond_block, 'o', TranscraftItems.HardendPlastic, 'q', TranscraftItems.DarkEndershard);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.EnderSword), "ebe", "ebe", "ndn", 'e', TranscraftItems.EnderGem, 'd', Blocks.diamond_block, 'b', TranscraftBlocks.BunkerBlock, 'n', Items.diamond_sword);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.EnderQuartz, 6), "qeq", "qdq", "qeq", 'q', TranscraftItems.DarkEndershard, 'd', Blocks.end_stone, 'e', Items.ender_eye);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.EnderGem), "qdq", "qeq", "qdq", 'q', TranscraftItems.EnderQuartz, 'd', Items.diamond, 'e', Items.ender_eye);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.EnderHelmet, 1), "ppp", "pgp", "   ", 'p', TranscraftItems.EnderGem, 'g', TranscraftBlocks.FancyCrystalGlass);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.EnderChest, 1), "pbp", "ppp", "ppp", 'p', TranscraftItems.EnderGem, 'b', TranscraftBlocks.BunkerBlock);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.EnderLegs, 1), "ppp", "p p", "pep", 'p', TranscraftItems.EnderGem, 'e', Items.ender_eye);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.EnderBoots, 1), "   ", "pep", "pep", 'p', TranscraftItems.EnderGem, 'e', Items.ender_pearl);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.QuadTransmuter), "sbs", "bsb", "sbs", 'b', TranscraftItems.BasicTransmuter, 's', Blocks.stone);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.NanoTransmuter), "qqr", "qqg", "qqr", 'q', TranscraftItems.QuadTransmuter, 'g', Items.glowstone_dust, 'r', Items.redstone);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.Technium), "dcd", "cbc", "dcd", 'c', Blocks.coal_block, 'b', TranscraftItems.NanoTransmuter, 'd', Blocks.diamond_block);

		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.TechniumBlock), "ttt", "ttt", "ttt", 't', TranscraftItems.Technium);

		GameRegistry.addRecipe(new ItemStack(TranscraftItems.TechniumHelmet, 1), "ppp", "p p", "   ", 'p', TranscraftItems.Technium);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.TechniumChestplate, 1), "p p", "ppp", "ppp", 'p', TranscraftItems.Technium);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.TechniumLeggs, 1), "ppp", "p p", "p p", 'p', TranscraftItems.Technium);
		GameRegistry.addRecipe(new ItemStack(TranscraftItems.TechniumBoots, 1), "   ", "p p", "p p", 'p', TranscraftItems.Technium);

		// Smelting Recipes
		GameRegistry.addSmelting(TranscraftBlocks.TranscraftOre, new ItemStack(TranscraftItems.BasicTransmuter), 5.0f);
		GameRegistry.addSmelting(TranscraftItems.Oil, new ItemStack(TranscraftItems.Plastic), 1.3f);
		GameRegistry.addSmelting(TranscraftBlocks.OilOre, new ItemStack(TranscraftItems.Oil), 3.3f);

		GameRegistry.addRecipe(new ItemStack(TranscraftBlocks.ixpGrinder), "qcq", "qdq", "qqq", 'q', TranscraftItems.NanoTransmuter, 'c', Blocks.chest, 'd', Items.nether_star);

		for (int i = 15; i >= 0; i--) {
			GameRegistry.addShapelessRecipe(new ItemStack(TranscraftBlocks.enderQuartzBlock, 1, i), new ItemStack(Blocks.sandstone, 1, 2), new ItemStack(Items.dye, 1, i), new ItemStack(Items.dye, 1, i));
		}

		for (int i = 15; i >= 0; i--) {
			GameRegistry.addShapelessRecipe(new ItemStack(TranscraftBlocks.CutenderQuartz, 1, i), new ItemStack(Blocks.sandstone, 1, 1), new ItemStack(Items.dye, 1, i), new ItemStack(Items.dye, 1, i));
		}

		for (int i = 15; i >= 0; i--) {
			GameRegistry.addShapelessRecipe(new ItemStack(TranscraftBlocks.EnderQuartzBrick, 1, i), new ItemStack(Blocks.brick_block, 1, 0), new ItemStack(Items.dye, 1, i), new ItemStack(Items.dye, 1, i));
		}

		for (int i = 15; i >= 0; i--) {
			GameRegistry.addShapelessRecipe(new ItemStack(TranscraftBlocks.FancyCrystalGlass, 1, i), new ItemStack(TranscraftBlocks.ClearGlass, 1, i), new ItemStack(Items.gold_nugget, 1, 0), new ItemStack(Items.gold_nugget, 1, 0));
		}

		for (int i = 15; i >= 0; i--) {
			GameRegistry.addShapelessRecipe(new ItemStack(TranscraftBlocks.ClearGlass, 1, i), new ItemStack(Blocks.glass, 1, i), new ItemStack(Items.dye, 1, i), new ItemStack(Items.dye, 1, i));
		}

	}

}
