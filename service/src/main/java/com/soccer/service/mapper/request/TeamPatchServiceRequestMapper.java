package com.soccer.service.mapper.request;

import com.soccer.model.entity.TeamEntity;
import com.soccer.service.model.request.TeamPatchServiceRequest;

public interface TeamPatchServiceRequestMapper {

    static TeamEntity toPatchEntity(TeamPatchServiceRequest teamRequest) {
        if (teamRequest == null) {
            return null;
        }

        return TeamEntity.builder()
                .id(teamRequest.getId())
                .name(teamRequest.getName())
                .build();
    }
}
