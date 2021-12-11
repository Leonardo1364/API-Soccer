package com.desafios.soccer.contract.facade.clube;

import com.desafios.soccer.contract.model.request.TeamControllerRequest;
import com.desafios.soccer.contract.model.response.TeamControllerResponse;

import java.util.List;

public interface TeamControllerFacade {

    TeamControllerResponse saveTeam(TeamControllerRequest team);

    TeamControllerResponse updateTeamById(TeamControllerRequest team, String id);

    TeamControllerResponse patchTeam(TeamControllerRequest team, String id);

    void deleteTeamById(String id);

    TeamControllerResponse findTeamById(String id);

    List<TeamControllerResponse> findAllTeams();
}
