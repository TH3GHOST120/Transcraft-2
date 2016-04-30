/**
 * This class is part of the mod Transcraft. 
 *
 * Transcraft is Open Source but you cant use any code without permission!
 *
 */

package modmuss50.mods.transcraft.Client.Renders.particles;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class FXSparkle extends EntityFX {

	public static final ResourceLocation	particles	= new ResourceLocation("transcraft", "textures/particles/particles.png");

	public FXSparkle(World world, double x, double y, double z, float size, int m) {
		super(world, x, y, z, 0.0D, 0.0D, 0.0D);

		float minX = 1.0f;
		float maxX = 0.001f;

		Random rand = new Random();

		float red = rand.nextFloat() * (maxX - minX) + minX;
		float green = rand.nextFloat() * (maxX - minX) + minX;
		float blue = rand.nextFloat() * (maxX - minX) + minX;

		particleRed = red;
		particleGreen = green;
		particleBlue = blue;
		particleGravity = 0;
		motionX = motionY = motionZ = 0;
		particleScale *= size;
		particleMaxAge = 3 * m;
		multiplier = m;
		noClip = false;
		setSize(0.01F, 0.01F);
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
	}

	public FXSparkle(World world, double d, double d1, double d2, float f, int type, int m) {
		this(world, d, d1, d2, f, m);
		particleRed = .75f + world.rand.nextFloat() * .25f;
		particleGreen = .25f + world.rand.nextFloat() * .25f;
		particleBlue = .75f + world.rand.nextFloat() * .25f;
	}

	public FXSparkle(World world, double d, double d1, double d2, double x, double y, double z, float f, int type, int m) {
		this(world, d, d1, d2, f, type, m);

		double dx = x - posX;
		double dy = y - posY;
		double dz = z - posZ;

		motionX = dx / particleMaxAge;
		motionY = dy / particleMaxAge;
		motionZ = dz / particleMaxAge;
	}

	@Override
	public void renderParticle(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5) {

		tessellator.draw();
		GL11.glPushMatrix();

		GL11.glDepthMask(false);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, blendmode);

		Minecraft.getMinecraft().renderEngine.bindTexture(particles);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
		int part = particle + particleAge / multiplier;

		float var8 = part % 8 / 8.0F;
		float var9 = var8 + 0.0624375F * 2;
		float var10 = part / 8 / 8.0F;
		float var11 = var10 + 0.0624375F * 2;
		float var12 = 0.1F * particleScale;
		if (shrink)
			var12 *= (particleMaxAge - particleAge + 1) / (float) particleMaxAge;
		float var13 = (float) (prevPosX + (posX - prevPosX) * f - interpPosX);
		float var14 = (float) (prevPosY + (posY - prevPosY) * f - interpPosY);
		float var15 = (float) (prevPosZ + (posZ - prevPosZ) * f - interpPosZ);
		float var16 = 1.0F;

		tessellator.startDrawingQuads();
		tessellator.setBrightness(0x0000f0);

		tessellator.setColorRGBA_F(particleRed * var16, particleGreen * var16, particleBlue * var16, 1);
		tessellator.addVertexWithUV(var13 - f1 * var12 - f4 * var12, var14 - f2 * var12, var15 - f3 * var12 - f5 * var12, var9, var11);
		tessellator.addVertexWithUV(var13 - f1 * var12 + f4 * var12, var14 + f2 * var12, var15 - f3 * var12 + f5 * var12, var9, var10);
		tessellator.addVertexWithUV(var13 + f1 * var12 + f4 * var12, var14 + f2 * var12, var15 + f3 * var12 + f5 * var12, var8, var10);
		tessellator.addVertexWithUV(var13 + f1 * var12 - f4 * var12, var14 - f2 * var12, var15 + f3 * var12 - f5 * var12, var8, var11);

		tessellator.draw();

		GL11.glDisable(3042);
		GL11.glDepthMask(true);

		GL11.glPopMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(particles);
		tessellator.startDrawingQuads();

	}

	@Override
	public void onUpdate() {

		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;

		if (particleAge == 0 && tinkle && worldObj.rand.nextInt(10) == 0)
			worldObj.playSoundAtEntity(this, "random.orb", 0.02F, 0.7F * ((worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) * 0.6F + 2F));

		if (particleAge++ >= particleMaxAge) {

			setDead();
		}

		motionY -= 0.040000000000000001D * particleGravity;
		if (noClip == false)
			pushOutOfBlocks(posX, (boundingBox.minY + boundingBox.maxY) / 2.0D, posZ);
		posX += motionX;
		posY += motionY;
		posZ += motionZ;
		if (slowdown) {
			motionX *= 0.908000001907348633D;
			motionY *= 0.908000001907348633D;
			motionZ *= 0.908000001907348633D;
			if (onGround) {
				motionX *= 0.69999998807907104D;
				motionZ *= 0.69999998807907104D;
			}
		}

		if (leyLineEffect) {

			FXSparkle fx = new FXSparkle(worldObj, prevPosX + (worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) * .1f, prevPosY + (worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) * .1f, prevPosZ + (worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) * .1f, 1f, currentColor, 3 + worldObj.rand.nextInt(3));
			fx.noClip = true;
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
		}
	}

	public void setGravity(float value) {
		particleGravity = value;
	}

	protected boolean pushOutOfBlocks(double par1, double par3, double par5) {
		int var7 = MathHelper.floor_double(par1);
		int var8 = MathHelper.floor_double(par3);
		int var9 = MathHelper.floor_double(par5);
		double var10 = par1 - var7;
		double var12 = par3 - var8;
		double var14 = par5 - var9;

		if (!worldObj.isAirBlock(var7, var8, var9)) {
			boolean var16 = !worldObj.isBlockNormalCubeDefault(var7 - 1, var8, var9, true);
			boolean var17 = !worldObj.isBlockNormalCubeDefault(var7 + 1, var8, var9, true);
			boolean var18 = !worldObj.isBlockNormalCubeDefault(var7, var8 - 1, var9, true);
			boolean var19 = !worldObj.isBlockNormalCubeDefault(var7, var8 + 1, var9, true);
			boolean var20 = !worldObj.isBlockNormalCubeDefault(var7, var8, var9 - 1, true);
			boolean var21 = !worldObj.isBlockNormalCubeDefault(var7, var8, var9 + 1, true);
			byte var22 = -1;
			double var23 = 9999.0D;

			if (var16 && var10 < var23) {
				var23 = var10;
				var22 = 0;
			}

			if (var17 && 1.0D - var10 < var23) {
				var23 = 1.0D - var10;
				var22 = 1;
			}

			if (var18 && var12 < var23) {
				var23 = var12;
				var22 = 2;
			}

			if (var19 && 1.0D - var12 < var23) {
				var23 = 1.0D - var12;
				var22 = 3;
			}

			if (var20 && var14 < var23) {
				var23 = var14;
				var22 = 4;
			}

			if (var21 && 1.0D - var14 < var23) {
				var23 = 1.0D - var14;
				var22 = 5;
			}

			float var25 = rand.nextFloat() * 0.05F + 0.025F;
			float var26 = (rand.nextFloat() - rand.nextFloat()) * 0.1F;

			if (var22 == 0) {
				motionX = -var25;
				motionY = motionZ = var26;
			}

			if (var22 == 1) {
				motionX = var25;
				motionY = motionZ = var26;
			}

			if (var22 == 2) {
				motionY = -var25;
				motionX = motionZ = var26;
			}

			if (var22 == 3) {
				motionY = var25;
				motionX = motionZ = var26;
			}

			if (var22 == 4) {
				motionZ = -var25;
				motionY = motionX = var26;
			}

			if (var22 == 5) {
				motionZ = var25;
				motionY = motionX = var26;
			}

			return true;
		}
		else {
			return false;
		}

	}

	public boolean	leyLineEffect	= false;
	public int		multiplier		= 2;
	public boolean	shrink			= true;
	public int		particle		= 16;
	public boolean	tinkle			= false;
	public int		blendmode		= 1;
	public boolean	slowdown		= true;
	public int		currentColor	= 0;

}
