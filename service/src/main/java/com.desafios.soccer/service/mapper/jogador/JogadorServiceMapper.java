package com.desafios.soccer.service.mapper.jogador;

import com.desafios.soccer.model.entity.Jogador;
import com.desafios.soccer.service.model.jogador.JogadorServiceRequest;
import com.desafios.soccer.service.model.jogador.JogadorServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JogadorServiceMapper {

    JogadorServiceMapper INSTANCE = Mappers.getMapper(JogadorServiceMapper.class);

    Jogador toJogadorEntity(JogadorServiceRequest jogador);

    JogadorServiceResponse toResponseService(Jogador jogador);

}
