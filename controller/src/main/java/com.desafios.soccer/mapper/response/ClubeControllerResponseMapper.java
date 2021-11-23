package com.desafios.soccer.mapper.response;

import com.desafios.soccer.model.response.ClubeControllerResponse;
import com.desafios.soccer.service.model.response.ClubeServiceResponse;
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
