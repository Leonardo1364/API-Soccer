package com.soccer;

import com.soccer.model.entity.LeagueEntity;
import com.soccer.model.entity.TeamEntity;
import com.soccer.model.response.LeagueIntegration;
import com.soccer.repository.TeamRepository;
import com.soccer.resttemplate.ConsumerApi;
import com.soccer.service.model.request.TeamServiceRequest;
import com.soccer.service.model.response.LeagueServiceResponse;
import com.soccer.service.model.response.TeamServiceResponse;
import com.soccer.service.v1.teamservice.TeamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UnitairesTest {

    @InjectMocks
    TeamService teamService;

    @Mock
    TeamRepository teamRepository;

    @Mock
    ConsumerApi consumerApi;

    @Test
    void testDoInsertTeam() throws Exception {
        TeamServiceRequest teamServiceRequest = TeamServiceRequest.builder()
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .leagueId(1L)
                .build();
        LeagueIntegration leagueIntegration = LeagueIntegration.builder()
                .id(1L)
                .name("Testing")
                .country("Testing")
                .build();
        TeamEntity teamEntityRequest = TeamEntity.builder()
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .league(new LeagueEntity(1L, "Testing", "Testing"))
                .build();
        TeamEntity teamEntityResponse = TeamEntity.builder()
                .id("Testing")
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .league(new LeagueEntity(1L, "Testing", "Testing"))
                .build();
        TeamServiceResponse teamExpected = TeamServiceResponse.builder()
                .id("Testing")
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .league(new LeagueServiceResponse(1L, "Testing", "Testing"))
                .build();

        Mockito.when(teamRepository.save(teamEntityRequest)).thenReturn(teamEntityResponse);
        Mockito.when(consumerApi.find(1L)).thenReturn(leagueIntegration);

        Assertions.assertEquals(teamExpected, teamService.save(teamServiceRequest));
    }

}
