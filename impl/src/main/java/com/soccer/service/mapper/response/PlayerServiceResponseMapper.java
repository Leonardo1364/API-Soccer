package com.soccer.service.mapper.response;

import com.soccer.model.entity.PlayerEntity;
import com.soccer.service.model.response.PlayerServiceResponse;

import java.util.Optional;

public class PlayerServiceResponseMapper {

    public static PlayerServiceResponse toResponse(PlayerEntity playerResponse) {

        return Optional.ofNullable(playerResponse)
                .map(playerEntity -> PlayerServiceResponse.builder()
                    .id(playerResponse.getId())
                    .name(playerResponse.getName())
                    .age(playerResponse.getAge())
                    .currentTeam(playerResponse.getCurrentTeam())
                    .historicalReputation(playerResponse.getHistoricalReputation())
                    .financialAppetite(playerResponse.getFinancialAppetite())
                    .price(playerResponse.getPrice())
                    .build())
                .orElse(null);
    }

}
