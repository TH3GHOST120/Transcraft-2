package modmuss50.mods.transcraft.Utils;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class FakePlayer {

	public static EntityPlayer	TranscraftPlayer;

	public static String playerName() {
		return "";
	}

	public static EntityPlayer createNewPlayer(World world) {
		EntityPlayer player = new EntityPlayer(world, new GameProfile(null, "[Transcraft]")) {
			@Override
			public void addChatMessage(IChatComponent var1) {}

			@Override
			public boolean canCommandSenderUseCommand(int var1, String var2) {
				return false;
			}

			@Override
			public ChunkCoordinates getPlayerCoordinates() {
				return null;
			}
		};
		return player;
	}

	public static EntityPlayer createNewPlayer(World world, int x, int y, int z) {
		EntityPlayer player = new EntityPlayer(world, new GameProfile(null, "[Transcraft]")) {
			@Override
			public void addChatMessage(IChatComponent var1) {}

			@Override
			public boolean canCommandSenderUseCommand(int var1, String var2) {
				return false;
			}

			@Override
			public ChunkCoordinates getPlayerCoordinates() {
				return null;
			}
		};
		player.posX = x;
		player.posY = y;
		player.posZ = z;
		return player;
	}

	public static EntityPlayer getTranscraftPlayer(World world) {
		if (TranscraftPlayer == null) {
			TranscraftPlayer = createNewPlayer(world);
		}
		else {
			TranscraftPlayer.worldObj = world;
		}

		return TranscraftPlayer;
	}

	public static EntityPlayer getTranscraftPlayer(World world, int x, int y, int z) {
		if (TranscraftPlayer == null) {
			TranscraftPlayer = createNewPlayer(world, x, y, z);
		}
		else {
			TranscraftPlayer.worldObj = world;
			TranscraftPlayer.posX = x;
			TranscraftPlayer.posY = y;
			TranscraftPlayer.posZ = z;
		}

		return TranscraftPlayer;
	}
}
