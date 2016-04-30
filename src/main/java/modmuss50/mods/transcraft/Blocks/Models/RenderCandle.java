package modmuss50.mods.transcraft.Blocks.Models;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Mark on 18/02/14.
 */
public class RenderCandle extends TileEntitySpecialRenderer {

	private ModleCandle	model;

	public RenderCandle() {
		this.model = new ModleCandle();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5f, (float) z + 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.3F, 0.3F, 0.3F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("transcraft", "textures/models/Candle.png"));

		this.model.Shape1.render(0.0625F);
		this.model.Shape2.render(0.0625F);
		this.model.Shape3.render(0.0625F);
		this.model.Shape4.render(0.0625F);
		this.model.Shape5.render(0.0625F);
		this.model.Shape6.render(0.0625F);
		this.model.Shape7.render(0.0625F);
		this.model.Shape8.render(0.0625F);
		this.model.Shape9.render(0.0625F);
		this.model.Shape10.render(0.0625F);
		this.model.Shape11.render(0.0625F);
		this.model.Shape12.render(0.0625F);
		this.model.Shape13.render(0.0625F);
		this.model.Shape14.render(0.0625F);
		this.model.Shape15.render(0.0625F);
		this.model.Shape16.render(0.0625F);
		this.model.Shape17.render(0.0625F);
		this.model.Shape18.render(0.0625F);
		this.model.Shape19.render(0.0625F);
		this.model.Shape20.render(0.0625F);
		this.model.Shape21.render(0.0625F);
		this.model.Shape22.render(0.0625F);
		this.model.Shape23.render(0.0625F);
		this.model.Shape25.render(0.0625F);
		this.model.Shape26.render(0.0625F);
		this.model.Shape27.render(0.0625F);
		this.model.Shape28.render(0.0625F);
		GL11.glPopMatrix();

	}
}
