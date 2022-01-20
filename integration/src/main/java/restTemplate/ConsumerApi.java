package restTemplate;

import com.desafios.soccer.model.entity.League;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@Component
public class ConsumerApi {

    private RestTemplate restTemplate;

    @Bean
    public League find(League league) {
        String uri = "http://localhost:8081/v1/league" + league.getName() + "/json/";
        return restTemplate.getForObject(uri, League.class);
    }

    @Bean
    public League save(League league) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost:8081")
                .path("v1/league")
                .build();
        return restTemplate.postForObject(uri.toUri(), league.getName(), League.class);
    }
}
