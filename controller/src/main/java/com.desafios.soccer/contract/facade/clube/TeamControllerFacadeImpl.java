package com.desafios.soccer.contract.facade.clube;

import com.desafios.soccer.contract.mapper.response.TeamControllerResponseMapper;
import com.desafios.soccer.contract.model.request.TeamControllerRequest;
import com.desafios.soccer.contract.model.response.TeamControllerResponse;
import com.desafios.soccer.service.model.request.TeamServiceRequest;
import com.desafios.soccer.service.model.response.TeamServiceResponse;
import com.desafios.soccer.service.v1.teamService.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.desafios.soccer.contract.mapper.request.TeamControllerRequestMapper.toTeamService;
import static com.desafios.soccer.contract.mapper.response.TeamControllerResponseMapper.toTeamResponseController;

@AllArgsConstructor
@Component
public class TeamControllerFacadeImpl implements TeamControllerFacade {

    private final TeamService facade;

    public TeamControllerResponse saveTeam(TeamControllerRequest team) {
        TeamServiceRequest teamSave = toTeamService(team);
        TeamServiceResponse teamResponse = facade.saveTeam(teamSave);
        return toTeamResponseController(teamResponse);
    }

    public TeamControllerResponse updateTeamById(TeamControllerRequest team, String id) {
        TeamServiceRequest teamSave = toTeamService(team);
        TeamServiceResponse teamResponse = facade.updateTeamById(teamSave, id);
        return toTeamResponseController(teamResponse);
    }

    public TeamControllerResponse patchTeam(TeamControllerRequest team, String id) {
        TeamServiceRequest teamSave = toTeamService(team);
        TeamServiceResponse teamResponse = facade.patchTeam(teamSave, id);
        return toTeamResponseController(teamResponse);
    }

    public void deleteTeamById(String id) {
        facade.deleteTeamById(id);
    }

    public TeamControllerResponse findTeamById(String id) {
        TeamServiceResponse teamController = facade.findTeamById(id);
        return toTeamResponseController(teamController);
    }

    public List<TeamControllerResponse> findAllTeams() {
        return facade.findAllTeams().stream()
                .map(TeamControllerResponseMapper::toTeamResponseController)
                .toList();
    }
}
