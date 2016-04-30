package modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTC extends TileEntitySpecialRenderer {

	private TranscrafterModel				model;
	private float							rotation	= 0.0f;
	private static final ResourceLocation	textures_2	= new ResourceLocation("transcraft:textures/models/TranscrafterModel.png");

	public RenderTC() {
		this.model = new TranscrafterModel();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5f, (float) z + 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("transcraft", "textures/models/TranscrafterModel.png"));
		this.model.Bottom.render(0.0625F);
		if (rotation == 10F) {
			rotation = 0.0f;
		}
		else {
			rotation = rotation + 0.10f;
		}

		// this.model.setRotation(this.model.Floaty_part, -0.7853982F, rotation,
		// -0.7853982F);
		this.model.Floaty_part.render(0.0525F);
		this.model.Middle.render(0.0625F);
		this.model.Top_bit_1.render(0.0625F);
		this.model.Top_bit_2.render(0.0625F);
		this.model.Top_bit_3.render(0.0625F);
		this.model.Top_bit_4.render(0.0625F);
		GL11.glPopMatrix();

	}
}
