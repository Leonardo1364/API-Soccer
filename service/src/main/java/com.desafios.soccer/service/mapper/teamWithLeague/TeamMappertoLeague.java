package com.desafios.soccer.service.mapper.request;

import com.desafios.soccer.model.entity.League;
import com.desafios.soccer.model.entity.Team;
import com.desafios.soccer.service.model.request.TeamServiceRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMappertoLeague {

    /*static TeamServiceRequest leagueToServiceResponse(TeamServiceRequest team, League id) {
        if ( team == null && id == null ) {
            return null;
        }

        return TeamServiceRequest.builder()
                .id(Objects.requireNonNull(team).getLeague().getId())
                .name(team.getLeague().getName())
                .build();


    }*/

    static TeamServiceRequest mapLeague(TeamServiceRequest team, League id) {
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
    }

}
