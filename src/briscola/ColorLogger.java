package briscola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class for logging that supports ANSI colors in log messages.
 */

public class ColorLogger {

    private final Logger logger;

    /**
     * Creates a new instance of ColorLogger.
     *
     * @param clazz The class for which logging is desired.
     */

    public ColorLogger(Class<?> clazz){
        logger = LoggerFactory.getLogger(clazz);
        LogbackConfigurator.configure("logs/logback.xml");
    }

    /**
     * Logs a message with INFO level using the specified color.
     *
     * @param info The message to log.
     */

    public void info(String info){
        logger.info(ColorUtility.Color.CYAN.getCode() + info + ColorUtility.Color.DEFAULT.getCode());
    }

    /**
     * Logs a message with ERROR level using the specified color.
     *
     * @param error The message to log.
     */

    public void error(String error){
        logger.error(ColorUtility.Color.RED.getCode() + error + ColorUtility.Color.DEFAULT.getCode());
    }

    /**
     * Logs a message with WARN level using the specified color.
     *
     * @param warn The message to log.
     */

    public void warn(String warn){
        logger.warn(ColorUtility.Color.RED.getCode() + warn + ColorUtility.Color.DEFAULT.getCode());
    }

    /**
     * Logs a message with INFO level using the specified color, indicating the audio playback status.
     *
     * @param play The audio playback status.
     */

    public void audioInfo(boolean play){
        if (play){
            logger.info(ColorUtility.Color.CYAN.getCode() + "Play has been set to: " + ColorUtility.Color.BLUE.getCode() + true + ColorUtility.Color.WHITE.getCode());
        }else{
            logger.info(ColorUtility.Color.CYAN.getCode() + "Play has been set to: " + ColorUtility.Color.RED.getCode() + false + ColorUtility.Color.WHITE.getCode());
        }
    }

}
