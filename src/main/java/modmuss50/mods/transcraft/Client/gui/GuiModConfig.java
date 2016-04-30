package modmuss50.mods.transcraft.Client.gui;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class GuiModConfig extends GuiScreen {
	private GuiScreen	parent;

	public GuiModConfig(GuiScreen parent) {
		this.parent = parent;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(1, this.width / 2 - 75, this.height - 38, I18n.format("gui.done")));
	}

	@Override
	protected void actionPerformed(GuiButton p_73875_1_) {
		if (p_73875_1_.enabled && p_73875_1_.id == 1) {
			FMLClientHandler.instance().showGuiScreen(parent);
		}
	}

	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRendererObj, "Transcraft test config screen", this.width / 2, 40, 0xFFFFFF);
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}
}
