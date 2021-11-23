package com.desafios.soccer.mapper.response;

import com.desafios.soccer.model.response.JogadorControllerResponse;
import com.desafios.soccer.service.model.response.JogadorServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface JogadorControllerResponseMapper {

    static JogadorControllerResponse toJogadorResponseController(JogadorServiceResponse jogador) {
        return Mappers.getMapper(JogadorControllerResponseMapper.class)
                .mapper(jogador);
    }

    JogadorControllerResponse mapper(JogadorServiceResponse jogador);
}
