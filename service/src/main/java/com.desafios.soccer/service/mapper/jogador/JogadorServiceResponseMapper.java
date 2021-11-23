package com.desafios.soccer.service.mapper.jogador;

import com.desafios.soccer.model.entity.Jogador;
import com.desafios.soccer.service.model.jogador.JogadorServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JogadorServiceResponseMapper {

    static JogadorServiceResponse toJogadorResponse(Jogador jogador) {
        return Mappers.getMapper(JogadorServiceResponseMapper.class)
                .mapper(jogador);
    }

    JogadorServiceResponse mapper(Jogador jogador);
}
