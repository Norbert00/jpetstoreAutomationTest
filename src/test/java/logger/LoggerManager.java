package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerManager {

    private Logger logger;

    public LoggerManager(Class expectedClass) {
        this.logger = LogManager.getLogger(expectedClass);
    }


    public void getLoggerInfo(String info) {
        logger.info(info);
    }

    public void getLoggerInfo(String info, boolean result) {
        logger.info("Returning status of banner after login: {} ", result);
    }

    public void getLoggerInfo(String info, String expectedInfo) {
        logger.info(info,expectedInfo);
    }

    public Logger getLogger(){
        return LogManager.getLogger(this);
    }

}
