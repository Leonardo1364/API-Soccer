package com.desafios.soccer.contract.mapper.response;

import com.desafios.soccer.contract.model.response.TeamPatchControllerResponse;
import com.desafios.soccer.service.model.response.TeamPatchServiceResponse;

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
