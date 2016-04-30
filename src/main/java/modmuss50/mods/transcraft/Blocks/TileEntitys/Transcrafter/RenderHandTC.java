package modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderHandTC implements IItemRenderer {
	private TranscrafterModel	model;

	public RenderHandTC() {
		model = new TranscrafterModel();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
			case ENTITY:
			case EQUIPPED_FIRST_PERSON:
			case EQUIPPED:
			case INVENTORY:
				return true;
			default:
				return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (helper) {
			case ENTITY_ROTATION:
			case ENTITY_BOBBING:
				return true;
			default:
				return false;
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if (type == type.ENTITY) {
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 8f, 0f, 0f);
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			GL11.glTranslatef(0f, -1.5f, 0f);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("transcraft", "textures/models/TranscrafterModel.png"));
			model.Middle.render(0.0625F);
			model.Top_bit_1.render(0.0625F);
			model.Top_bit_2.render(0.0625F);
			model.Top_bit_3.render(0.0625F);
			model.Top_bit_4.render(0.0625F);
			model.Floaty_part.render(0.0625F);
			GL11.glPopMatrix();
		}
		if (type == type.INVENTORY) {
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPushMatrix();
			GL11.glRotatef(50F, -1000.0F, 1000.0F, -1110.0F);
			GL11.glTranslatef((float) 4.0F, (float) -2.7f, (float) 0.4F);
			GL11.glScalef(13F, 13F, 13F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("transcraft", "textures/models/TranscrafterModel.png"));
			model.Middle.render(0.0625F);
			model.Top_bit_1.render(0.0625F);
			model.Top_bit_2.render(0.0625F);
			model.Top_bit_3.render(0.0625F);
			model.Top_bit_4.render(0.0625F);
			model.Floaty_part.render(0.0625F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
		if (type == type.EQUIPPED_FIRST_PERSON) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef((float) -0.4F, (float) -1.5f, (float) 0.4F);
			GL11.glScalef(1F, 1F, 1F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("transcraft", "textures/models/TranscrafterModel.png"));
			model.Middle.render(0.0625F);
			model.Top_bit_1.render(0.0625F);
			model.Top_bit_2.render(0.0625F);
			model.Top_bit_3.render(0.0625F);
			model.Top_bit_4.render(0.0625F);
			model.Floaty_part.render(0.0625F);
			GL11.glPopMatrix();
		}
		if (type == type.EQUIPPED) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef((float) -0.4F, (float) -1.5f, (float) 0.4F);
			GL11.glScalef(1F, 1F, 1F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("transcraft", "textures/models/TranscrafterModel.png"));
			model.Middle.render(0.0625F);
			model.Top_bit_1.render(0.0625F);
			model.Top_bit_2.render(0.0625F);
			model.Top_bit_3.render(0.0625F);
			model.Top_bit_4.render(0.0625F);
			model.Floaty_part.render(0.0625F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
	}
}
