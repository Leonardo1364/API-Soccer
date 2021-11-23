package com.desafios.soccer.mapper.request;

import com.desafios.soccer.model.request.ClubeControllerRequest;
import com.desafios.soccer.service.model.request.ClubeServiceRequest;
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
