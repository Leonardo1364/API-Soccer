package com.soccer.service.mapper.request;

import com.soccer.model.entity.PlayerEntity;
import com.soccer.service.model.request.PlayerServiceRequest;

//@Mapper
public interface PlayerServiceRequestMapper {
    static PlayerEntity toEntity(PlayerServiceRequest playerRequest) {
        if (playerRequest == null) {
            return null;
        }

        return PlayerEntity.builder()
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
