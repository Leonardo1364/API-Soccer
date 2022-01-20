package com.desafios.soccer.service.mapper.teamWithLeague;

import com.desafios.soccer.model.entity.League;
import com.desafios.soccer.service.model.request.TeamServiceRequest;
import org.modelmapper.ModelMapper;

//@Mapper
public class TeamMappertoLeague {

     private static ModelMapper modelMaper;

    /*static TeamServiceRequest mapLeague(TeamServiceRequest team, League id) {
        return Mappers.getMapper(TeamMappertoLeague.class)
                .leagueToServiceResponse(team, id);
    }

    TeamServiceRequest leagueToServiceResponse(TeamServiceRequest team, League id);

    @AfterMapping
    default void mapLeague(@MappingTarget Team team) {
        League leagueToTeam = League.builder()
                .id(team.getLeague().getId())
                .name(team.getLeague().getName())
                .country(team.getLeague().getCountry())
                .build();
    }*/

    public static TeamServiceRequest mapLeague(TeamServiceRequest team, League id) {
        return modelMaper.map(team, TeamServiceRequest.class, id.getName());
    }
}
