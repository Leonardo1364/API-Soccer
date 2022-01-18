package restTemplateConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Configuration
public class RestTemplateConfig {
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return Objects.requireNonNullElseGet(restTemplate, RestTemplate::new);
    }
}
