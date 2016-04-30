/**
 * This class is part of the mod Transcraft. 
 *
 * Transcraft is Open Source but you cant use any code without permission!
 *
 */

package modmuss50.mods.transcraft.Client.Renders.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

import java.util.Random;

public class FXSparkleRun {

	public static void transmutterOre(World par1World, int par2, int par3, int par4, Random par5Random) {

		if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
			FXSparkle sparkle2 = new FXSparkle(par1World, par2 + 0.5 + par5Random.nextFloat(), par3 + 0.5 + par5Random.nextFloat() * 0.5, par4 + 0.3 + par5Random.nextFloat() * 0.5, 1, 20);
			Minecraft.getMinecraft().effectRenderer.addEffect(sparkle2);

			FXSparkle sparkle3 = new FXSparkle(par1World, par2 - 0.5 + par5Random.nextFloat(), par3 + 0.5 + par5Random.nextFloat() * 0.5, par4 + 0.3 + par5Random.nextFloat() * 0.5, 1, 20);
			Minecraft.getMinecraft().effectRenderer.addEffect(sparkle3);

			FXSparkle sparkle4 = new FXSparkle(par1World, par2 + 0.3 + par5Random.nextFloat(), par3 + 0.5 + par5Random.nextFloat() * 0.5, par4 + 0.5 + par5Random.nextFloat() * 0.5, 1, 20);
			Minecraft.getMinecraft().effectRenderer.addEffect(sparkle4);

			FXSparkle sparkle5 = new FXSparkle(par1World, par2 + 0.3 + par5Random.nextFloat(), par3 + 0.5 + par5Random.nextFloat() * 0.5, par4 - 0.5 + par5Random.nextFloat() * 0.5, 1, 20);
			Minecraft.getMinecraft().effectRenderer.addEffect(sparkle5);

		}

	}

	public static void runEDFX(World par1World, double x, double y, double z, double tx, double ty, double tz, float red, float green, float blue, int age) {
		FxEnderDigger par = new FxEnderDigger(par1World, x, y, z, tx, ty, tz, red, green, blue, age);
		Minecraft.getMinecraft().effectRenderer.addEffect(par);
	}

	public static void FxFlame(World world, double x, double y, double z, float scale, int type, int multiplier) {
		FXFlame par = new FXFlame(world, x, y, z, scale, type, multiplier);
		Minecraft.getMinecraft().effectRenderer.addEffect(par);
	}
}
