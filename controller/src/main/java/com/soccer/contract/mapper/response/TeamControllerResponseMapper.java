package com.soccer.contract.mapper.response;

import com.soccer.contract.model.response.LeagueControllerResponse;
import com.soccer.contract.model.response.TeamControllerResponse;
import com.soccer.service.model.response.LeagueServiceResponse;
import com.soccer.service.model.response.TeamServiceResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamControllerResponseMapper {

   public static TeamControllerResponse toResponseController(TeamServiceResponse teamServiceResponse) {

        return Optional.ofNullable(teamServiceResponse)
                .map(teamServiceResponse1 -> TeamControllerResponse.builder()
                    .id(teamServiceResponse.getId())
                    .name(teamServiceResponse.getName())
                    .historicalReputation(teamServiceResponse.getHistoricalReputation())
                    .balance(teamServiceResponse.getBalance())
                    .date(teamServiceResponse.getDate())
                    .league(toLeagueResponseController(teamServiceResponse.getLeague()))
                    .build())
                .orElse(null);
    }

    public static LeagueControllerResponse toLeagueResponseController(LeagueServiceResponse leagueServiceResponse) {

       return Optional.ofNullable(leagueServiceResponse)
               .map(leagueServiceResponse1 -> LeagueControllerResponse.builder()
                       .id(leagueServiceResponse.getId())
                       .name(leagueServiceResponse.getName())
                       .country(leagueServiceResponse.getCountry())
                       .build())
               .orElse(null);
    }

}
