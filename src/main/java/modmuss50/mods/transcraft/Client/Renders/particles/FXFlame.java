package modmuss50.mods.transcraft.Client.Renders.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class FXFlame extends EntityFX {

	public static final ResourceLocation	particles	= new ResourceLocation("transcraft", "textures/particles/particles.png");
	public int								multiplier	= 2;
	public boolean							shrink		= true;
	public int								particle	= 0;
	public boolean							tinkle		= true;
	public int								blendmode	= 1;

	public FXFlame(World world, double x, double y, double z, float scale, float r, float g, float b, int multiplier) {
		super(world, x, y, z, 0.0D, 0.0D, 0.0D);
		if (r == 0.0F)
			r = 1.0F;
		this.particle = 3;
		this.particleRed = r;
		this.particleGreen = g;
		this.particleBlue = b;
		this.particleGravity = 0.0F;
		this.motionX = (this.motionY = this.motionZ = 0.0D);
		this.particleScale *= scale;
		this.particleMaxAge = (2 * multiplier);
		this.multiplier = multiplier;
		this.noClip = false;
	}

	public FXFlame(World world, double x, double y, double z, float scale, int type, int multiplier) {
		this(world, x, y, z, scale, 0.0F, 0.0F, 0.0F, multiplier);

		switch (type) {
			case 0:
				this.particleRed = (0.75F + world.rand.nextFloat() * 0.25F);
				this.particleGreen = (0.25F + world.rand.nextFloat() * 0.25F);
				this.particleBlue = (0.75F + world.rand.nextFloat() * 0.25F);
				break;
			case 1:
				this.particleRed = (0.5F + world.rand.nextFloat() * 0.3F);
				this.particleGreen = (0.5F + world.rand.nextFloat() * 0.3F);
				this.particleBlue = 0.2F;
				break;
			case 2:
				this.particleRed = 0.2F;
				this.particleGreen = 0.2F;
				this.particleBlue = (0.7F + world.rand.nextFloat() * 0.3F);
				break;
			case 3:
				this.particleRed = 0.2F;
				this.particleGreen = (0.7F + world.rand.nextFloat() * 0.3F);
				this.particleBlue = 0.2F;
				break;
			case 4:
				this.particleRed = (0.7F + world.rand.nextFloat() * 0.3F);
				this.particleGreen = 0.2F;
				this.particleBlue = 0.2F;
				break;
			case 5:
				this.blendmode = 771;
				this.particleRed = (world.rand.nextFloat() * 0.1F);
				this.particleGreen = (world.rand.nextFloat() * 0.1F);
				this.particleBlue = (world.rand.nextFloat() * 0.1F);
				break;
			case 6:
				this.particleRed = (0.8F + world.rand.nextFloat() * 0.2F);
				this.particleGreen = (0.8F + world.rand.nextFloat() * 0.2F);
				this.particleBlue = (0.8F + world.rand.nextFloat() * 0.2F);
				break;
			case 7:
				this.particleRed = 0.2F;
				this.particleGreen = (0.5F + world.rand.nextFloat() * 0.3F);
				this.particleBlue = (0.6F + world.rand.nextFloat() * 0.3F);
		}
	}

	public FXFlame(World world, double d, double d1, double d2, double x, double y, double z, float f, int type, int m) {
		this(world, d, d1, d2, f, type, m);

		double dx = x - this.posX;
		double dy = y - this.posY;
		double dz = z - this.posZ;

		this.motionX = (dx / this.particleMaxAge);
		this.motionY = (dy / this.particleMaxAge);
		this.motionZ = (dz / this.particleMaxAge);
	}

	public void renderParticle(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5) {
		tessellator.draw();
		GL11.glPushMatrix();

		GL11.glDepthMask(false);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, this.blendmode);
		Minecraft.getMinecraft().renderEngine.bindTexture(particles);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
		int part = this.particle + this.particleAge / this.multiplier;

		float var8 = part % 8 / 8.0F;
		float var9 = var8 + 0.124875F;
		float var10 = part / 8 / 8.0F;
		float var11 = var10 + 0.124875F;
		float var12 = 0.1F * this.particleScale * ((this.particleMaxAge - this.particleAge + 1) / this.particleMaxAge);
		float var13 = (float) (this.prevPosX + (this.posX - this.prevPosX) * f - EntityFX.interpPosX);
		float var14 = (float) (this.prevPosY + (this.posY - this.prevPosY) * f - EntityFX.interpPosY);
		float var15 = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * f - EntityFX.interpPosZ);
		float var16 = 1.0F;

		tessellator.startDrawingQuads();
		tessellator.setBrightness(240);

		tessellator.setColorRGBA_F(this.particleRed * var16, this.particleGreen * var16, this.particleBlue * var16, 1.0F);
		tessellator.addVertexWithUV(var13 - f1 * var12 - f4 * var12, var14 - f2 * var12, var15 - f3 * var12 - f5 * var12, var9, var11);
		tessellator.addVertexWithUV(var13 - f1 * var12 + f4 * var12, var14 + f2 * var12, var15 - f3 * var12 + f5 * var12, var9, var10);
		tessellator.addVertexWithUV(var13 + f1 * var12 + f4 * var12, var14 + f2 * var12, var15 + f3 * var12 + f5 * var12, var8, var10);
		tessellator.addVertexWithUV(var13 + f1 * var12 - f4 * var12, var14 - f2 * var12, var15 + f3 * var12 - f5 * var12, var8, var11);

		tessellator.draw();

		GL11.glDisable(3042);
		GL11.glDepthMask(true);

		GL11.glPopMatrix();
		GL11.glBindTexture(3553, 0);
		tessellator.startDrawingQuads();
	}

	public void onUpdate() {
		EntityPlayer renderentity = Minecraft.getMinecraft().thePlayer;
		int visibleDistance = 50;
		if ((!Minecraft.getMinecraft().gameSettings.fancyGraphics))
			visibleDistance = 25;
		if (renderentity.getDistance(this.posX, this.posY, this.posZ) > visibleDistance)
			setDead();

		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if ((this.particleAge == 0) && (this.tinkle) && (this.worldObj.rand.nextInt(10) == 0)) {
			this.worldObj.playSoundAtEntity(this, "random.orb", 0.02F, 0.7F * ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.6F + 2.0F));
		}
		if (this.particleAge++ >= this.particleMaxAge) {
			setDead();
		}

		this.motionY -= 0.04D * this.particleGravity;
		// moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;
		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}
	}

	public void setGravity(float value) {
		this.particleGravity = value;
	}
}
