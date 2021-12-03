package com.desafios.soccer.service.mapper.response;

import com.desafios.soccer.model.entity.Team;
import com.desafios.soccer.service.model.response.TeamServiceResponse;

//@Mapper
public interface TeamServiceResponseMapper {

    static TeamServiceResponse toTeamResponse(Team teamResponse) {
        if (teamResponse == null) {
            return null;
        }

        return TeamServiceResponse.builder()
                .id(teamResponse.getId())
                .name(teamResponse.getName())
                .historicalReputation(teamResponse.getHistoricalReputation())
                .balance(teamResponse.getBalance())
                .build();
    }
/*

    static TeamServiceResponse toTeamResponse(Team teamResponse) {
        return Mappers.getMapper(TeamServiceResponseMapper.class)
                .mapper(teamResponse);
    }

    TeamServiceResponse mapper(Team teamResponse);
*/

}
