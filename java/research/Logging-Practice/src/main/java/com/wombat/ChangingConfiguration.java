package com.wombat;
import java.io.IOException;
import java.util.logging.*;

public class ChangingConfiguration {

	public static void main(String[] args) {
	    Handler fh;
		try {
			fh = new FileHandler("%t/wombat.log");
		    Logger logger = Logger.getLogger("");
		    logger.addHandler(fh);
		    logger.info("father");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    Logger com = Logger.getLogger("com");
	    com.setLevel(Level.FINEST);
	    com.info("my is com info message");
	    com.fine("my is com fine mesage");
	    
	    Logger sub = Logger.getLogger("com.wombat");
	    sub.setLevel(Level.FINEST);
	    sub.info("my is info message");
	    sub.fine("my is fine mesage");
	}

}
