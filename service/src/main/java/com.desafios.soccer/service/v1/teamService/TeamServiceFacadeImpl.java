package com.desafios.soccer.service.v1.teamService;

import com.desafios.soccer.exceptions.notfound.NotFoundException;
import com.desafios.soccer.model.entity.Team;
import com.desafios.soccer.repository.TeamRepository;
import com.desafios.soccer.service.mapper.response.TeamServiceResponseMapper;
import com.desafios.soccer.service.model.request.TeamServiceRequest;
import com.desafios.soccer.service.model.response.TeamServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import static com.desafios.soccer.service.mapper.request.TeamServiceRequestMapper.toTeamEntity;
import static com.desafios.soccer.service.mapper.response.TeamServiceResponseMapper.toTeamResponse;

@AllArgsConstructor
@Component
public class TeamServiceFacadeImpl implements TeamServiceFacade {

    private final TeamRepository teamRepository;

    public TeamServiceResponse saveTeam(TeamServiceRequest team) {
        Team teamSave = toTeamEntity(team);
        Team teamResponse = teamRepository.save(teamSave);
        return toTeamResponse(teamResponse);
    }

    public TeamServiceResponse updateTeamById(TeamServiceRequest team, String id) {
        Team TeamName = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        team.setId(TeamName.getId());
        Team teamEntity = toTeamEntity(team);
        Team teamSave = teamRepository.save(teamEntity);
        return toTeamResponse(teamSave);
    }

    public void deleteTeamById(String id) {
        teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        teamRepository.deleteById(id);
    }

    public List<TeamServiceResponse> findAllTeams() {
        return teamRepository.findAll().stream()
                .map(TeamServiceResponseMapper::toTeamResponse)
                .collect(Collectors.toList());
    }

    public TeamServiceResponse findTeamById(String id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toTeamResponse(team);
    }

}