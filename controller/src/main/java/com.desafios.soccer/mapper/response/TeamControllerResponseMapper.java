package com.desafios.soccer.mapper.response;

import com.desafios.soccer.model.response.TeamControllerResponse;
import com.desafios.soccer.service.model.response.TeamServiceResponse;

//@Mapper
public interface TeamControllerResponseMapper {

    static TeamControllerResponse toTeamResponseController(TeamServiceResponse TeamServiceResponse) {
        if (TeamServiceResponse == null) {
            return null;
        }

        return TeamControllerResponse.builder()
                .id(TeamServiceResponse.getId())
                .name(TeamServiceResponse.getName())
                .historicalReputation(TeamServiceResponse.getHistoricalReputation())
                .balance(TeamServiceResponse.getBalance())
                .build();
    }
/*

    static TeamControllerResponse toTeamResponseController(TeamServiceResponse TeamServiceResponse) {
        return Mappers.getMapper(TeamControllerResponseMapper.class)
                .mapperResponse(TeamServiceResponse);
    }

    TeamControllerResponse mapperResponse(TeamServiceResponse TeamServiceResponse);
*/

}
