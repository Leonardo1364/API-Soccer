package com.desafios.soccer.service.mapper.request;

import com.desafios.soccer.model.entity.Player;
import com.desafios.soccer.service.model.request.PlayerServiceRequest;

//@Mapper
public interface PlayerServiceRequestMapper {
    static Player toPlayerEntity(PlayerServiceRequest playerRequest) {
        if (playerRequest == null) {
            return null;
        }

        return Player.builder()
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
    static Player toPlayerEntity(PlayerServiceRequest player) {
      return Mappers.getMapper(PlayerServiceRequestMapper.class)
              .mapper(player);
    }

    Player mapper(PlayerServiceRequest player);
*/

}
