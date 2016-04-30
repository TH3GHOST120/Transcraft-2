package modmuss50.mods.transcraft.Client.gui;

import modmuss50.mods.transcraft.Blocks.TileEntitys.TileEntiyQuartzBlock;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class GuiRGBBlocks extends GuiScreen {

	private static final ResourceLocation	lightPeripheralTexture	= new ResourceLocation("transcraft:textures/gui/RGBGui.png");
	private GuiTextField					redValue, greenValue, blueValue;

	private TileEntiyQuartzBlock			te;

	public GuiRGBBlocks(TileEntiyQuartzBlock te) {
		this.te = te;
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		RenderManager.instance.renderEngine.bindTexture(lightPeripheralTexture);
		int k = (this.width - 256) / 2;
		int b0 = (this.height - 128) / 2;
		this.drawTexturedModalRect(k, b0, 0, 0, 256, 128);

		int x = (k + 128) - (this.fontRendererObj.getStringWidth(I18n.format("tile.RGBBlock.name")) / 2);

		this.fontRendererObj.drawString(I18n.format("tile.RGBBlock.name"), x, 70, Color.gray.getRGB());

		redValue.drawTextBox();
		greenValue.drawTextBox();
		blueValue.drawTextBox();
	}

	@Override
	public void initGui() {
		redValue = new GuiTextField(this.fontRendererObj, ((this.width - 256) / 2) + 128 - 100, 100, 50, 20);
		greenValue = new GuiTextField(this.fontRendererObj, ((this.width - 256) / 2) + 128 - 25, 100, 50, 20);
		blueValue = new GuiTextField(this.fontRendererObj, ((this.width - 256) / 2) + 128 + 50, 100, 50, 20);

		redValue.setMaxStringLength(32767);
		greenValue.setMaxStringLength(32767);
		blueValue.setMaxStringLength(32767);

		redValue.setText("" + te.red);
		greenValue.setText("" + te.green);
		blueValue.setText("" + te.blue);
	}

	@Override
	public void mouseClicked(int par1, int par2, int par3) {
		this.redValue.mouseClicked(par1, par2, par3);
		this.greenValue.mouseClicked(par1, par2, par3);
		this.blueValue.mouseClicked(par1, par2, par3);
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		if (redValue.textboxKeyTyped(par1, par2)) {

		}
		else
			if (greenValue.textboxKeyTyped(par1, par2)) {

			}
			else
				if (blueValue.textboxKeyTyped(par1, par2)) {

				}
				else {
					super.keyTyped(par1, par2);
				}
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();

		te.red = Integer.parseInt("0" + redValue.getText());
		te.green = Integer.parseInt("0" + greenValue.getText());
		te.blue = Integer.parseInt("0" + blueValue.getText());
		te.updateBlock();

	}
}
