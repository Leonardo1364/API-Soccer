package com.soccer.contract.mapper.response;

import com.soccer.contract.model.response.PlayerControllerResponse;
import com.soccer.service.model.response.PlayerServiceResponse;

import java.util.Optional;

public class PlayerControllerResponseMapper {

    public static PlayerControllerResponse toResponseController(PlayerServiceResponse playerResponse) {

        return Optional.ofNullable(playerResponse)
                .map(playerServiceResponse -> PlayerControllerResponse.builder()
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
