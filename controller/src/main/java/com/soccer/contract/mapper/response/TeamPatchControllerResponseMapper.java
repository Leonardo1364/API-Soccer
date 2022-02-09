package com.soccer.contract.mapper.response;

import com.soccer.contract.model.response.TeamPatchControllerResponse;
import com.soccer.service.model.response.TeamPatchServiceResponse;

import java.util.Optional;

public class TeamPatchControllerResponseMapper {

    public static TeamPatchControllerResponse toResponseControllerPatch(TeamPatchServiceResponse teamPatch) {

        return Optional.ofNullable(teamPatch)
                .map(teamPatchServiceResponse -> TeamPatchControllerResponse.builder()
                    .id(teamPatch.getId())
                    .name(teamPatch.getName())
                    .build())
                .orElse(null);
    }
}
