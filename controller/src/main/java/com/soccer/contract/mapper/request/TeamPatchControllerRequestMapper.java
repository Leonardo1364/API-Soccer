package com.soccer.contract.mapper.request;

import com.soccer.contract.model.request.TeamPatchControllerRequest;
import com.soccer.service.model.request.TeamPatchServiceRequest;

import java.util.Optional;

public class TeamPatchControllerRequestMapper {

    public static TeamPatchServiceRequest toPatchServiceWithId(TeamPatchControllerRequest teamPatch, String id) {

        return Optional.ofNullable(teamPatch)
                .map(teamPatchControllerRequest -> TeamPatchServiceRequest.builder()
                    .id(id)
                    .name(teamPatch.getName())
                    .build())
                .orElse(null);
    }
}
