package poc.logging.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 310280812 on 3/17/2017.
 */

@Slf4j
@Service("loggingService")
public class LoggingService {

    @Qualifier("loggingRestTemplate")
    @Autowired
    private RestTemplate loggingRestTemplate;

    @HystrixCommand(fallbackMethod = "reliable")
    public void append(String message) {
        log.info("appending message: {}", message);
        loggingRestTemplate.postForObject("http://localhost:9090/api/v1/logging", message, String.class);
    }

    @HystrixCommand
    private void reliable(String message) {
        log.info("Reliable -> Message: {}",message);
    }
}
