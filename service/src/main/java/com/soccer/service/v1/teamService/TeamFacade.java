package com.soccer.service.v1.teamService;

import com.soccer.service.model.request.TeamPatchServiceRequest;
import com.soccer.service.model.request.TeamServiceRequest;
import com.soccer.service.model.response.TeamPatchServiceResponse;
import com.soccer.service.model.response.TeamServiceResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class TeamFacade {

    private TeamService teamService;

    public TeamServiceResponse save(TeamServiceRequest team) {
        return teamService.save(team);
    }

    public TeamServiceResponse update(TeamServiceRequest team) {
        return teamService.update(team);
    }

    public TeamPatchServiceResponse patch(TeamPatchServiceRequest team, String id) {
        TeamPatchServiceResponse teamUpdate = teamService.findPatch(id);
        return teamService.patch(team, teamUpdate.getName());
    }

    public void delete(String id) {
        teamService.findById(id);
        teamService.delete(id);
    }

    public TeamServiceResponse findById(String id) {
        teamService.findById(id);
        return teamService.findById(id);
    }

    public List<TeamServiceResponse> findAll() {
        return teamService.findAll();
    }

}