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

import static com.desafios.soccer.service.mapper.request.TeamServiceRequestMapper.toEntity;
import static com.desafios.soccer.service.mapper.response.TeamPatchServiceResponseMapper.toPatchResponse;
import static com.desafios.soccer.service.mapper.response.TeamServiceResponseMapper.toResponse;

@AllArgsConstructor
@Service
public record TeamService(TeamRepository teamRepository) {

    public TeamServiceResponse save(TeamServiceRequest team) {
        Team teamResponse = teamRepository.save(toEntity(team));
        return toResponse(teamResponse);
    }

    public TeamServiceResponse update(TeamServiceRequest team) {
        Team teamSave = teamRepository.save(toEntity(team));
        return toResponse(teamSave);
    }

    public TeamPatchServiceResponse patch(TeamPatchServiceRequest team, String id) {
        Team teamById = teamRepository.findById(id).orElseThrow(() -> new NotFoundException("ID not found"));
        teamById.setName(team.getName());
        Team teamSave = teamRepository.save(teamById);
        return toPatchResponse(teamSave);
    }

    public void delete(String id) {
        teamRepository.deleteById(id);
    }

    public TeamServiceResponse findById(String id) {
        Team teamName = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toResponse(teamName);
    }

    public List<TeamServiceResponse> findAll() {
        return teamRepository.findAll().stream()
                .map(TeamServiceResponseMapper::toResponse)
                .toList();
    }

    public TeamPatchServiceResponse findPatch(String id) {
        Team teamName = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toPatchResponse(teamName);
    }

}
