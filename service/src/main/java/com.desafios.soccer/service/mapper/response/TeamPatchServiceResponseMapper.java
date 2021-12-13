package com.desafios.soccer.service.mapper.response;

import com.desafios.soccer.model.entity.Team;
import com.desafios.soccer.service.model.response.TeamPatchServiceResponse;

public interface TeamPatchServiceResponseMapper {

    static TeamPatchServiceResponse toTeamPatchResponse(Team teamResponse) {
        if (teamResponse == null) {
            return null;
        }

        return TeamPatchServiceResponse.builder()
                .id(teamResponse.getId())
                .name(teamResponse.getName())
                .build();
    }
}
