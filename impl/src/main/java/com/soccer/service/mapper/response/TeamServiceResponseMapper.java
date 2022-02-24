package com.soccer.service.mapper.response;

import com.soccer.exceptions.badrequestexception.BadRequestException;
import com.soccer.model.entity.LeagueEntity;
import com.soccer.model.entity.TeamEntity;
import com.soccer.service.model.response.LeagueServiceResponse;
import com.soccer.service.model.response.TeamServiceResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamServiceResponseMapper {

    public static TeamServiceResponse toResponseService(TeamEntity teamEntity) {

        return Optional.ofNullable(teamEntity)
                .map(team -> TeamServiceResponse.builder()
                    .id(teamEntity.getId())
                    .name(teamEntity.getName())
                    .historicalReputation(teamEntity.getHistoricalReputation())
                    .balance(teamEntity.getBalance())
                    .date(teamEntity.getDate())
                    .league(toLeagueService(teamEntity.getLeague()))
                    .build())
                .orElseThrow(() -> new BadRequestException(BAD_REQUEST));
    }

    public static LeagueServiceResponse toLeagueService(LeagueEntity leagueEntity) {
        return Optional.ofNullable(leagueEntity)
                .map(league -> LeagueServiceResponse.builder()
                        .id(leagueEntity.getId())
                        .name(leagueEntity.getName())
                        .country(leagueEntity.getCountry())
                        .build())
                .orElseThrow(() -> new BadRequestException(BAD_REQUEST));
    }

}
