package com.soccer.service.mapper.request;

import com.soccer.model.entity.LeagueEntity;
import com.soccer.model.entity.TeamEntity;
import com.soccer.model.response.LeagueIntegration;
import com.soccer.service.model.request.TeamServiceRequest;

import java.util.Optional;

public class TeamServiceRequestMapper {

    public static TeamEntity toEntity(TeamServiceRequest teamRequest, LeagueIntegration leagueIntegration) {
        return Optional.ofNullable(teamRequest)
                .map(teamServiceRequest -> TeamEntity.builder()
                        .id(teamRequest.getId())
                        .name(teamRequest.getName())
                        .historicalReputation(teamRequest.getHistoricalReputation())
                        .balance(teamRequest.getBalance())
                        .league(toLeagueEntity(leagueIntegration))
                        .build())
                .orElse(null);
    }

    public static LeagueEntity toLeagueEntity(LeagueIntegration leagueIntegration) {
        return Optional.ofNullable(leagueIntegration)
                .map(league -> LeagueEntity.builder()
                        .id(leagueIntegration.getId())
                        .name(leagueIntegration.getName())
                        .country(leagueIntegration.getCountry())
                        .build())
                .orElse(null);
    }

}
