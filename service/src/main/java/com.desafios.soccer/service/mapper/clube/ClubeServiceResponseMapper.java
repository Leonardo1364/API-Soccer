package com.desafios.soccer.service.mapper.clube;

import com.desafios.soccer.model.entity.Clube;
import com.desafios.soccer.service.model.clube.ClubeServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClubeServiceResponseMapper {

    static ClubeServiceResponse toClubeResponse(Clube clubeRequest) {
        return Mappers.getMapper(ClubeServiceResponseMapper.class)
                .mapper(clubeRequest);
    }

    ClubeServiceResponse mapper(Clube clubeRequest);

}
