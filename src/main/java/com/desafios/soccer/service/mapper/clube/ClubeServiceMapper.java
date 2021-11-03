package com.desafios.soccer.service.mapper.clube;

import com.desafios.soccer.repository.model.entity.Clube;
import com.desafios.soccer.service.model.clube.ClubeServiceRequest;
import com.desafios.soccer.service.model.clube.ClubeServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClubeServiceMapper {

    ClubeServiceMapper INSTANCE = Mappers.getMapper(ClubeServiceMapper.class);

    Clube toClubeEntity(ClubeServiceRequest clube);

    ClubeServiceResponse toResponseService(Clube clube);
}
