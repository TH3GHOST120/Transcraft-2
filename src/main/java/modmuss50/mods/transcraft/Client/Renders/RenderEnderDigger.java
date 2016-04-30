package modmuss50.mods.transcraft.Client.Renders;

import modmuss50.mods.transcraft.Blocks.TileEntitys.EnderDigger.TileEntiyEnderDigger;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class RenderEnderDigger extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		TileEntiyEnderDigger eb = (TileEntiyEnderDigger) tileentity;
		// y = eb.yCoord;
		// y -= 7;
		x -= 2;
		z -= 1;

		Tessellator tessellator = Tessellator.instance;

		GL11.glDisable(GL11.GL_CULL_FACE);

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16733525);
		tessellator.addVertex(x + 0.5D, y + 0.5D, z + 0.5D);
		tessellator.addVertex(x + eb.xSize + 1.5D, y + 0.5D, z + 0.5D);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16777184);
		tessellator.addVertex(x + 0.5D, y + 0.5D, z + 0.5D);
		tessellator.addVertex(x + 0.5D, y + 0.5D, z + 1.5D + eb.zSize);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16755370);
		tessellator.addVertex(x + 0.5D, y + 0.5D, z + 0.5D);
		tessellator.addVertex(x + 0.5D, y + 0.5D + eb.ySize, z + 0.5D);
		GL11.glColor3f(1.0F, 1.0F, 0.8F);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16777184);
		tessellator.addVertex(x + eb.xSize + 1.5D, y + eb.ySize + 0.5D, z + eb.zSize + 1.5D);
		tessellator.addVertex(x + 0.5D, y + eb.ySize + 0.5D, z + eb.zSize + 1.5D);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16733525);
		tessellator.addVertex(x + eb.xSize + 1.5D, y + eb.ySize + 0.5D, z + eb.zSize + 1.5D);
		tessellator.addVertex(x + eb.xSize + 1.5D, y + eb.ySize + 0.5D, z + 0.5D);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16755370);
		tessellator.addVertex(x + eb.xSize + 1.5D, y + eb.ySize + 0.5D, z + eb.zSize + 1.5D);
		tessellator.addVertex(x + eb.xSize + 1.5D, y + 0.5D, z + eb.zSize + 1.5D);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16733525);
		tessellator.addVertex(x + 0.5D, y + eb.ySize + 0.5D, z + 0.5D);
		tessellator.addVertex(x + eb.xSize + 1.5D, y + eb.ySize + 0.5D, z + 0.5D);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16777184);
		tessellator.addVertex(x + 0.5D, y + 0.5D + eb.ySize, z + 0.5D);
		tessellator.addVertex(x + 0.5D, y + 0.5D + eb.ySize, z + 1.5D + eb.zSize);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16733525);
		tessellator.addVertex(x + eb.xSize + 1.5D, y + 0.5D, z + 0.5D);
		tessellator.addVertex(x + eb.xSize + 1.5D, y + eb.ySize + 0.5D, z + 0.5D);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16777184);
		tessellator.addVertex(x + 0.5D, y + 0.5D, z + 1.5D + eb.zSize);
		tessellator.addVertex(x + 0.5D, y + 0.5D + eb.ySize, z + 1.5D + eb.zSize);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16777184);
		tessellator.addVertex(x + eb.xSize + 1.5D, y + 0.5D, z + eb.zSize + 1.5D);
		tessellator.addVertex(x + 0.5D, y + 0.5D, z + eb.zSize + 1.5D);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.setColorOpaque_I(16733525);
		tessellator.addVertex(x + eb.xSize + 0.5D + 1.0D, y + 0.5D, z + eb.zSize + 0.5D + 1.0D);
		tessellator.addVertex(x + eb.xSize + 0.5D + 1.0D, y + 0.5D, z + 0.5D);
		tessellator.draw();
		GL11.glEnable(2896);
		GL11.glEnable(3553);
	}
}
