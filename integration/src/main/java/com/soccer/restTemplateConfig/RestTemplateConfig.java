package com.soccer.restTemplateConfig;

import lombok.AllArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Configuration
public class RestTemplateConfig {

    private static RestTemplate restTemplate;

    @Bean
    public static RestTemplate restTemplate() {
        if (restTemplate == null) {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpComponentsClientHttpRequestFactory httpRequestFactory =
                    new HttpComponentsClientHttpRequestFactory(httpClient);
            httpRequestFactory.setConnectTimeout(3000);
            restTemplate = new RestTemplate(httpRequestFactory);
        }
        return restTemplate;
    }

}
