package com.desafios.soccer.service.mapper.response;

import com.desafios.soccer.model.entity.Jogador;
import com.desafios.soccer.service.model.response.JogadorServiceResponse;

//@Mapper
public interface JogadorServiceResponseMapper {

    static JogadorServiceResponse toJogadorResponse(Jogador jogadorResponse) {
        if (jogadorResponse == null) {
            return null;
        }

        return JogadorServiceResponse.builder()
                .id(jogadorResponse.getId())
                .nome(jogadorResponse.getNome())
                .idade(jogadorResponse.getIdade())
                .clubeAtual(jogadorResponse.getClubeAtual())
                .reputacaoHistorica(jogadorResponse.getReputacaoHistorica())
                .apetiteFinanceiro(jogadorResponse.getApetiteFinanceiro())
                .preco(jogadorResponse.getPreco())
                .build();
    }

    /*static JogadorServiceResponse toJogadorResponse(Jogador jogador) {
        return Mappers.getMapper(JogadorServiceResponseMapper.class)
                .mapper(jogador);
    }

    JogadorServiceResponse mapper(Jogador jogador);*/
}
