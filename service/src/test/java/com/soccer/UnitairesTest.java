package com.soccer;

import com.soccer.model.entity.LeagueEntity;
import com.soccer.model.entity.TeamEntity;
import com.soccer.repository.TeamRepository;
import com.soccer.resttemplate.ConsumerApi;
import com.soccer.service.v1.teamservice.TeamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {TeamService.class, TeamRepository.class, TeamEntity.class, ConsumerApi.class})
@ExtendWith(MockitoExtension.class)
class UnitairesTest {

    @Autowired
    TeamService teamService;

    @MockBean
    TeamRepository teamRepository;

    @Test
    void testDoInsertTeam() {
        TeamEntity teamEntity = TeamEntity.builder()
                .id("Testing")
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .league(new LeagueEntity(1L, "Testing", "Testing"))
                .build();

        Mockito.when(teamRepository.save(teamEntity)).thenReturn(teamEntity);

        var response = Mockito.verify(teamRepository, Mockito.atLeastOnce()).save(teamEntity);
        Assertions.assertEquals(response, teamEntity);

    }

}
