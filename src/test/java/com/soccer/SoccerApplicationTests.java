package com.soccer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soccer.contract.facade.team.TeamControllerFacadeImpl;
import com.soccer.contract.model.request.TeamControllerRequest;
import com.soccer.contract.model.response.LeagueControllerResponse;
import com.soccer.contract.model.response.TeamControllerResponse;
import com.soccer.contract.v1.TeamController;
import com.soccer.model.entity.LeagueEntity;
import com.soccer.model.entity.TeamEntity;
import com.soccer.model.response.LeagueIntegration;
import com.soccer.repository.TeamRepository;
import com.soccer.resttemplate.ConsumerApi;
import com.soccer.service.model.request.TeamServiceRequest;
import com.soccer.service.v1.teamservice.TeamService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = {TeamController.class, TeamControllerFacadeImpl.class,
        TeamService.class, TeamRepository.class, ConsumerApi.class, LeagueEntity.class})
class SoccerApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TeamRepository teamRepository;

    @MockBean
    ConsumerApi consumerApi;

    @Test
    void post_test() throws Exception {
        TeamControllerRequest teamControllerRequest = TeamControllerRequest.builder()
                .id("Testing")
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .leagueId(1L)
                .build();
        TeamServiceRequest teamServiceRequest = TeamServiceRequest.builder()
                .id("Testing")
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
        TeamControllerResponse teamExpected = TeamControllerResponse.builder()
                .id("Testing")
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .league(new LeagueControllerResponse(1L, "Testing", "Testing"))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(teamRepository.save(teamEntityRequest)).thenReturn(teamEntityResponse);
        Mockito.when(consumerApi.find(1L)).thenReturn(leagueIntegration);
        var response = mockMvc.perform(post("/v1/team/")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamControllerRequest))
                        .content(objectMapper.writeValueAsString(teamServiceRequest)))
                .andExpect(status().isCreated());
        var teamActual = new ObjectMapper()
                .readValue(response.andReturn().getResponse().getContentAsString(), TeamControllerResponse.class);
        assertEquals(teamExpected, teamActual);
    }

    @Test
    void getAll_test() throws Exception {
        mockMvc.perform(get("/v1/team/"))
                .andExpect(status().isOk());
    }

    @Test
    void getById_test() throws Exception {
        LeagueEntity leagueEntity = LeagueEntity.builder()
                .id(1L)
                .name("Testing")
                .country("Testing")
                .build();

        LeagueIntegration leagueIntegration = LeagueIntegration.builder()
                .id(1L)
                .name("Testing")
                .country("Testing")
                .build();

        Optional<TeamEntity> teamEntityResponse =
                Optional.of(
                        new TeamEntity("Testing", "Testing", "Testing", 1.0,
                                 null, leagueEntity));

        Mockito.when(teamRepository.findById("Testing")).thenReturn(teamEntityResponse);
        Mockito.when(consumerApi.find(1L)).thenReturn(leagueIntegration);
        var response = mockMvc.perform(get("/v1/team/Testing"))
                .andExpect(status().isOk());
        var actual = new ObjectMapper()
                .readValue(response.andReturn().getResponse().getContentAsString(), TeamControllerResponse.class);
        assertEquals("Testing", actual.getId());
    }

    @Test
    void put_test() throws Exception {

        TeamControllerRequest teamControllerRequest = TeamControllerRequest.builder()
                .id("Testing")
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .leagueId(1L)
                .build();
        TeamServiceRequest teamServiceRequest = TeamServiceRequest.builder()
                .id("Testing")
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
        TeamControllerResponse teamExpected = TeamControllerResponse.builder()
                .id("Testing")
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .league(new LeagueControllerResponse(1L, "Testing", "Testing"))
                .build();

        Mockito.when(teamRepository.findById("Testing")).thenReturn(Optional.of(teamEntityResponse));
        Mockito.when(teamRepository.save(teamEntityRequest)).thenReturn(teamEntityResponse);
        Mockito.when(consumerApi.find(1L)).thenReturn(leagueIntegration);

        ObjectMapper objectMapper = new ObjectMapper();

        var actual = mockMvc.perform(put("v1/team/Testing")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamControllerRequest))
                        .content(objectMapper.writeValueAsString(teamServiceRequest)))
                .andExpect(status().isOk());
        var teamActual = new ObjectMapper()
                .readValue(actual.andReturn().getResponse().getContentAsString(), TeamControllerResponse.class);
        assertEquals(teamExpected, teamActual);
    }

    @Test
    void delete_test() throws Exception {
        var actual = mockMvc.perform(delete("/v1/team/Testing"))
                .andExpect(status().isNoContent());
        var teamActual = new ObjectMapper()
                .readValue(actual.andReturn().getResponse().getContentAsString(), TeamControllerResponse.class);
        assertEquals("", teamActual.getId());
    }


    @Test
    void post_test_fail() throws Exception {
        TeamControllerRequest teamControllerRequest = TeamControllerRequest.builder()
                .id("Testing")
                .name("testing")
                .historicalReputation("testing")
                .balance(1.0)
                .leagueId(1L)
                .build();
        TeamServiceRequest teamServiceRequest = TeamServiceRequest.builder()
                .id("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .leagueId(1L)
                .build();
        TeamEntity teamEntity = TeamEntity.builder()
                .id("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .league(new LeagueEntity(null, "Testing", "Testing"))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(teamRepository.save(teamEntity)).thenReturn(teamEntity);
        mockMvc.perform(post("/v1/team/")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamControllerRequest))
                        .content(objectMapper.writeValueAsString(teamServiceRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getById_test_fail() throws Exception {
        Mockito.when(teamRepository.findById("Testing")).thenReturn(Optional.empty());
        mockMvc.perform(get("/v1/team/Testing"))
                .andExpect(status().isNotFound());
    }

    @Test
    void put_test_fail() throws Exception {
        TeamControllerRequest teamControllerRequest = TeamControllerRequest.builder()
                .id("Testing")
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .leagueId(1L)
                .build();
        TeamServiceRequest teamServiceRequest = TeamServiceRequest.builder()
                .id("Testing")
                .name("Testing")
                .balance(1.0)
                .leagueId(1L)
                .build();
        TeamEntity teamEntity = TeamEntity.builder()
                .id("Testing")
                .name("Testing")
                .balance(1.0)
                .league(new LeagueEntity(1L, "Testing", null))
                .build();

        Mockito.when(teamRepository.findById("Testing")).thenReturn(Optional.of(teamEntity));
        Mockito.when(teamRepository.save(teamEntity)).thenReturn(teamEntity);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(put("/v1/team/Testing")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamControllerRequest))
                        .content(objectMapper.writeValueAsString(teamServiceRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void delete_test_fail() throws Exception {
        Mockito.when(teamRepository.findById("Testing")).thenReturn(Optional.empty());
        mockMvc.perform(delete("/v1/team/Testing"))
                .andExpect(status().isNoContent());
    }
}
