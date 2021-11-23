package com.desafios.soccer.service.mapper.jogador;

import com.desafios.soccer.model.entity.Jogador;
import com.desafios.soccer.service.model.jogador.JogadorServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JogadorServiceRequestMapper {

    static Jogador toJogadorEntity(JogadorServiceRequest jogador) {
      return Mappers.getMapper(JogadorServiceRequestMapper.class)
              .mapper(jogador);
    }

    Jogador mapper(JogadorServiceRequest jogador);

}
