package com.desafios.soccer.contract.mapper.request;

import com.desafios.soccer.contract.model.request.TeamControllerRequest;
import com.desafios.soccer.service.model.request.TeamServiceRequest;

//@Mapper()
public interface TeamControllerRequestMapper {

    static TeamServiceRequest toServiceWithId(TeamControllerRequest teamRequest, String id) {
        if (teamRequest == null && id == null) {
            return null;
        }

        return TeamServiceRequest.builder()
                .id(id)
                .name(teamRequest.getName())
                .historicalReputation(teamRequest.getHistoricalReputation())
                .balance(teamRequest.getBalance())
                .date(teamRequest.getDate())
                .build();
    }

    static TeamServiceRequest toServiceWithoutId(TeamControllerRequest teamRequest) {
        if (teamRequest == null) {
            return null;
        }

        return TeamServiceRequest.builder()
                .name(teamRequest.getName())
                .historicalReputation(teamRequest.getHistoricalReputation())
                .balance(teamRequest.getBalance())
                .date(teamRequest.getDate())
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
