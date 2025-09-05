package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {
    private static final Logger logger = LogManager.getLogger(Log4j.class);

    public static void startLog(String testClassName) {
        logger.info("*** " + testClassName + " TEST START ***");
    }

    public static void endLog(String testClassName) {
        logger.info("*** " + testClassName + " TEST END ***");
    }

    public static Logger getLogger() {
        return logger;
    }
}


