package briscola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColorLogger {

    private final Logger logger;

    private Class<?> clazz ;

    public ColorLogger(Class<?> clazz){
        this.clazz = clazz;
        logger = LoggerFactory.getLogger(clazz);
        LogbackConfigurator.configure("logs/logback.xml");
    }

    public void info(String info){
        logger.info("\u001B[32m" + info + "\u001B[0m");
    }

    public void error(String error){
        logger.error("\u001B[31m" + error + "\u001B[0m");
    }

    public void warn(String warn){
        logger.warn("\u001B[31m" + warn + "\u001B[0m");
    }

}
