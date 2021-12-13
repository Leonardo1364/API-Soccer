package com.desafios.soccer.service.v1.teamService;

import com.desafios.soccer.exceptions.notfound.NotFoundException;
import com.desafios.soccer.model.entity.Team;
import com.desafios.soccer.repository.TeamRepository;
import com.desafios.soccer.service.mapper.response.TeamServiceResponseMapper;
import com.desafios.soccer.service.model.request.TeamPatchServiceRequest;
import com.desafios.soccer.service.model.request.TeamServiceRequest;
import com.desafios.soccer.service.model.response.TeamPatchServiceResponse;
import com.desafios.soccer.service.model.response.TeamServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.desafios.soccer.service.mapper.request.TeamPatchServiceRequestMapper.toTeamPatchEntity;
import static com.desafios.soccer.service.mapper.request.TeamServiceRequestMapper.toTeamEntity;
import static com.desafios.soccer.service.mapper.response.TeamPatchServiceResponseMapper.toTeamPatchResponse;
import static com.desafios.soccer.service.mapper.response.TeamServiceResponseMapper.toTeamResponse;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceResponse saveTeam(TeamServiceRequest team) {
        Team teamSave = toTeamEntity(team);
        Team teamResponse = teamRepository.save(teamSave);
        return toTeamResponse(teamResponse);
    }

    public TeamServiceResponse updateTeamById(TeamServiceRequest team, String id) {
        team.setId(id);
        Team teamEntity = toTeamEntity(team);
        Team teamSave = teamRepository.save(teamEntity);
        return toTeamResponse(teamSave);
    }

    public TeamPatchServiceResponse patchTeam(TeamPatchServiceRequest team, String id) {
        Team teamById = teamRepository.findById(id).orElseThrow(() -> new NotFoundException("ID not found"));
        teamById.setName(team.getName());
        Team teamSave = teamRepository.save(teamById);
        return toTeamPatchResponse(teamSave);
    }

    public void deleteTeamById(String id) {
        teamRepository.deleteById(id);
    }

    public TeamServiceResponse findTeamById(String id) {
        Team teamName = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toTeamResponse(teamName);
    }

    public List<TeamServiceResponse> findAllTeams() {
        return teamRepository.findAll().stream()
                .map(TeamServiceResponseMapper::toTeamResponse)
                .toList();
    }

    public TeamPatchServiceResponse findTeamPatch(String id) {
        Team teamName = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toTeamPatchResponse(teamName);
    }

}
