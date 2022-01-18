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

    public TeamControllerResponse save(TeamControllerRequest team) {
        TeamServiceRequest teamSave = toTeamService(team);
        TeamServiceResponse teamResponse = facade.save(teamSave);
        return toTeamResponseController(teamResponse);
    }

    public TeamControllerResponse update(TeamControllerRequest team, String id) {
        TeamServiceRequest teamSave = toTeamService(team);
        TeamServiceResponse teamResponse = facade.update(teamSave, id);
        return toTeamResponseController(teamResponse);
    }

    public TeamPatchControllerResponse patch(TeamPatchControllerRequest team, String id) {
        TeamPatchServiceRequest teamSave = toTeamPatchService(team);
        TeamPatchServiceResponse teamResponse = facade.patch(teamSave, id);
        return toTeamResponseControllerPatch(teamResponse);
    }

    public void delete(String id) {
        facade.delete(id);
    }

    public TeamControllerResponse find(String id) {
        TeamServiceResponse teamController = facade.find(id);
        return toTeamResponseController(teamController);
    }

    public List<TeamControllerResponse> findAll() {
        return facade.findAll().stream()
                .map(TeamControllerResponseMapper::toTeamResponseController)
                .toList();
    }
}
