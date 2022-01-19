package restTemplateConfig;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@AllArgsConstructor
@Configuration
public class RestTemplateConfig {

    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return Objects.requireNonNullElseGet(restTemplate, RestTemplate::new);
    }

    @Bean
    public RestTemplate postRestTemplate() {
        return Objects.requireNonNullElseGet(restTemplate, RestTemplate::new);
    }
}
