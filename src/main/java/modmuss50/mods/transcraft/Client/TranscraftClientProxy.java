package modmuss50.mods.transcraft.Client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import modmuss50.mods.transcraft.Blocks.Models.RenderCandle;
import modmuss50.mods.transcraft.Blocks.TileEntitys.CandleTile;
import modmuss50.mods.transcraft.Blocks.TileEntitys.EnderDigger.TileEntiyEnderDigger;
import modmuss50.mods.transcraft.Blocks.TileEntitys.ItemGrinder.ItemGrinderTile;
import modmuss50.mods.transcraft.Blocks.TileEntitys.ItemGrinder.ItemTileIGRender;
import modmuss50.mods.transcraft.Blocks.TileEntitys.ItemGrinder.TileIGRender;
import modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter.RenderHandTC;
import modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter.RenderTC;
import modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter.TileTC;
import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.Client.Renders.RenderEnderDigger;
import modmuss50.mods.transcraft.Client.Renders.RenderEnderSword;
import modmuss50.mods.transcraft.Client.Renders.particles.FXSparkle;
import modmuss50.mods.transcraft.Entitys.mob.EnderBatRender;
import modmuss50.mods.transcraft.Entitys.mob.Enderbat;
import modmuss50.mods.transcraft.Entitys.mob.NukeCreeper;
import modmuss50.mods.transcraft.Entitys.mob.NukeCreeperRender;
import modmuss50.mods.transcraft.Items.TranscraftItems;
import modmuss50.mods.transcraft.TranscraftCommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import java.util.Random;

public class TranscraftClientProxy extends TranscraftCommonProxy {

	public static Minecraft	mc	= Minecraft.getMinecraft();

	@Override
	public void registerHandlers() {
		MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
	}

	@Override
	public void registerTickHandlers() {

	}

	public void sparkleFX(World world, double x, double y, double z, float size, int m) {
		FXSparkle sparkle = new FXSparkle(world, x, y, z, size, m);
		Minecraft.getMinecraft().effectRenderer.addEffect(sparkle);
	}

	public void renderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(ItemGrinderTile.class, new TileIGRender());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntiyEnderDigger.class, new RenderEnderDigger());

		MinecraftForgeClient.registerItemRenderer(ItemBlock.getItemFromBlock(TranscraftBlocks.ixpGrinder), new ItemTileIGRender());

		ClientRegistry.bindTileEntitySpecialRenderer(TileTC.class, new RenderTC());

		ClientRegistry.bindTileEntitySpecialRenderer(CandleTile.class, new RenderCandle());

		MinecraftForgeClient.registerItemRenderer(ItemBlock.getItemFromBlock(TranscraftBlocks.Transcrafter), new RenderHandTC());

		MinecraftForgeClient.registerItemRenderer(TranscraftItems.EnderSword, new RenderEnderSword());

		RenderingRegistry.registerEntityRenderingHandler(NukeCreeper.class, new NukeCreeperRender());
		RenderingRegistry.registerEntityRenderingHandler(Enderbat.class, new EnderBatRender());
	}

	public void postrenderThings() {

	}

	@Override
	public void spawnParticle(String string, double x, double y, double z) {
		EntityFX entityfx = null;

		Random rand = new Random();

		if (string == "glass") {
			// entityfx = new GlassFX(mc.theWorld, x, y, z, 0.0D, 0.0D, 0.0D);
		}

		mc.effectRenderer.addEffect(entityfx);
	}

}
