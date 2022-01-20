package com.desafios.soccer.contract.facade.team;

import com.desafios.soccer.contract.model.request.TeamControllerRequest;
import com.desafios.soccer.contract.model.request.TeamPatchControllerRequest;
import com.desafios.soccer.contract.model.response.TeamControllerResponse;
import com.desafios.soccer.contract.model.response.TeamPatchControllerResponse;

import java.util.List;

public interface TeamControllerFacade {

    TeamControllerResponse save(TeamControllerRequest team);

    TeamControllerResponse update(TeamControllerRequest team, String id);

    TeamPatchControllerResponse patch(TeamPatchControllerRequest team, String id);

    void delete(String id);

    TeamControllerResponse findById(String id);

    List<TeamControllerResponse> findAll();
}
