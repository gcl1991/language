import java.io.IOException;
import java.util.logging.*;

public class ChangingConfiguration {

	public static void main(String[] args) {
	    Handler fh;
		try {
			fh = new FileHandler("%t/wombat.log");
		    Logger.getLogger("").addHandler(fh);
		    Logger.getLogger("com.wombat").setLevel(Level.FINEST);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
