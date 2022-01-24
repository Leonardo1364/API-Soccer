package com.soccer.contract.mapper.request;

import com.soccer.contract.model.request.TeamPatchControllerRequest;
import com.soccer.service.model.request.TeamPatchServiceRequest;

public interface TeamPatchControllerRequestMapper {

    static TeamPatchServiceRequest toPatchService(TeamPatchControllerRequest teamPatch) {
        if (teamPatch == null)
            return null;

        return TeamPatchServiceRequest.builder()
                .id(teamPatch.getId())
                .name(teamPatch.getName())
                .build();
    }
}
