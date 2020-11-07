import java.util.logging.Level;
import java.util.logging.Logger;

public class UseSetProperty {
	public static void main(String[] args) {
		System.setProperty("java.util.logging.config.file", "D:\\Learn\\Java\\corejava_mooc\\MOOC02-Practice\\src\\main\\resources\\logging.properties");
		Logger logger = Logger.getLogger("beginLevel.log");
		logger.fine("fine info");
	}
}
