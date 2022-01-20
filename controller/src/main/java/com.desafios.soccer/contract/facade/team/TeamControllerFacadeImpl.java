package com.desafios.soccer.contract.facade.team;

import com.desafios.soccer.contract.mapper.response.TeamControllerResponseMapper;
import com.desafios.soccer.contract.model.request.TeamControllerRequest;
import com.desafios.soccer.contract.model.request.TeamPatchControllerRequest;
import com.desafios.soccer.contract.model.response.TeamControllerResponse;
import com.desafios.soccer.contract.model.response.TeamPatchControllerResponse;
import com.desafios.soccer.service.model.response.TeamPatchServiceResponse;
import com.desafios.soccer.service.model.response.TeamServiceResponse;
import com.desafios.soccer.service.v1.teamService.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.desafios.soccer.contract.mapper.request.TeamControllerRequestMapper.toServiceWithId;
import static com.desafios.soccer.contract.mapper.request.TeamControllerRequestMapper.toServiceWithoutId;
import static com.desafios.soccer.contract.mapper.request.TeamPatchControllerRequestMapper.toPatchService;
import static com.desafios.soccer.contract.mapper.response.TeamControllerResponseMapper.toResponseController;
import static com.desafios.soccer.contract.mapper.response.TeamPatchControllerResponseMapper.toResponseControllerPatch;

@AllArgsConstructor
@Component
public class TeamControllerFacadeImpl implements TeamControllerFacade {

    private final TeamService facade;

    public TeamControllerResponse save(TeamControllerRequest team) {
        TeamServiceResponse teamResponse = facade.save(toServiceWithoutId(team));
        return toResponseController(teamResponse);
    }

    public TeamControllerResponse update(TeamControllerRequest team, String id) {
        TeamServiceResponse teamResponse = facade.update(toServiceWithId(team, id));
        return toResponseController(teamResponse);
    }

    public TeamPatchControllerResponse patch(TeamPatchControllerRequest team, String id) {
        TeamPatchServiceResponse teamResponse = facade.patch(toPatchService(team), id);
        return toResponseControllerPatch(teamResponse);
    }

    public void delete(String id) {
        facade.delete(id);
    }

    public TeamControllerResponse findById(String id) {
        return toResponseController(facade.findById(id));
    }

    public List<TeamControllerResponse> findAll() {
        return facade.findAll().stream()
                .map(TeamControllerResponseMapper::toResponseController)
                .toList();
    }
}
