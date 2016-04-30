package modmuss50.mods.transcraft.Utils;

import cpw.mods.fml.relauncher.FMLRelaunchLog;
import org.apache.logging.log4j.Level;

public class TCLog {

	public static cpw.mods.fml.relauncher.FMLRelaunchLog	instance	= cpw.mods.fml.relauncher.FMLRelaunchLog.log;

	private TCLog() {}

	private static void log(Level level, String format, Object... data) {
		FMLRelaunchLog.log("RB", level, format, data);
	}

	public static void severe(String format, Object... data) {
		log(Level.ERROR, format, data);
	}

	public static void warning(String format, Object... data) {
		log(Level.WARN, format, data);
	}

	public static void info(String format, Object... data) {
		log(Level.INFO, format, data);
	}

	public static void error(Throwable e) {
		severe("Error: " + e.getMessage());
		e.printStackTrace();
	}

}
