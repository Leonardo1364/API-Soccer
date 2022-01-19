package com.desafios.soccer.service.v1.teamService;

import com.desafios.soccer.service.mapper.teamWithLeague.TeamMappertoLeague;
import com.desafios.soccer.service.model.request.TeamPatchServiceRequest;
import com.desafios.soccer.service.model.request.TeamServiceRequest;
import com.desafios.soccer.service.model.response.TeamPatchServiceResponse;
import com.desafios.soccer.service.model.response.TeamServiceResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import restTemplate.ConsumerApi;

import java.util.List;


@AllArgsConstructor
@Component
public class TeamFacade {

    private TeamService teamService;
    private ConsumerApi consumerApi;

    public TeamServiceResponse save(TeamServiceRequest team) {
        return teamService.save(TeamMappertoLeague.mapLeague(team, consumerApi.findLeague(team.getLeague())));
    }

    public TeamServiceResponse update(TeamServiceRequest team) {
        return teamService.update(team);
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