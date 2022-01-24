package com.soccer.service.mapper.response;

import com.soccer.model.entity.PlayerEntity;
import com.soccer.service.model.response.PlayerServiceResponse;

//@Mapper
public interface PlayerServiceResponseMapper {

    static PlayerServiceResponse toResponse(PlayerEntity playerResponse) {
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
