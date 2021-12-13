package com.desafios.soccer.contract.facade.team;

import com.desafios.soccer.contract.mapper.response.TeamControllerResponseMapper;
import com.desafios.soccer.contract.model.request.TeamControllerRequest;
import com.desafios.soccer.contract.model.request.TeamPatchControllerRequest;
import com.desafios.soccer.contract.model.response.TeamControllerResponse;
import com.desafios.soccer.contract.model.response.TeamPatchControllerResponse;
import com.desafios.soccer.service.model.request.TeamPatchServiceRequest;
import com.desafios.soccer.service.model.request.TeamServiceRequest;
import com.desafios.soccer.service.model.response.TeamPatchServiceResponse;
import com.desafios.soccer.service.model.response.TeamServiceResponse;
import com.desafios.soccer.service.v1.teamService.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.desafios.soccer.contract.mapper.request.TeamControllerRequestMapper.toTeamService;
import static com.desafios.soccer.contract.mapper.request.TeamPatchControllerRequestMapper.toTeamPatchService;
import static com.desafios.soccer.contract.mapper.response.TeamControllerResponseMapper.toTeamResponseController;
import static com.desafios.soccer.contract.mapper.response.TeamPatchControllerResponseMapper.toTeamResponseControllerPatch;

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

    public TeamPatchControllerResponse patchTeam(TeamPatchControllerRequest team, String id) {
        TeamPatchServiceRequest teamSave = toTeamPatchService(team);
        TeamPatchServiceResponse teamResponse = facade.patchTeam(teamSave, id);
        return toTeamResponseControllerPatch(teamResponse);
    }

    public void deleteTeamById(String id) {
        facade.deleteTeamById(id);
    }

    public TeamControllerResponse findTeamById(String id) {
        TeamServiceResponse teamController = facade.findTeamById(id);
        return toTeamResponseController(teamController);
    }

    @Override
    public TeamPatchControllerResponse findTeamPatch(String id) {
        TeamPatchServiceResponse teamPatchController = facade.findTeamPatch(id);
        return toTeamResponseControllerPatch(teamPatchController);
    }

    public List<TeamControllerResponse> findAllTeams() {
        return facade.findAllTeams().stream()
                .map(TeamControllerResponseMapper::toTeamResponseController)
                .toList();
    }
}
