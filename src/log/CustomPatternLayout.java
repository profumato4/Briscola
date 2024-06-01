package log;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class CustomPatternLayout extends PatternLayout {

    public CustomPatternLayout() {
        setPattern("%d{yyyy-MM-dd HH:mm:ss} %highlight(%-5level) %logger{36} - %msg%n");
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        String formattedMessage = super.doLayout(event);
        formattedMessage = formattedMessage.replaceAll("\\u001B\\[[;\\d]*m", "");
        return formattedMessage;
    }
}
