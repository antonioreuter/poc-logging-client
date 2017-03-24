package poc.logging.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 310280812 on 3/17/2017.
 */

@Configuration
public class ApplicationConfig {

    @Bean(name = "loggingRestTemplate")
    RestTemplate loggingRestTemplate(@Qualifier("httpClient") HttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpComponentsClientHttpRequestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(httpComponentsClientHttpRequestFactory);
        //restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("xxx", "xxx"));

        return restTemplate;
    }

    @Bean(name = "httpClient")
    public HttpClient httpClient() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(5);
        connectionManager.setMaxTotal(10);

        int timeout = 60 * 1000;

        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(timeout)
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .build();

        return HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(config).build();
    }
}
