package com.soccer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soccer.contract.facade.team.TeamControllerFacadeImpl;
import com.soccer.contract.model.request.TeamControllerRequest;
import com.soccer.contract.v1.TeamController;
import com.soccer.embeddedmongo.MongoConfig;
import com.soccer.model.entity.LeagueEntity;
import com.soccer.model.entity.TeamEntity;
import com.soccer.repository.TeamRepository;
import com.soccer.resttemplate.ConsumerApi;
import com.soccer.service.model.request.TeamServiceRequest;
import com.soccer.service.v1.teamservice.TeamService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureWebMvc
@WebMvcTest
@ContextConfiguration(classes = {TeamController.class, TeamControllerFacadeImpl.class,
		TeamService.class, TeamRepository.class, ConsumerApi.class})
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
				.name("testing")
				.historicalReputation("testing")
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
		TeamEntity teamEntity = TeamEntity.builder()
				.id("Testing")
				.name("testing")
				.historicalReputation("Testing")
				.balance(1.0)
				.league(new LeagueEntity(1L, "Testing", "Testing"))
				.build();

		ObjectMapper objectMapper = new ObjectMapper();

		Mockito.when(teamRepository.save(teamEntity)).thenReturn(teamEntity);
		mockMvc.perform(post("http://localhost:8080/v1/team/")
				.contentType(APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(teamControllerRequest))
				.content(objectMapper.writeValueAsString(teamServiceRequest)))
				.andExpect(status().isCreated());
	}

	@Test
	void getAll_test() throws Exception {
		mockMvc.perform(get("/v1/team"))
				.andExpect(status().isOk());
	}

	@Test
	void getById_test() throws Exception {
		LeagueEntity leagueEntity = LeagueEntity.builder()
				.id(1L)
				.name("Testing")
				.country("Testing")
				.build();

		Optional<TeamEntity> teamEntity =
				Optional.of(
					new TeamEntity("Testing", "Testing", "Testing", 1.0,
							LocalDate.now(), leagueEntity));

		Mockito.when(teamRepository.findById("Testing")).thenReturn(teamEntity);
		mockMvc.perform(get("/v1/team/Testing"))
				.andExpect(status().isOk());
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
		TeamEntity teamEntity = TeamEntity.builder()
				.id("Testing")
				.name("Testing")
				.historicalReputation("Testing")
				.balance(1.0)
				.league(new LeagueEntity(1L, "Testing", "Testing"))
				.build();

		Mockito.when(teamRepository.findById("Testing")).thenReturn(Optional.of(teamEntity));
		Mockito.when(teamRepository.save(teamEntity)).thenReturn(teamEntity);

		ObjectMapper objectMapper = new ObjectMapper();

		mockMvc.perform(put("http://localhost:8080/v1/team/Testing")
				.contentType(APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(teamControllerRequest))
				.content(objectMapper.writeValueAsString(teamServiceRequest)))
				.andExpect(status().isOk());
	}

	@Test
	void delete_test() throws Exception {
		mockMvc.perform(delete("http://localhost:8080/v1/team/Testing"))
				.andExpect(status().isNoContent());
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
		mockMvc.perform(post("http://localhost:8080/v1/team/")
						.contentType(APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(teamControllerRequest))
						.content(objectMapper.writeValueAsString(teamServiceRequest)))
				.andExpect(status().isBadRequest());
	}

	@Test
	void getById_test_fail() throws Exception {
		Mockito.when(teamRepository.findById("Testing")).thenReturn(Optional.empty());
		mockMvc.perform(get("http://localhost:8080/v1/team/Testing"))
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

		mockMvc.perform(put("http://localhost:8080/v1/team/Testing")
						.contentType(APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(teamControllerRequest))
						.content(objectMapper.writeValueAsString(teamServiceRequest)))
				.andExpect(status().isBadRequest());
	}

	@Test
	void delete_test_fail() throws Exception {
		Mockito.when(teamRepository.findById("Testing")).thenReturn(Optional.empty());
		mockMvc.perform(delete("http://localhost:8080/v1/team/Testing"))
				.andExpect(status().isNoContent());
	}
}
