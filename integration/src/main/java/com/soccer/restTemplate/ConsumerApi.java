package com.soccer.restTemplate;

import com.soccer.model.response.LeagueIntegration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@Component
public class ConsumerApi {

    private RestTemplate restTemplate;

    public LeagueIntegration find(Long leagueId) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/v1/league/".concat(leagueId.toString()))
                .build();
        return restTemplate.getForObject(uri.toUri(), LeagueIntegration.class);
    }
}
