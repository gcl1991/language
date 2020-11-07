import java.io.IOException;
import java.util.logging.*;


public class EnteringAndExitingAndThrowing {
	private static final Logger logger = Logger.getLogger("");
	public static void main(String args[]) {
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.ALL);
		logger.addHandler(handler);
		read("info 1","info 2");
		IOException exception = new IOException("exception message");
		logger.throwing("default", "main", exception);
	}
	
	public static int read(String s, String p) {
		logger.entering("default", "read",new String[] {s,p});
		logger.exiting("default", "read",1);
		return 1;
	}
}
