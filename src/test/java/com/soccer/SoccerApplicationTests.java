package com.soccer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soccer.contract.facade.team.TeamControllerFacadeImpl;
import com.soccer.contract.model.request.TeamControllerRequest;
import com.soccer.contract.v1.TeamController;
import com.soccer.repository.TeamRepository;
import com.soccer.restTemplate.ConsumerApi;
import com.soccer.service.v1.teamService.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

@SpringBootTest(classes = {TeamController.class, TeamService.class, TeamControllerFacadeImpl.class})
@AutoConfigureMockMvc
@WebMvcTest
@ExtendWith(SpringExtension.class)
class SoccerApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	TeamRepository teamRepository;

	@MockBean
	ConsumerApi consumerApi;

	@Test
	void post_test() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		TeamControllerRequest teamControllerRequest = TeamControllerRequest.builder()
				.name("testing")
				.historicalReputation("testing")
				.balance(1.0)
				.date(LocalDate.now())
				.leagueId(1L)
				.build();
	}

}
