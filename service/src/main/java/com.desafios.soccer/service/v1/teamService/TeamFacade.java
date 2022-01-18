package com.desafios.soccer.service.v1.teamService;

import com.desafios.soccer.service.mapper.request.TeamMappertoLeague;
import com.desafios.soccer.service.model.request.TeamPatchServiceRequest;
import com.desafios.soccer.service.model.request.TeamServiceRequest;
import com.desafios.soccer.service.model.response.TeamPatchServiceResponse;
import com.desafios.soccer.service.model.response.TeamServiceResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import restTemplate.ConsumerApi;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class TeamFacade {

    private TeamService teamService;
//    private final ConsumerApi consumerApi;

    public TeamServiceResponse save(TeamServiceRequest team) {
        ConsumerApi consumerApi = new ConsumerApi();
        return teamService.save(TeamMappertoLeague.mapLeague(team, consumerApi.findLeague(team.getLeague())));
    }

    public TeamServiceResponse update(TeamServiceRequest team, String id) {
        TeamServiceResponse teamById = teamService.find(id);
        return teamService.update(team, teamById.getId());
    }

    public TeamPatchServiceResponse patch(TeamPatchServiceRequest team, String id) {
        TeamPatchServiceResponse teamUpdate = teamService.findPatch(id);
        return teamService.patch(team, teamUpdate.getName());
    }

    public void delete(String id) {
        teamService.find(id);
        teamService.delete(id);
    }

    public TeamServiceResponse find(String id) {
        teamService.find(id);
        return teamService.find(id);
    }

    public List<TeamServiceResponse> findAll() {
        return teamService.findAll();
    }

}