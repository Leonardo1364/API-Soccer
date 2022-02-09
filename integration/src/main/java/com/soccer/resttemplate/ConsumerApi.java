package com.soccer.resttemplate;

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
        UriComponents baseUri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port("8081")
                .path("/v1/league/".concat(leagueId.toString()))
                .build();
        return restTemplate.getForObject(baseUri.toUri(), LeagueIntegration.class);
    }
}
