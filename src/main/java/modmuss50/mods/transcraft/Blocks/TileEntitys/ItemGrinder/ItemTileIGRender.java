package modmuss50.mods.transcraft.Blocks.TileEntitys.ItemGrinder;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelChest;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemTileIGRender implements IItemRenderer {

	private ModelChest	chest;

	public ItemTileIGRender() {
		chest = new ModelChest();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		float scale = 1.08f;

		switch (type) {
			case ENTITY: {
				renderChest(0f, 0f, 0f, scale);
				return;
			}

			case EQUIPPED: {
				renderChest(2f, 1.5f, 0.8f, scale);
				return;
			}

			case INVENTORY: {
				renderChest(0f, 0.15f, 0f, scale);
				return;
			}

			default:
				return;
		}
	}

	private void renderChest(float x, float y, float z, float scale) {
		GL11.glPushMatrix();
		// Disable Lighting Calculations
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef(x, y, z);
		GL11.glScalef(scale, scale, scale);
		GL11.glRotatef(180f, 0f, 0f, 0f);
		ResourceLocation test = new ResourceLocation("transcraft", "textures/models/ixp.png");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
		chest.renderAll();
		// Re-enable Lighting Calculations
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}
}
