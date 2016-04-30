package modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter;

import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.Items.TranscraftItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipesTC {

	/**
	 * The static instance of this class
	 */
	public static final RecipesTC	instance	= new RecipesTC();

	/**
	 * A list of all the recipes added
	 */
	public List						recipes		= new ArrayList();

	/**
	 * Returns the static instance of this class
	 */
	public static final RecipesTC getInstance() {
		return instance;
	}

	int	amountOfRecipes	= 0;

	public RecipesTC() {
		addVanillaRecipes();
		System.out.println("[TRANSCRAFT] Added " + Integer.toString(amountOfRecipes) + " recipe to the transcrafter!");
	}

	public ShapedRecipes addRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		amountOfRecipes += 1;

		if (par2ArrayOfObj[i] instanceof String[]) {
			String[] astring = ((String[]) par2ArrayOfObj[i++]);

			for (int l = 0; l < astring.length; ++l) {
				String s1 = astring[l];
				++k;
				j = s1.length();
				s = s + s1;
			}
		}
		else {
			while (par2ArrayOfObj[i] instanceof String) {
				String s2 = (String) par2ArrayOfObj[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}

		HashMap hashmap;

		for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2) {
			Character character = (Character) par2ArrayOfObj[i];
			ItemStack itemstack1 = null;

			if (par2ArrayOfObj[i + 1] instanceof Item) {
				itemstack1 = new ItemStack((Item) par2ArrayOfObj[i + 1]);
			}
			else
				if (par2ArrayOfObj[i + 1] instanceof Block) {
					itemstack1 = new ItemStack((Block) par2ArrayOfObj[i + 1], 1, 32767);
				}
				else
					if (par2ArrayOfObj[i + 1] instanceof ItemStack) {
						itemstack1 = (ItemStack) par2ArrayOfObj[i + 1];
					}

			hashmap.put(character, itemstack1);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1) {
			char c0 = s.charAt(i1);

			if (hashmap.containsKey(Character.valueOf(c0))) {
				aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c0))).copy();
			}
			else {
				aitemstack[i1] = null;
			}
		}

		ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, par1ItemStack);
		this.recipes.add(shapedrecipes);
		return shapedrecipes;
	}

	public void addShapelessRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		ArrayList arraylist = new ArrayList();
		Object[] aobject = par2ArrayOfObj;
		int i = par2ArrayOfObj.length;
		amountOfRecipes += 1;
		for (int j = 0; j < i; ++j) {
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack) {
				arraylist.add(((ItemStack) object1).copy());
			}
			else
				if (object1 instanceof Item) {
					arraylist.add(new ItemStack((Item) object1));
				}
				else {
					if (!(object1 instanceof Block)) {
						throw new RuntimeException("Invalid shapeless recipy!");
					}

					arraylist.add(new ItemStack((Block) object1));
				}
		}

		this.recipes.add(new ShapelessRecipes(par1ItemStack, arraylist));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World) {
		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j) {
			ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

			if (itemstack2 != null) {
				if (i == 0) {
					itemstack = itemstack2;
				}

				if (i == 1) {
					itemstack1 = itemstack2;
				}

				++i;
			}
		}

		if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable()) {
			Item item = itemstack.getItem();
			int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
			int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
			int l = j1 + k + item.getMaxDamage() * 5 / 100;
			int i1 = item.getMaxDamage() - l;

			if (i1 < 0) {
				i1 = 0;
			}

			return new ItemStack(itemstack.getItem(), 1, i1);
		}
		else {
			for (j = 0; j < this.recipes.size(); ++j) {
				IRecipe irecipe = (IRecipe) this.recipes.get(j);

				if (irecipe.matches(par1InventoryCrafting, par2World)) {
					return irecipe.getCraftingResult(par1InventoryCrafting);
				}
			}

			return null;
		}
	}

	/**
	 * returns the List<> of all recipes
	 */
	public List getRecipeList() {
		return this.recipes;
	}

	public void addVanillaRecipes() {
		registerRecipe(Blocks.stone, 0, 5, 20, 64);

		registerRecipe(Blocks.dirt, 0, 10, 40, 64);

		registerRecipe(Blocks.dirt, 2, 10, 40, 64);

		registerRecipe(Blocks.grass, 0, 10, 40, 64);

		registerRecipe(Blocks.cobblestone, 0, 5, 20, 64);

		for (int i = 0; i < 5; i++) {
			registerRecipe(Blocks.planks, i, 2, 8, 16);
		}

		registerRecipe(Blocks.sand, 0, 10, 40, 64);

		registerRecipe(Blocks.sand, 1, 10, 40, 64);

		registerRecipe(Blocks.gravel, 0, 10, 40, 64);

		for (int i = 0; i < 3; i++) {
			registerRecipe(Blocks.log, i, 0, 8, 16);
		}

		for (int i = 0; i < 2; i++) {
			registerRecipe(Blocks.log2, i, 0, 8, 16);
		}

		registerRecipe(Blocks.glass, 1, 0, 20, 32);

		for (int i = 0; i < 2; i++) {
			registerRecipe(Blocks.sandstone, i, 0, 16, 32);
		}

		for (int i = 0; i < 15; i++) {
			registerRecipe(Blocks.wool, i, 0, 8, 16);
		}

		registerRecipe(Blocks.obsidian, 0, 0, 4, 8);

		registerRecipe(Blocks.netherrack, 1, 10, 40, 64);

		registerRecipe(Blocks.soul_sand, 1, 5, 20, 32);

		for (int i = 0; i < 15; i++) {
			registerRecipe(Blocks.stained_glass, i, 0, 20, 32);
		}

		for (int i = 0; i < 15; i++) {
			registerRecipe(Blocks.stained_glass_pane, i, 0, 20, 32);
		}

		registerRecipe(Blocks.glass_pane, 0, 0, 20, 32);

		for (int i = 0; i < 15; i++) {
			registerRecipe(Blocks.stained_hardened_clay, i, 0, 20, 16);
		}

		registerRecipe(Blocks.hardened_clay, 0, 0, 20, 16);

		for (int i = 0; i < 15; i++) {
			registerRecipe(Blocks.carpet, i, 0, 8, 16);
		}

		registerRecipe(Items.redstone, 0, 0, 20, 32);

		registerRecipe(Items.slime_ball, 0, 0, 20, 16);

		registerRecipe(Items.ender_pearl, 0, 0, 0, 4);

		registerRecipe(Items.ghast_tear, 0, 0, 0, 4);

		registerRecipe(Items.coal, 0, 4, 16, 32);

		registerRecipe(Items.diamond, 0, 0, 0, 2);

		registerRecipe(Items.emerald, 0, 0, 0, 2);

		registerRecipe(Items.iron_ingot, 0, 4, 16, 32);

		registerRecipe(Items.gold_ingot, 0, 4, 16, 32);

		registerRecipe(Items.flint, 0, 4, 16, 32);

		registerRecipe(Items.quartz, 0, 4, 16, 32);

		for (int i = 0; i < 15; i++) {
			registerRecipe(TranscraftBlocks.CutenderQuartz, i, 2, 8, 16);
		}

		for (int i = 0; i < 15; i++) {
			registerRecipe(TranscraftBlocks.EnderQuartzBigBrick, i, 2, 8, 16);
		}

		for (int i = 0; i < 15; i++) {
			registerRecipe(TranscraftBlocks.EnderQuartzBrick, i, 2, 8, 16);
		}

		for (int i = 0; i < 15; i++) {
			registerRecipe(TranscraftBlocks.enderQuartzBlock, i, 2, 8, 16);
		}

		for (int i = 0; i < 15; i++) {
			registerRecipe(TranscraftBlocks.FancyCrystalGlass, i, 2, 8, 16);
		}

		for (int i = 0; i < 15; i++) {
			registerRecipe(TranscraftBlocks.ClearGlass, i, 2, 8, 16);
		}

		registerRecipe(TranscraftItems.Oil, 0, 2, 8, 16);

	}

	public void registerRecipe(Item item, int meta, int basic, int quad, int nano) {
		if (basic != 0) {
			ItemStack Stack = new ItemStack(item, basic, meta);
			ItemStack input = new ItemStack(item, 1, meta);
			addRecipe(Stack, "   ", "tbt", "   ", 't', TranscraftItems.BasicTransmuter, 'b', input);
		}

		if (quad != 0) {
			ItemStack Stack = new ItemStack(item, quad, meta);
			ItemStack input = new ItemStack(item, 1, meta);
			addRecipe(Stack, "   ", "tbt", "   ", 't', TranscraftItems.QuadTransmuter, 'b', input);
		}

		if (nano != 0) {
			ItemStack Stack = new ItemStack(item, nano, meta);
			ItemStack input = new ItemStack(item, 1, meta);
			addRecipe(Stack, "   ", "tbt", "   ", 't', TranscraftItems.NanoTransmuter, 'b', input);
		}
	}

	public void registerRecipe(Block item, int meta, int basic, int quad, int nano) {
		if (basic != 0) {
			ItemStack Stack = new ItemStack(item, basic, meta);
			ItemStack input = new ItemStack(item, 1, meta);
			addRecipe(Stack, "   ", "tbt", "   ", 't', TranscraftItems.BasicTransmuter, 'b', input);
		}

		if (quad != 0) {
			ItemStack Stack = new ItemStack(item, quad, meta);
			ItemStack input = new ItemStack(item, 1, meta);
			addRecipe(Stack, "   ", "tbt", "   ", 't', TranscraftItems.QuadTransmuter, 'b', input);
		}

		if (nano != 0) {
			ItemStack Stack = new ItemStack(item, nano, meta);
			ItemStack input = new ItemStack(item, 1, meta);
			addRecipe(Stack, "   ", "tbt", "   ", 't', TranscraftItems.NanoTransmuter, 'b', input);
		}
	}
}
