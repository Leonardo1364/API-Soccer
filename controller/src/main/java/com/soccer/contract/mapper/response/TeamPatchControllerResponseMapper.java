package com.soccer.contract.mapper.response;

import com.soccer.contract.model.response.TeamPatchControllerResponse;
import com.soccer.service.model.response.TeamPatchServiceResponse;

public interface TeamPatchControllerResponseMapper {

    static TeamPatchControllerResponse toResponseControllerPatch(TeamPatchServiceResponse teamPatch) {
        if (teamPatch == null)
            return null;

        return TeamPatchControllerResponse.builder()
                .id(teamPatch.getId())
                .name(teamPatch.getName())
                .build();
    }
}
