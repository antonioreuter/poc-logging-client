package poc.logging.appenders;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.apache.log4j.AppenderSkeleton;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import poc.logging.services.LoggingService;

/**
 * Created by 310280812 on 3/17/2017.
 */
@Component("loggingAppender")
public class LoggingAppender extends AppenderBase<LoggingEvent> implements ApplicationContextAware {

    public static LoggingService logger;

//    @Async
    protected void append(LoggingEvent event) {
        logger.append(event.getFormattedMessage());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       logger = (LoggingService) applicationContext.getAutowireCapableBeanFactory().getBean("loggingService");
    }
}
