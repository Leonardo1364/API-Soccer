package com.desafios.soccer.service.v1.teamService;

import com.desafios.soccer.service.model.request.TeamPatchServiceRequest;
import com.desafios.soccer.service.model.request.TeamServiceRequest;
import com.desafios.soccer.service.model.response.TeamPatchServiceResponse;
import com.desafios.soccer.service.model.response.TeamServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class TeamFacade {

    private TeamService teamService;

    public TeamServiceResponse saveTeam(TeamServiceRequest team) {
        return teamService.saveTeam(team);
    }

    public TeamServiceResponse updateTeamById(TeamServiceRequest team, String id) {
        TeamServiceResponse teamById = teamService.findTeamById(id);
        return teamService.updateTeamById(team, teamById.getId());
    }

    public TeamPatchServiceResponse patchTeam(TeamPatchServiceRequest team, String id) {
        TeamPatchServiceResponse teamUpdate = teamService.findTeamPatch(id);
        return teamService.patchTeam(team, teamUpdate.getName());
    }

    public void deleteTeamById(String id) {
        teamService.findTeamById(id);
        teamService.deleteTeamById(id);
    }

    public TeamServiceResponse findTeamById(String id) {
        teamService.findTeamById(id);
        return teamService.findTeamById(id);
    }

    public List<TeamServiceResponse> findAllTeams() {
        return teamService.findAllTeams();
    }

}