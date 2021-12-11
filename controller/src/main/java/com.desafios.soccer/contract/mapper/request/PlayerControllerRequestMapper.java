package com.desafios.soccer.contract.mapper.request;

import com.desafios.soccer.contract.model.request.PlayerControllerRequest;
import com.desafios.soccer.service.model.request.PlayerServiceRequest;

//@Mapper()
public interface PlayerControllerRequestMapper {

    static PlayerServiceRequest toPlayerService(PlayerControllerRequest playerRequest) {
        if (playerRequest == null) {
            return null;
        }

        return PlayerServiceRequest.builder()
                .id(playerRequest.getId())
                .name(playerRequest.getName())
                .age(playerRequest.getAge())
                .currentTeam(playerRequest.getCurrentTeam())
                .historicalReputation(playerRequest.getHistoricalReputation())
                .financialAppetite(playerRequest.getFinancialAppetite())
                .price(playerRequest.getPrice())
                .build();
    }
/*

    static PlayerServiceRequest toPlayerService(PlayerControllerRequest playerRequest) {
       return Mappers.getMapper(PlayerControllerRequestMapper.class)
                .mapper(playerRequest);
    }

    PlayerServiceRequest mapper(PlayerControllerRequest playerRequest);
*/

}
