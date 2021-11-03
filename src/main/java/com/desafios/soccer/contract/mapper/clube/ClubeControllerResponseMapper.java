package com.desafios.soccer.contract.mapper.clube;

import com.desafios.soccer.contract.model.clube.ClubeControllerResponse;
import com.desafios.soccer.service.model.clube.ClubeServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClubeControllerResponseMapper {

    static ClubeControllerResponse toClubeResponseController(ClubeServiceResponse clubeRequest) {
        return Mappers.getMapper(ClubeControllerResponseMapper.class)
                .mapper(clubeRequest);
    }

    ClubeControllerResponse mapper(ClubeServiceResponse clubeRequest);
}
