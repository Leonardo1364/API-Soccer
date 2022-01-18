package restTemplate;

import com.desafios.soccer.model.entity.League;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@AllArgsConstructor
@Service
public class ConsumerApi {

    @Bean
    public League findLeague(League league) {
        String uri = "http://localhost:27018/v1/league" + league.getName() + "/json/";

        /*UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost:27018")
                .path("v1/league")
                .build();*/
        RestTemplate rs = new RestTemplate();
        return rs.getForObject(uri, League.class);
    }

}
