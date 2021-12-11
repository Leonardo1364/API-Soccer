package com.desafios.soccer.contract.mapper.response;

import com.desafios.soccer.contract.model.response.PlayerControllerResponse;
import com.desafios.soccer.service.model.response.PlayerServiceResponse;

//@Mapper()
public interface PlayerControllerResponseMapper {

    static PlayerControllerResponse toPlayerResponseController(PlayerServiceResponse playerResponse) {
        if (playerResponse == null) {
            return null;
        }

        return PlayerControllerResponse.builder()
                .id(playerResponse.getId())
                .name(playerResponse.getName())
                .age(playerResponse.getAge())
                .currentTeam(playerResponse.getCurrentTeam())
                .historicalReputation(playerResponse.getHistoricalReputation())
                .financialAppetite(playerResponse.getFinancialAppetite())
                .price(playerResponse.getPrice())
                .build();
    }

/*
    static PlayerControllerResponse toPlayerResponseController(PlayerServiceResponse playerResponse) {
        return Mappers.getMapper(PlayerControllerResponseMapper.class)
                .mapper(playerResponse);
    }

    PlayerControllerResponse mapper(PlayerServiceResponse playerResponse);
    */
}
