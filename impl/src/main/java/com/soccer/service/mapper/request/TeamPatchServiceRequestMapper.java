package com.soccer.service.mapper.request;

import com.soccer.model.entity.TeamEntity;
import com.soccer.service.model.request.TeamPatchServiceRequest;

import java.util.Optional;

public class TeamPatchServiceRequestMapper {

    public static TeamEntity toPatchEntity(TeamPatchServiceRequest teamRequest) {

        return Optional.ofNullable(teamRequest)
                .map(teamPatchServiceRequest -> TeamEntity.builder()
                    .id(teamRequest.getId())
                    .name(teamRequest.getName())
                    .build())
                .orElse(null);
    }
}
