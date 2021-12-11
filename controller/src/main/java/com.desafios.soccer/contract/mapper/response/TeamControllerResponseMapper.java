package com.desafios.soccer.contract.mapper.response;

import com.desafios.soccer.contract.model.response.TeamControllerResponse;
import com.desafios.soccer.service.model.response.TeamServiceResponse;

//@Mapper
public interface TeamControllerResponseMapper {
    static TeamControllerResponse toTeamResponseController(TeamServiceResponse teamServiceResponse) {
      if (teamServiceResponse == null) {
            return null;
        }

        return TeamControllerResponse.builder()
                .id(teamServiceResponse.getId())
                .name(teamServiceResponse.getName())
                .historicalReputation(teamServiceResponse.getHistoricalReputation())
                .balance(teamServiceResponse.getBalance())
                .date(teamServiceResponse.getDate())
                .build();
    }
/*

        static TeamControllerResponse toTeamResponseController(TeamServiceResponse teamServiceResponse) {
            return Mappers.getMapper(TeamControllerResponseMapper.class)
                    .mapperResponse(teamServiceResponse);
        }

        TeamControllerResponse mapperResponse(TeamServiceResponse teamServiceResponse);
*/


}
