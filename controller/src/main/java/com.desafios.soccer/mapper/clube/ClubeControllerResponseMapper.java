package com.desafios.soccer.mapper.clube;

import com.desafios.soccer.model.clube.ClubeControllerResponse;
import com.desafios.soccer.service.model.clube.ClubeServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClubeControllerResponseMapper {

    static ClubeControllerResponse toClubeResponseController(ClubeServiceResponse clubeServiceResponse) {
        return Mappers.getMapper(ClubeControllerResponseMapper.class)
                .mapperResponse(clubeServiceResponse);
    }

    ClubeControllerResponse mapperResponse(ClubeServiceResponse clubeServiceResponse);

}
