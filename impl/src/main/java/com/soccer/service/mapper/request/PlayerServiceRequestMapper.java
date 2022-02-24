package com.soccer.service.mapper.request;

import com.soccer.model.entity.PlayerEntity;
import com.soccer.service.model.request.PlayerServiceRequest;

import java.util.Optional;

public class PlayerServiceRequestMapper {
    public static PlayerEntity toEntity(PlayerServiceRequest playerRequest) {

        return Optional.ofNullable(playerRequest)
                .map(playerServiceRequest -> PlayerEntity.builder()
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
