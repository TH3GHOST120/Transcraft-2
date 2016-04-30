package modmuss50.mods.transcraft.Utils;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA. User: Mark Date: 05/03/14 Time: 08:19
 */
public class UpdateChecker {

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void login(PlayerEvent.PlayerLoggedInEvent event) {

		if (Config.updateChecker) {
			try {
				URL url = new URL("https://raw.github.com/modmuss50/Transcraft/master/transcraft.version");
				String string = downloadString(url);

				if (!string.contains(TranscraftUtil.UPDATEVERSION)) {
					Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("Transcraft is not up to date, new version available " + string));

					// System.out.println(TranscraftUtil.UPDATEVERSION
					// + " OLD VERSION");
					// System.out.println(string + " NEW VERSION");
				}
				else {
					// event.player.addChatComponentMessage(new
					// ChatComponentText("Transcraft version " + string
					// +
					// " is up to date..."));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static String downloadString(URL url) throws IOException {
		return readString(url.openStream());
	}

	public static String readString(InputStream stream) {
		Scanner scanner = new Scanner(stream).useDelimiter("\\A");
		return scanner.hasNext() ? scanner.next() : "";
	}

}
