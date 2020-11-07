import java.util.logging.*;
public class UseSetParent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("com.mycompany.myapp");
		logger.setLevel(Level.FINE);
//		logger.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);
		logger.info("info message 1");
		logger.fine("fine message 1");
		Logger logger2 = Logger.getLogger("com.mycompany.myapp.myapp2");
		Handler handler2 = new ConsoleHandler();
		handler2.setLevel(Level.FINE);
		logger2.addHandler(handler2);
		logger2.fine("fine message 2");
		logger2.info("info message 2");
	}

}
