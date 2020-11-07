import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseAppend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.ALL);
		try {
			System.out.println(System.getProperty("user.home"));
			Handler handler = new FileHandler("%h/myapp%u.log",true);
			logger.addHandler(handler);
			logger.info("info message");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}

}
