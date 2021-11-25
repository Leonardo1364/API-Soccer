package com.desafios.soccer.mapper.response;

import com.desafios.soccer.model.response.JogadorControllerResponse;
import com.desafios.soccer.service.model.response.JogadorServiceResponse;

//@Mapper()
public interface JogadorControllerResponseMapper {

    static JogadorControllerResponse toJogadorResponseController(JogadorServiceResponse jogadorResponse) {
        if (jogadorResponse == null) {
            return null;
        }

        return JogadorControllerResponse.builder()
                .id(jogadorResponse.getId())
                .nome(jogadorResponse.getNome())
                .idade(jogadorResponse.getIdade())
                .clubeAtual(jogadorResponse.getClubeAtual())
                .reputacaoHistorica(jogadorResponse.getReputacaoHistorica())
                .apetiteFinanceiro(jogadorResponse.getApetiteFinanceiro())
                .preco(jogadorResponse.getPreco())
                .build();
    }

    /*static JogadorControllerResponse toJogadorResponseController(JogadorServiceResponse jogador) {
        return Mappers.getMapper(JogadorControllerResponseMapper.class)
                .mapper(jogador);
    }

    JogadorControllerResponse mapper(JogadorServiceResponse jogador);*/
}
