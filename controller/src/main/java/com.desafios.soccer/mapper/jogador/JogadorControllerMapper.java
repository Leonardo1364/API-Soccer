package com.desafios.soccer.mapper.jogador;

import com.desafios.soccer.model.jogador.JogadorControllerRequest;
import com.desafios.soccer.model.jogador.JogadorControllerResponse;
import com.desafios.soccer.service.model.jogador.JogadorServiceRequest;
import com.desafios.soccer.service.model.jogador.JogadorServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JogadorControllerMapper {

    JogadorControllerMapper INSTANCE = Mappers.getMapper(JogadorControllerMapper.class);

    JogadorControllerResponse toServiceResponse(JogadorServiceResponse jogador);

    JogadorServiceRequest toServiceRequest(JogadorControllerRequest jogador);

}
