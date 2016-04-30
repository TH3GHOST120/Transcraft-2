package modmuss50.mods.transcraft.Utils.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

public abstract class Command extends CommandBase {
	public final String	name;

	public Command(String name) {
		this.name = name;
	}

	@Override
	public String getCommandName() {
		return name;
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return null;
	}

	WrongUsageException showUsage(ICommandSender var1) {
		return new WrongUsageException(getCommandUsage(var1));
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {

	}

}
