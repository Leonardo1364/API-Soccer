package com.soccer.restTemplateConfig;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@AllArgsConstructor
@Configuration
public class RestTemplateConfig {

    @Bean
    public static RestTemplate restTemplate() {

        String baseUri = "http://localhost:8081";
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(baseUri);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(uriBuilderFactory);
        return restTemplate;
    }

}
