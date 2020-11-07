import java.util.logging.Level;
import java.util.logging.Logger;

public class GlobalLogger {
	public static void main(String[] args) {
		Logger.getGlobal().info("File->Open menu item selected before");
		GlobalLogger.function();
		Logger.getGlobal().setLevel(Level.OFF);
		Logger.getGlobal().info("File->Open menu item selected after");
		
	}
	
	public static void function() {
		Logger.getGlobal().info("used function");
	}
}
