package com.soccer.service.mapper.request;

import com.soccer.exceptions.badrequestexception.BadRequestException;
import com.soccer.model.entity.LeagueEntity;
import com.soccer.model.entity.TeamEntity;
import com.soccer.model.response.LeagueIntegration;
import com.soccer.service.model.request.TeamServiceRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamServiceRequestMapper {

    public static TeamEntity toEntity(TeamServiceRequest teamRequest, LeagueIntegration leagueIntegration) {
        return Optional.ofNullable(teamRequest)
                .map(teamServiceRequest -> TeamEntity.builder()
                        .id(teamRequest.getId())
                        .name(teamRequest.getName())
                        .historicalReputation(teamRequest.getHistoricalReputation())
                        .balance(teamRequest.getBalance())
                        .date(teamRequest.getDate())
                        .league(toLeagueEntity(leagueIntegration))
                        .build())
                .orElseThrow(() -> new BadRequestException(BAD_REQUEST));
    }

    public static LeagueEntity toLeagueEntity(LeagueIntegration leagueIntegration) {
        return Optional.ofNullable(leagueIntegration)
                .map(league -> LeagueEntity.builder()
                        .id(leagueIntegration.getId())
                        .name(leagueIntegration.getName())
                        .country(leagueIntegration.getCountry())
                        .build())
                .orElseThrow(() -> new BadRequestException(BAD_REQUEST));
    }

}
