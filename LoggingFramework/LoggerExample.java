package LoggingFramework;

import java.util.logging.Logger;

public class LoggerExample {

    private static final Logger logger =
            Logger.getLogger(LoggerExample.class.getName());

    public static void main(String[] args) {

        logger.info("Application started");

        int a = 10;
        int b = 5;

        logger.info("Addition Result: " + (a + b));
        logger.warning("This is a warning message");
        logger.severe("This is a severe error message");

        logger.info("Application finished");
    }
}