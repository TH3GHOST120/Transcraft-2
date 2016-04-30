package modmuss50.mods.transcraft.addons.nei;

import codechicken.core.ReflectionManager;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.DefaultOverlayRenderer;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.recipe.RecipeInfo;
import codechicken.nei.recipe.TemplateRecipeHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter.GuiTC;
import modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter.RecipesTC;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TranscraftNEI extends TemplateRecipeHandler {
	public class CachedShapedRecipe extends CachedRecipe {
		public ArrayList<PositionedStack>	ingredients;
		public PositionedStack				result;

		@SideOnly(Side.CLIENT)
		public CachedShapedRecipe(int width, int height, Object[] items, ItemStack out) {
			result = new PositionedStack(out, 119, 24);
			ingredients = new ArrayList<PositionedStack>();
			setIngredients(width, height, items);
		}

		@SideOnly(Side.CLIENT)
		public CachedShapedRecipe(ShapedRecipes recipe) {
			this(recipe.recipeWidth, recipe.recipeHeight, recipe.recipeItems, recipe.getRecipeOutput());
		}

		@SideOnly(Side.CLIENT)
		/**
		 * @param width
		 * @param height
		 * @param items an ItemStack[] or ItemStack[][]
		 */
		public void setIngredients(int width, int height, Object[] items) {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					if (items[y * width + x] == null)
						continue;

					PositionedStack stack = new PositionedStack(items[y * width + x], 25 + x * 18, 6 + y * 18, false);
					stack.setMaxSize(1);
					ingredients.add(stack);
				}
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 20, ingredients);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public PositionedStack getResult() {
			return result;
		}

		@SideOnly(Side.CLIENT)
		public void computeVisuals() {
			for (PositionedStack p : ingredients)
				p.generatePermutations();

			result.generatePermutations();
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(84, 23, 24, 18), "crafting"));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Class<? extends GuiContainer> getGuiClass() {
		return GuiTC.class;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public String getRecipeName() {
		return NEIClientUtils.translate("Transcrafter");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("crafting") && getClass() == TranscraftNEI.class) {
			List<IRecipe> allrecipes = RecipesTC.getInstance().getRecipeList();
			for (IRecipe irecipe : allrecipes) {
				CachedShapedRecipe recipe = null;
				if (irecipe instanceof ShapedRecipes)
					recipe = new CachedShapedRecipe((ShapedRecipes) irecipe);
				else
					if (irecipe instanceof ShapedOreRecipe)
						recipe = forgeShapedRecipe((ShapedOreRecipe) irecipe);

				if (recipe == null)
					continue;

				recipe.computeVisuals();
				arecipes.add(recipe);
			}
		}
		else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void loadCraftingRecipes(ItemStack result) {
		List<IRecipe> allrecipes = RecipesTC.getInstance().getRecipeList();
		for (IRecipe irecipe : allrecipes) {
			if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) {
				CachedShapedRecipe recipe = null;
				if (irecipe instanceof ShapedRecipes)
					recipe = new CachedShapedRecipe((ShapedRecipes) irecipe);
				else
					if (irecipe instanceof ShapedOreRecipe)
						recipe = forgeShapedRecipe((ShapedOreRecipe) irecipe);

				if (recipe == null)
					continue;

				recipe.computeVisuals();
				arecipes.add(recipe);
			}
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		List<IRecipe> allrecipes = RecipesTC.getInstance().getRecipeList();
		for (IRecipe irecipe : allrecipes) {
			CachedShapedRecipe recipe = null;
			if (irecipe instanceof ShapedRecipes)
				recipe = new CachedShapedRecipe((ShapedRecipes) irecipe);
			else
				if (irecipe instanceof ShapedOreRecipe)
					recipe = forgeShapedRecipe((ShapedOreRecipe) irecipe);

			if (recipe == null || !recipe.contains(recipe.ingredients, ingredient))
				continue;

			recipe.computeVisuals();
			if (recipe.contains(recipe.ingredients, ingredient)) {
				recipe.setIngredientPermutation(recipe.ingredients, ingredient);
				arecipes.add(recipe);
			}
		}
	}

	public CachedShapedRecipe forgeShapedRecipe(ShapedOreRecipe recipe) {
		int width;
		int height;
		Object[] items;
		try {
			width = ReflectionManager.getField(ShapedOreRecipe.class, Integer.class, recipe, 4);
			height = ReflectionManager.getField(ShapedOreRecipe.class, Integer.class, recipe, 5);
			items = ReflectionManager.getField(ShapedOreRecipe.class, Object[].class, recipe, 3);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		for (int i = 0; i < items.length; i++) {
			if (items[i] instanceof List && ((List<?>) items[i]).isEmpty())// ore
				// handler,
				// no
				// ores
				return null;
		}

		return new CachedShapedRecipe(width, height, items, recipe.getRecipeOutput());
	}

	@Override
	public String getGuiTexture() {
		return "transcraft:textures/gui/Transcrafter.png";
	}

	@Override
	public String getOverlayIdentifier() {
		return "crafting";
	}

	@Override
	public boolean hasOverlay(GuiContainer gui, Container container, int recipe) {
		return super.hasOverlay(gui, container, recipe) || isRecipe2x2(recipe) && RecipeInfo.hasDefaultOverlay(gui, "crafting2x2");
	}

	@Override
	public IRecipeOverlayRenderer getOverlayRenderer(GuiContainer gui, int recipe) {
		IRecipeOverlayRenderer renderer = super.getOverlayRenderer(gui, recipe);
		if (renderer != null)
			return renderer;

		IStackPositioner positioner = RecipeInfo.getStackPositioner(gui, "crafting2x2");
		if (positioner == null)
			return null;
		return new DefaultOverlayRenderer(getIngredientStacks(recipe), positioner);
	}

	@Override
	public IOverlayHandler getOverlayHandler(GuiContainer gui, int recipe) {
		IOverlayHandler handler = super.getOverlayHandler(gui, recipe);
		if (handler != null)
			return handler;

		return RecipeInfo.getOverlayHandler(gui, "crafting2x2");
	}

	public boolean isRecipe2x2(int recipe) {
		for (PositionedStack stack : getIngredientStacks(recipe))
			if (stack.relx > 43 || stack.rely > 24)
				return false;

		return true;
	}
}
