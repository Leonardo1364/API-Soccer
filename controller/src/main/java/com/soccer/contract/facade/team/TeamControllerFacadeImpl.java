package com.soccer.contract.facade.team;

import com.soccer.contract.mapper.response.TeamControllerResponseMapper;
import com.soccer.contract.mapper.response.TeamPatchControllerResponseMapper;
import com.soccer.contract.model.request.TeamControllerRequest;
import com.soccer.contract.model.request.TeamPatchControllerRequest;
import com.soccer.contract.model.response.TeamControllerResponse;
import com.soccer.contract.model.response.TeamPatchControllerResponse;
import com.soccer.service.model.response.TeamPatchServiceResponse;
import com.soccer.service.model.response.TeamServiceResponse;
import com.soccer.service.v1.teamservice.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.soccer.contract.mapper.request.TeamControllerRequestMapper.toServiceWithId;
import static com.soccer.contract.mapper.request.TeamControllerRequestMapper.toServiceWithoutId;
import static com.soccer.contract.mapper.request.TeamPatchControllerRequestMapper.toPatchServiceWithId;
import static com.soccer.contract.mapper.response.TeamControllerResponseMapper.toResponseController;

@AllArgsConstructor
@Component
public class TeamControllerFacadeImpl implements TeamControllerFacade {

    private final TeamService service;

    public TeamControllerResponse save(TeamControllerRequest team) {
        TeamServiceResponse teamResponse = service.save(toServiceWithoutId(team));
        return toResponseController(teamResponse);
    }

    public TeamControllerResponse update(TeamControllerRequest team, String id) {
        TeamServiceResponse teamResponse = service.update(toServiceWithId(team, id));
        return toResponseController(teamResponse);
    }

    public TeamPatchControllerResponse patch(TeamPatchControllerRequest team, String id) {
        TeamPatchServiceResponse teamResponse = service.patch(toPatchServiceWithId(team, id));
        return TeamPatchControllerResponseMapper.toResponseControllerPatch(teamResponse);
    }

    public void delete(String id) {
        service.delete(id);
    }

    public TeamControllerResponse findById(String id) {
        return toResponseController(service.findById(id));
    }

    public List<TeamControllerResponse> findAll() {
        return service.findAll().stream()
                .map(TeamControllerResponseMapper::toResponseController)
                .toList();
    }
}
