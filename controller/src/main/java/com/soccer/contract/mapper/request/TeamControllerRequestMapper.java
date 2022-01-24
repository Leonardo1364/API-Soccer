package com.soccer.contract.mapper.request;

import com.soccer.contract.model.request.TeamControllerRequest;
import com.soccer.service.model.request.TeamServiceRequest;

//@Mapper()
public interface TeamControllerRequestMapper {

    static TeamServiceRequest toServiceWithId(TeamControllerRequest teamRequest, String id) {

        return TeamServiceRequest.builder()
                .id(id)
                .name(teamRequest.getName())
                .historicalReputation(teamRequest.getHistoricalReputation())
                .balance(teamRequest.getBalance())
                .date(teamRequest.getDate())
                .leagueId(teamRequest.getLeagueId())
                .build();
    }

    static TeamServiceRequest toServiceWithoutId(TeamControllerRequest teamRequest) {

        return TeamServiceRequest.builder()
                .name(teamRequest.getName())
                .historicalReputation(teamRequest.getHistoricalReputation())
                .balance(teamRequest.getBalance())
                .date(teamRequest.getDate())
                .leagueId(teamRequest.getLeagueId())
                .build();
    }

/*
    static TeamServiceRequest toTeamService(TeamControllerRequest teamRequest) {
        return Mappers.getMapper(TeamControllerRequestMapper.class)
                .mapperRequest(teamRequest);
    }

    TeamServiceRequest mapperRequest(TeamControllerRequest teamRequest);
*/

}
