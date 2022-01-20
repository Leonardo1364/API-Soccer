package com.desafios.soccer.service.mapper.request;

import com.desafios.soccer.model.entity.Team;
import com.desafios.soccer.service.model.request.TeamPatchServiceRequest;

public interface TeamPatchServiceRequestMapper {

    static Team toPatchEntity(TeamPatchServiceRequest teamRequest) {
        if (teamRequest == null) {
            return null;
        }

        return Team.builder()
                .id(teamRequest.getId())
                .name(teamRequest.getName())
                .build();
    }
}
