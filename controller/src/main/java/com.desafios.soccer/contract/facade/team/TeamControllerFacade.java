package com.desafios.soccer.contract.facade.team;

import com.desafios.soccer.contract.model.request.TeamControllerRequest;
import com.desafios.soccer.contract.model.request.TeamPatchControllerRequest;
import com.desafios.soccer.contract.model.response.TeamControllerResponse;
import com.desafios.soccer.contract.model.response.TeamPatchControllerResponse;

import java.util.List;

public interface TeamControllerFacade {

    TeamControllerResponse saveTeam(TeamControllerRequest team);

    TeamControllerResponse updateTeamById(TeamControllerRequest team, String id);

    TeamPatchControllerResponse patchTeam(TeamPatchControllerRequest team, String id);

    void deleteTeamById(String id);

    TeamControllerResponse findTeamById(String id);

    TeamPatchControllerResponse findTeamPatch(String id);

    List<TeamControllerResponse> findAllTeams();
}
