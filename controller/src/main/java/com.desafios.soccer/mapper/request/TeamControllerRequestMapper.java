package com.desafios.soccer.mapper.request;

import com.desafios.soccer.model.request.TeamControllerRequest;
import com.desafios.soccer.service.model.request.TeamServiceRequest;

//@Mapper()
public interface TeamControllerRequestMapper {

    static TeamServiceRequest toTeamService(TeamControllerRequest teamRequest) {
        if (teamRequest == null) {
            return null;
        }

        return TeamServiceRequest.builder()
                .id(teamRequest.getId())
                .name(teamRequest.getName())
                .historicalReputation(teamRequest.getHistoricalReputation())
                .balance(teamRequest.getBalance())
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
