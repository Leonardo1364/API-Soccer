package restTemplate;

import com.desafios.soccer.model.entity.teamResource;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@AllArgsConstructor
public class ConsumerApi {

    private final RestTemplate template;

    //https://app.sportdataapi.com/api/v1/soccer/leagues?apikey=d2541920-262e-11ec-ae9c-bdef304d5055&country_id=25

    public void consumingApi(){

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("http://apifutebol.footstats.com.br/")
                .path("/v1/team/3.1/teams/{idTeam}")
                .queryParam("idTeam", "61c0d131576d367eb199ab25")
                .queryParam("name", "Grêmio")
                .queryParam("Stadium", "Arena")
                .build();

        ResponseEntity<teamResource> entity = template.getForEntity(uri.toString(), teamResource.class);

        System.out.println(Objects.requireNonNull(entity.getBody()).getName());
    }

}
