package com.desafios.soccer.service.mapper.request;

import com.desafios.soccer.model.entity.Clube;
import com.desafios.soccer.service.model.request.ClubeServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClubeServiceRequestMapper {

    static Clube toClubeEntity(ClubeServiceRequest clubeRequest) {
        return Mappers.getMapper(ClubeServiceRequestMapper.class)
                .mapper(clubeRequest);
    }

    Clube mapper(ClubeServiceRequest clubeRequest);

}
