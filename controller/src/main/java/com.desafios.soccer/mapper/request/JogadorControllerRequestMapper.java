package com.desafios.soccer.mapper.request;

import com.desafios.soccer.model.request.JogadorControllerRequest;
import com.desafios.soccer.service.model.request.JogadorServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface JogadorControllerRequestMapper {

    static JogadorServiceRequest toJogadorService(JogadorControllerRequest jogador) {
       return Mappers.getMapper(JogadorControllerRequestMapper.class)
                .mapper(jogador);
    }

    JogadorServiceRequest mapper(JogadorControllerRequest jogador);

}
