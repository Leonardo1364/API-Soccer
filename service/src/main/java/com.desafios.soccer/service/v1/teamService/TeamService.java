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

import static com.desafios.soccer.service.mapper.request.TeamServiceRequestMapper.toTeamEntity;
import static com.desafios.soccer.service.mapper.response.TeamPatchServiceResponseMapper.toTeamPatchResponse;
import static com.desafios.soccer.service.mapper.response.TeamServiceResponseMapper.toTeamResponse;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceResponse save(TeamServiceRequest team) {
        Team teamResponse = teamRepository.save(toTeamEntity(team));
        return toTeamResponse(teamResponse);
    }

    public TeamServiceResponse update(TeamServiceRequest team) {
        Team teamSave = teamRepository.save(toTeamEntity(team));
        return toTeamResponse(teamSave);
    }

    public TeamPatchServiceResponse patch(TeamPatchServiceRequest team, String id) {
        Team teamById = teamRepository.findById(id).orElseThrow(() -> new NotFoundException("ID not found"));
        teamById.setName(team.getName());
        Team teamSave = teamRepository.save(teamById);
        return toTeamPatchResponse(teamSave);
    }

    public void delete(String id) {
        teamRepository.deleteById(id);
    }

    public TeamServiceResponse find(String id) {
        Team teamName = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toTeamResponse(teamName);
    }

    public List<TeamServiceResponse> findAll() {
        return teamRepository.findAll().stream()
                .map(TeamServiceResponseMapper::toTeamResponse)
                .toList();
    }

    public TeamPatchServiceResponse findPatch(String id) {
        Team teamName = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toTeamPatchResponse(teamName);
    }

}
