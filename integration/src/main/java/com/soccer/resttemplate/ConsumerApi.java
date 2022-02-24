package com.soccer.resttemplate;

import com.soccer.model.response.LeagueIntegration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Component
public class ConsumerApi {

    private RestTemplate restTemplate;
    private RestTemplate restTemplate1;

    public LeagueIntegration find(Long leagueId) {
        return restTemplate1.getForObject("/v1/league/".concat(leagueId.toString()), LeagueIntegration.class);
    }

    public List<LeagueIntegration> findAll() {
        return Arrays.stream(
                Objects
                        .requireNonNull(restTemplate
                            .getForObject("/v1/league/", LeagueIntegration[].class)))
                            .toList();
    }

}
