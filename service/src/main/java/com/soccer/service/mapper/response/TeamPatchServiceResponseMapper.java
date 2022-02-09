package com.soccer.service.mapper.response;

import com.soccer.model.entity.TeamEntity;
import com.soccer.service.model.response.TeamPatchServiceResponse;

import java.util.Optional;

public class TeamPatchServiceResponseMapper {

    public static TeamPatchServiceResponse toPatchResponse(TeamEntity teamResponse) {

        return Optional.ofNullable(teamResponse)
                .map(teamEntity -> TeamPatchServiceResponse.builder()
                    .id(teamResponse.getId())
                    .name(teamResponse.getName())
                    .build())
                .orElse(null);
    }
}
