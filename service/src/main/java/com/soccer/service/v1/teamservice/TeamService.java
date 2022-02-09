package com.soccer.service.v1.teamservice;

import com.soccer.exceptions.notfound.NotFoundException;
import com.soccer.model.entity.TeamEntity;
import com.soccer.repository.TeamRepository;
import com.soccer.resttemplate.ConsumerApi;
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

import static com.soccer.service.mapper.request.TeamPatchServiceRequestMapper.toPatchEntity;
import static com.soccer.service.mapper.request.TeamServiceRequestMapper.toEntity;
import static com.soccer.service.mapper.response.TeamPatchServiceResponseMapper.toPatchResponse;
import static com.soccer.service.mapper.response.TeamServiceResponseMapper.toResponse;

/*@AllArgsConstructor
@NoArgsConstructor*/
@Service
public class TeamService {

    private static final String OBJECT_NOT_FOUND = "ID not found";

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ConsumerApi consumerApi;

    public TeamService(TeamRepository teamRepository, ConsumerApi consumerApi) {
        this.teamRepository = teamRepository;
        this.consumerApi = consumerApi;
    }

    public TeamService() {}

    public TeamServiceResponse save(TeamServiceRequest teamRequest) {
        TeamEntity teamResponse = teamRepository.save(toEntity(teamRequest,
                consumerApi.find(teamRequest.getLeagueId())));

        return toResponse(teamResponse);
    }

    public TeamServiceResponse update(TeamServiceRequest team) {
        TeamEntity teamSave = teamRepository.save(toEntity(team,
                consumerApi.find(team.getLeagueId())));

        return toResponse(teamSave);
    }

    public TeamPatchServiceResponse patch(TeamPatchServiceRequest team) {
        TeamEntity teamSave = teamRepository.save(toPatchEntity(team));
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
