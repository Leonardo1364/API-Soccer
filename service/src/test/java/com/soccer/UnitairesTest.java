package com.soccer;

import com.soccer.model.entity.LeagueEntity;
import com.soccer.model.entity.TeamEntity;
import com.soccer.repository.TeamRepository;
import com.soccer.service.v1.teamservice.TeamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class UnitairesTest {

    @Autowired
    TeamService teamService;

    @MockBean
    TeamRepository teamRepository;

    @Test
    void testDoInsertTeam() {

        TeamEntity teamEntity = TeamEntity.builder()
                .name("Testing")
                .historicalReputation("Testing")
                .balance(1.0)
                .date(LocalDate.now())
                .league(new LeagueEntity(1L, "Testing", "Testing"))
                .build();

        Mockito.when(teamRepository.save(teamEntity)).thenReturn(teamEntity);

        Assertions.assertTrue(() -> teamEntity.getId().isBlank());
        Mockito.verify(teamRepository, Mockito.atLeastOnce()).save(teamEntity);

    }

}
