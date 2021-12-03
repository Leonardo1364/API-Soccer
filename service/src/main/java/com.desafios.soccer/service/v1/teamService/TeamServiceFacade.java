package com.desafios.soccer.service.v1.teamService;

import com.desafios.soccer.service.model.request.TeamServiceRequest;
import com.desafios.soccer.service.model.response.TeamServiceResponse;
import java.util.List;

public interface TeamServiceFacade {

    TeamServiceResponse saveTeam(TeamServiceRequest team);

    TeamServiceResponse updateTeamById(TeamServiceRequest team, String id);

    void deleteTeamById(String id);

    TeamServiceResponse findTeamById(String id);

    List<TeamServiceResponse> findAllTeams();

}
