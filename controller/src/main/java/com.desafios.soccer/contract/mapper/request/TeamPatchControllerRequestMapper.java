package com.desafios.soccer.contract.mapper.request;

import com.desafios.soccer.contract.model.request.TeamPatchControllerRequest;
import com.desafios.soccer.service.model.request.TeamPatchServiceRequest;

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
