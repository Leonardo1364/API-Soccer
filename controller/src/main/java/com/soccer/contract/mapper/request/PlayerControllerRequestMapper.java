package com.soccer.contract.mapper.request;

import com.soccer.contract.model.request.PlayerControllerRequest;
import com.soccer.service.model.request.PlayerServiceRequest;

import java.util.Optional;

public class PlayerControllerRequestMapper {

    public static PlayerServiceRequest toServiceWithId(PlayerControllerRequest playerRequest, String id) {

        return Optional.ofNullable(playerRequest)
                .map(playerControllerRequest -> PlayerServiceRequest.builder()
                    .id(playerRequest.getId())
                    .name(playerRequest.getName())
                    .age(playerRequest.getAge())
                    .currentTeam(playerRequest.getCurrentTeam())
                    .historicalReputation(playerRequest.getHistoricalReputation())
                    .financialAppetite(playerRequest.getFinancialAppetite())
                    .price(playerRequest.getPrice())
                    .build())
                .orElse(null);
    }

    public static PlayerServiceRequest toServiceWithoutId(PlayerControllerRequest playerRequest) {

        return Optional.ofNullable(playerRequest)
                .map(playerControllerRequest -> PlayerServiceRequest.builder()
                    .id(playerRequest.getId())
                    .name(playerRequest.getName())
                    .age(playerRequest.getAge())
                    .currentTeam(playerRequest.getCurrentTeam())
                    .historicalReputation(playerRequest.getHistoricalReputation())
                    .financialAppetite(playerRequest.getFinancialAppetite())
                    .price(playerRequest.getPrice())
                    .build())
                .orElse(null);
    }

}
