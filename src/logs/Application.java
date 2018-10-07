package logs;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Application {

    private static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);


    public static void main(String[] args) {

        logger.setLevel(Level.INFO);

        logger.log(Level.INFO, "My first log message.");
        logger.log(Level.SEVERE, "Another message");

        logger.log(Level.FINE, "Not much.");

        logger.log(Level.INFO, "{0} is my {1}", new Object[]{"test", "ya know, test"});

    }
}
