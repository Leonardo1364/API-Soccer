package com.desafios.soccer.service.mapper.request;

import com.desafios.soccer.model.entity.Jogador;
import com.desafios.soccer.service.model.request.JogadorServiceRequest;

//@Mapper
public interface JogadorServiceRequestMapper {

    static Jogador toJogadorEntity(JogadorServiceRequest jogadorRequest) {
        return Jogador.builder()
                .id(jogadorRequest.getId())
                .nome(jogadorRequest.getNome())
                .idade(jogadorRequest.getIdade())
                .clubeAtual(jogadorRequest.getClubeAtual())
                .reputacaoHistorica(jogadorRequest.getReputacaoHistorica())
                .apetiteFinanceiro(jogadorRequest.getApetiteFinanceiro())
                .preco(jogadorRequest.getPreco())
                .build();
    }

    /*static Jogador toJogadorEntity(JogadorServiceRequest jogador) {
      return Mappers.getMapper(JogadorServiceRequestMapper.class)
              .mapper(jogador);
    }

    Jogador mapper(JogadorServiceRequest jogador);*/

}
