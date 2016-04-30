package modmuss50.mods.transcraft.Items.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modmuss50.mods.transcraft.Client.Transpedia.TranspediaEntry;
import modmuss50.mods.transcraft.Client.Transpedia.TranspediaRegistry;
import modmuss50.mods.transcraft.Client.gui.RenderItemUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TranspediaGui extends GuiContainer {
	private ResourceLocation	field_110421_t	= new ResourceLocation("transcraft", "textures/gui/Transpedia/Transpedia_z.png");

	private ResourceLocation	imageloc;

	private float				xSize_lo;
	private float				ySize_lo;

	private int					pageNumber		= 0;
	public int					numberofpages	= 4;

	protected static RenderItem	itemRenderer	= new RenderItem();

	public TranspediaGui() {
		super(new ContainerTranspedia());
		this.xSize = 256;
		this.ySize = 256;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of
	 * the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		super.initGui();

		this.buttonList.add(new GuiButton(1, this.width / 2 - 123, height / 2 + 100, 20, 20, "<"));
		this.buttonList.add(new GuiButton(0, this.width / 2 + 48, height / 2 + 100, 20, 20, ">"));

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
		field_110421_t = new ResourceLocation("transcraft", "textures/gui/Transpedia/Transpedia_back.png");
		this.mc.renderEngine.bindTexture(field_110421_t);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

		// if (pageNumber != 0) {
		// drawPlayerModel(k + 162, l + 80, 30, (float) (k + 162)
		// - this.xSize_lo, (float) (l + 60 - 30) - this.ySize_lo,
		// this.mc.thePlayer);
		// }

		this.drawText(par1, par2, par3);
	}

	/**
	 * This renders the player model in standard inventory position
	 */
	public static void drawPlayerModel(int par0, int par1, int par2, float par3, float par4, EntityLivingBase par5EntityLivingBase) {
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) par0, (float) par1, 50.0F);
		GL11.glScalef((float) (-par2), (float) par2, (float) par2);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		float f2 = par5EntityLivingBase.renderYawOffset;
		float f3 = par5EntityLivingBase.rotationYaw;
		float f4 = par5EntityLivingBase.rotationPitch;
		float f5 = par5EntityLivingBase.prevRotationYawHead;
		float f6 = par5EntityLivingBase.rotationYawHead;
		GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-((float) Math.atan((double) (par4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
		par5EntityLivingBase.renderYawOffset = (float) Math.atan((double) (par3 / 40.0F)) * 20.0F;
		par5EntityLivingBase.rotationYaw = (float) Math.atan((double) (par3 / 40.0F)) * 40.0F;
		par5EntityLivingBase.rotationPitch = -((float) Math.atan((double) (par4 / 40.0F))) * 20.0F;
		par5EntityLivingBase.rotationYawHead = par5EntityLivingBase.rotationYaw;
		par5EntityLivingBase.prevRotationYawHead = par5EntityLivingBase.rotationYaw;
		GL11.glTranslatef(0.0F, par5EntityLivingBase.yOffset, 0.0F);
		RenderManager.instance.playerViewY = 180.0F;
		RenderManager.instance.renderEntityWithPosYaw(par5EntityLivingBase, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
		par5EntityLivingBase.renderYawOffset = f2;
		par5EntityLivingBase.rotationYaw = f3;
		par5EntityLivingBase.rotationPitch = f4;
		par5EntityLivingBase.prevRotationYawHead = f5;
		par5EntityLivingBase.rotationYawHead = f6;
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}

	public void drawText(float par1, int par2, int par3) {
		TranspediaEntry entry = TranspediaRegistry.getPage(pageNumber);

		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;

		if (entry != null) {
			this.drawCustomString(this.fontRendererObj, entry.getTitle(), k + 100, l + 5, 4210752);

			this.drawCustomString(this.fontRendererObj, entry.getL0(), k + 100, l + 125, 4210752);
			this.drawCustomString(this.fontRendererObj, entry.getL1(), k + 100, l + 135, 4210752);
			this.drawCustomString(this.fontRendererObj, entry.getL2(), k + 100, l + 145, 4210752);
			this.drawCustomString(this.fontRendererObj, entry.getL3(), k + 100, l + 155, 4210752);
			this.drawCustomString(this.fontRendererObj, entry.getL4(), k + 100, l + 165, 4210752);
			this.drawCustomString(this.fontRendererObj, entry.getL5(), k + 100, l + 175, 4210752);
			this.drawCustomString(this.fontRendererObj, entry.getL6(), k + 100, l + 185, 4210752);
			this.drawCustomString(this.fontRendererObj, entry.getL7(), k + 100, l + 195, 4210752);
			this.drawCustomString(this.fontRendererObj, entry.getL8(), k + 100, l + 205, 4210752);
			this.drawCustomString(this.fontRendererObj, entry.getL9(), k + 100, l + 215, 4210752);
			this.drawCustomString(this.fontRendererObj, entry.getL10(), k + 100, l + 225, 4210752);

			this.drawItemStack(entry.getImage(), k + 30, l + 30, "ItemGrinder");
		}

	}

	private void drawItemStack(ItemStack par1ItemStack, int par2, int par3, String par4Str) {
		RenderItemUtils.renderItemAndEffectIntoGUI(Minecraft.getMinecraft().fontRenderer, Minecraft.getMinecraft().renderEngine, par1ItemStack, par2, par3, 1000F);

	}

	public void drawCustomString(FontRenderer par1FontRenderer, String par2Str, int par3, int par4, int par5) {
		drawStringWithoutShadow(par1FontRenderer, par2Str, par3 - par1FontRenderer.getStringWidth(par2Str) / 2, par4, par5);
	}

	/**
	 * Draws the specified string without a shadow.
	 */
	public int drawStringWithoutShadow(FontRenderer par1FontRenderer, String par1Str, int par2, int par3, int par4) {
		return par1FontRenderer.drawString(par1Str, par2, par3, par4, false);
	}

	public void actionPerformed(GuiButton par0Button) {
		/** Back **/
		if (par0Button.id == 1) {
			if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				pageNumber = 0;
			}
			else {

				if (pageNumber != 0) {
					pageNumber -= 1;
				}

			}

		}

		/** Next **/
		if (par0Button.id == 0) {

			if (pageNumber != TranspediaRegistry.pages.size()) {
				pageNumber += 1;
			}
		}
	}
}
