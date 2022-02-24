package com.soccer.resttemplateconfig;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.ExtractingResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@AllArgsConstructor
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .rootUri("http://localhost:8081")
                .errorHandler(new RestHandle())
                .build();
    }

    @Bean
    public RestTemplate restTemplate1() {
        return new RestTemplateBuilder()
                .rootUri("http://localhost:8081")
                .build();
    }


}
