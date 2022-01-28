package com.soccer.contract.mapper.request;

import com.soccer.contract.model.request.TeamControllerRequest;
import com.soccer.service.model.request.TeamServiceRequest;

import java.util.Optional;

public class TeamControllerRequestMapper {

    public static TeamServiceRequest toServiceWithId(TeamControllerRequest teamRequest, String id) {

        return Optional.ofNullable(teamRequest)
                .map(teamControllerRequest -> TeamServiceRequest.builder()
                    .id(id)
                    .name(teamRequest.getName())
                    .historicalReputation(teamRequest.getHistoricalReputation())
                    .balance(teamRequest.getBalance())
                    .date(teamRequest.getDate())
                    .leagueId(teamRequest.getLeagueId())
                    .build())
                .orElse(null);
    }

    public static TeamServiceRequest toServiceWithoutId(TeamControllerRequest teamRequest) {

        return Optional.ofNullable(teamRequest)
                .map(teamControllerRequest -> TeamServiceRequest.builder()
                    .name(teamRequest.getName())
                    .historicalReputation(teamRequest.getHistoricalReputation())
                    .balance(teamRequest.getBalance())
                    .date(teamRequest.getDate())
                    .leagueId(teamRequest.getLeagueId())
                    .build())
                .orElse(null);
    }

}
