package com.desafios.soccer.mappers;

import com.desafios.soccer.model.Clube;
import com.desafios.soccer.model.dto.clube.ClubeRequestDto;
import com.desafios.soccer.model.dto.clube.ClubeResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClubeMapper {
    ClubeMapper INSTANCE = Mappers.getMapper(ClubeMapper.class);

    ClubeResponseDto toClubeDto(Clube clube);

    Clube toClubeEntity(ClubeRequestDto clubeRequest);

}
