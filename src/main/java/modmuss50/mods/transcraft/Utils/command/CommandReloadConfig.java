package modmuss50.mods.transcraft.Utils.command;

import modmuss50.mods.transcraft.Utils.Config;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentTranslation;

public class CommandReloadConfig extends Command {

	public CommandReloadConfig() {
		super("Tconfig");
	}

	@Override
	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
		Config.initConfig();
		par1ICommandSender.addChatMessage(new ChatComponentTranslation("Config Reloaded"));

	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "/Tconfig";
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;

	}

}
