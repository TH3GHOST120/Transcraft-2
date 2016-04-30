package modmuss50.mods.transcraft.Utils.command;

import modmuss50.mods.transcraft.Utils.TranscraftUtil;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentTranslation;

public class CommandTranscraftVersion extends Command {

	public CommandTranscraftVersion() {
		super("Tversion");
	}

	@Override
	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
		par1ICommandSender.addChatMessage(new ChatComponentTranslation("----------Transcraft!----------"));
		par1ICommandSender.addChatMessage(new ChatComponentTranslation("Transcraft Version " + TranscraftUtil.VERSION + TranscraftUtil.STATE));
		par1ICommandSender.addChatMessage(new ChatComponentTranslation("Made by " + TranscraftUtil.authorList));
		par1ICommandSender.addChatMessage(new ChatComponentTranslation("----------Transcraft!----------"));

	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "/Tversion Gets the version of transcraft";
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

}
