package briscola;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;

import java.io.File;

public class LogbackConfigurator {

    public static void configure(String configFilePath) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        try {
            File file = new File(configFilePath);
            if (file.exists() && file.isFile()) {
                JoranConfigurator configurator = new JoranConfigurator();
                configurator.setContext(context);
                context.reset();
                configurator.doConfigure(file);
            } else {
                System.err.println("Logback configuration file not found: " + configFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
    }
}