package com.desafios.soccer.mapper.clube;

import com.desafios.soccer.model.clube.ClubeControllerRequest;
import com.desafios.soccer.service.model.clube.ClubeServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface ClubeControllerRequestMapper {

    static ClubeServiceRequest toClubeService(ClubeControllerRequest clubeRequest) {
        return Mappers.getMapper(ClubeControllerRequestMapper.class)
                .mapperRequest(clubeRequest);
    }

    ClubeServiceRequest mapperRequest(ClubeControllerRequest clubeRequest);

}
