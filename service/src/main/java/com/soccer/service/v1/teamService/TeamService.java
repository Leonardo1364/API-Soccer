package com.soccer.service.v1.teamService;

import com.soccer.exceptions.notfound.NotFoundException;
import com.soccer.model.entity.TeamEntity;
import com.soccer.repository.TeamRepository;
import com.soccer.restTemplate.ConsumerApi;
import com.soccer.service.mapper.response.TeamServiceResponseMapper;
import com.soccer.service.model.request.TeamPatchServiceRequest;
import com.soccer.service.model.request.TeamServiceRequest;
import com.soccer.service.model.response.TeamPatchServiceResponse;
import com.soccer.service.model.response.TeamServiceResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.soccer.service.mapper.request.TeamServiceRequestMapper.toEntity;
import static com.soccer.service.mapper.response.TeamPatchServiceResponseMapper.toPatchResponse;
import static com.soccer.service.mapper.response.TeamServiceResponseMapper.toResponse;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class TeamService {

    private static final String OBJECT_NOT_FOUND = "ID not found";

    private TeamRepository teamRepository;
    private ConsumerApi consumerApi;

    public TeamServiceResponse save(TeamServiceRequest teamRequest) {
        var responseApi = consumerApi.find(teamRequest.getLeagueId());
        var teamEntity = toEntity(teamRequest, responseApi);
        TeamEntity teamResponse = teamRepository.save(teamEntity);
        return toResponse(teamResponse);
    }

    public TeamServiceResponse update(TeamServiceRequest team) {
        var responseApi = consumerApi.find(team.getLeagueId());
        TeamEntity teamSave = teamRepository.save(toEntity(team, responseApi));
        return toResponse(teamSave);
    }

    public TeamPatchServiceResponse patch(TeamPatchServiceRequest team, String id) {
        TeamEntity teamById = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(OBJECT_NOT_FOUND));
        teamById.setName(team.getName());
        TeamEntity teamSave = teamRepository.save(teamById);
        return toPatchResponse(teamSave);
    }

    public void delete(String id) {
        teamRepository.deleteById(id);
    }

    public TeamServiceResponse findById(String id) {
        TeamEntity teamName = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(OBJECT_NOT_FOUND));
        return toResponse(teamName);
    }

    public List<TeamServiceResponse> findAll() {
        return teamRepository.findAll().stream()
                .map(TeamServiceResponseMapper::toResponse)
                .toList();
    }

    public TeamPatchServiceResponse findPatch(String id) {
        TeamEntity teamName = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(OBJECT_NOT_FOUND));
        return toPatchResponse(teamName);
    }

}
