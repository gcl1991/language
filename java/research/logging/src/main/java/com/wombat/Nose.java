package com.wombat;
import java.util.logging.*;

public class Nose{
    // Obtain a suitable logger.
    private static Logger logger = Logger.getLogger("com.wombat.nose");
    public static void main(String argv[]) {
        // Log a FINE tracing message
        logger.fine("doing stuff");
        try{
            Wombat.sneeze();
        } catch (Exception ex) {
            // Log the exception
            logger.log(Level.WARNING, "trouble sneezing",ex);
            logger.log(Level.INFO,"error class is {0}",new Wombat());
            logger.log(Level.INFO,"error class is {0}","Wombat");
        }
        logger.info("Nose over ");
        logger.fine("done");
    }
}

class Wombat{
	static void sneeze() {
		System.out.print("wombat sneeze");
		int a = 1/0;
	}
}