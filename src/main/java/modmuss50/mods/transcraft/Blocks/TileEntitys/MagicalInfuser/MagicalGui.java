package modmuss50.mods.transcraft.Blocks.TileEntitys.MagicalInfuser;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Mark on 18/04/14.
 */
public class MagicalGui extends GuiContainer {
	private static final ResourceLocation	field_110421_t	= new ResourceLocation("transcraft", "textures/gui/MagicalInfuser.png");
	private IInventory						upperChestInventory;
	private IInventory						lowerChestInventory;

	private float							xSize_lo;
	private float							ySize_lo;

	/**
	 * window height is calculated with this values, the more rows, the heigher
	 */
	private int								inventoryRows;
	private MagicalTile						te;

	public MagicalGui(InventoryPlayer player, MagicalTile tileEntity) {
		super(new MagicalContainer(player, tileEntity));
		this.xSize = 256;
		this.ySize = 219;
		this.te = tileEntity;
		this.lowerChestInventory = player;
		this.upperChestInventory = te;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of
	 * the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRendererObj.drawString("Magical Gui", 8, 8, 4210752);
		this.fontRendererObj.drawString("Inventory", 9, this.ySize - 100, 4210752);

		this.mc.getTextureManager().bindTexture(field_110421_t);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		super.initGui();

	}

	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);
		this.xSize_lo = (float) par1;
		this.ySize_lo = (float) par2;
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(field_110421_t);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

	}

}
