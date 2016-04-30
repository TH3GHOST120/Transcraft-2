package modmuss50.mods.transcraft.addons.fmp;

import codechicken.lib.packet.PacketCustom;
import codechicken.multipart.minecraft.EventHandler;
import codechicken.multipart.minecraft.MinecraftMultipartMod;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.world.World;

public class TcMultipartSPH implements PacketCustom.IServerPacketHandler {
	public static Object	channel	= MinecraftMultipartMod.instance;

	@Override
	public void handlePacket(PacketCustom packet, EntityPlayerMP sender, INetHandlerPlayServer netHandler) {
		switch (packet.getType()) {
			case 1:
				EventHandler.place(sender, sender.worldObj);
				break;
		}
	}

	public static void spawnBurnoutSmoke(World world, int x, int y, int z) {
		new PacketCustom(channel, 1).writeCoord(x, y, z).sendToChunk(world, x >> 4, z >> 4);
	}
}
