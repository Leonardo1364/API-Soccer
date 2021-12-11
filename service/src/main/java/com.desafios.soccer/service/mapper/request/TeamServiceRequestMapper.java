package com.desafios.soccer.service.mapper.request;

import com.desafios.soccer.model.entity.Team;
import com.desafios.soccer.service.model.request.TeamServiceRequest;

//@Mapper
public interface TeamServiceRequestMapper {

    static Team toTeamEntity(TeamServiceRequest teamRequest) {
        if (teamRequest == null) {
            return null;
        }

        return Team.builder()
                .id(teamRequest.getId())
                .name(teamRequest.getName())
                .historicalReputation(teamRequest.getHistoricalReputation())
                .balance(teamRequest.getBalance())
                .date(teamRequest.getDate())
                .build();
    }
    /*static Team toTeamEntity(TeamServiceRequest teamRequest) {
        return Mappers.getMapper(TeamServiceRequestMapper.class)
                .mapper(teamRequest);
    }

    Team mapper(TeamServiceRequest teamRequest);*/

}
