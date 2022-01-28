package com.soccer.service.mapper.response;

import com.soccer.model.entity.LeagueEntity;
import com.soccer.model.entity.TeamEntity;
import com.soccer.service.model.response.LeagueServiceResponse;
import com.soccer.service.model.response.TeamServiceResponse;

import java.util.Optional;

public class TeamServiceResponseMapper {

    public static TeamServiceResponse toResponse(TeamEntity teamEntity) {

        return Optional.ofNullable(teamEntity)
                .map(team -> TeamServiceResponse.builder()
                    .id(teamEntity.getId())
                    .name(teamEntity.getName())
                    .historicalReputation(teamEntity.getHistoricalReputation())
                    .balance(teamEntity.getBalance())
                    .date(teamEntity.getDate())
                    .league(toLeagueService(teamEntity.getLeague()))
                    .build())
                .orElse(null);
    }

    public static LeagueServiceResponse toLeagueService(LeagueEntity leagueEntity) {
        return Optional.ofNullable(leagueEntity)
                .map(league -> LeagueServiceResponse.builder()
                        .id(leagueEntity.getId())
                        .name(leagueEntity.getName())
                        .country(leagueEntity.getCountry())
                        .build())
                .orElse(null);
    }

}
