package com.desafios.soccer.mapper.jogador;

import com.desafios.soccer.model.jogador.JogadorControllerResponse;
import com.desafios.soccer.service.model.jogador.JogadorServiceResponse;
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
