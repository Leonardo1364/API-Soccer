package com.desafios.soccer.service.mapper.response;

import com.desafios.soccer.model.entity.Player;
import com.desafios.soccer.service.model.response.PlayerServiceResponse;

//@Mapper
public interface PlayerServiceResponseMapper {

    static PlayerServiceResponse toPlayerResponse(Player playerResponse) {
        if (playerResponse == null) {
            return null;
        }

        return PlayerServiceResponse.builder()
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
    static PlayerServiceResponse toPlayerResponse(Player playerResponse) {
        return Mappers.getMapper(PlayerServiceResponseMapper.class)
                .mapper(playerResponse);
    }

    PlayerServiceResponse mapper(Player playerResponse);
    */
}
