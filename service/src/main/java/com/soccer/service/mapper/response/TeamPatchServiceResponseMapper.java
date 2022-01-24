package com.soccer.service.mapper.response;

import com.soccer.model.entity.TeamEntity;
import com.soccer.service.model.response.TeamPatchServiceResponse;

public interface TeamPatchServiceResponseMapper {

    static TeamPatchServiceResponse toPatchResponse(TeamEntity teamResponse) {
        if (teamResponse == null) {
            return null;
        }

        return TeamPatchServiceResponse.builder()
                .id(teamResponse.getId())
                .name(teamResponse.getName())
                .build();
    }
}
