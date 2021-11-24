package com.desafios.soccer.mapper.request;

import com.desafios.soccer.model.request.JogadorControllerRequest;
import com.desafios.soccer.service.model.request.JogadorServiceRequest;

//@Mapper()
public interface JogadorControllerRequestMapper {

    static JogadorServiceRequest toJogadorService(JogadorControllerRequest jogadorRequest) {
        return JogadorServiceRequest.builder()
                .id(jogadorRequest.getId())
                .nome(jogadorRequest.getNome())
                .idade(jogadorRequest.getIdade())
                .clubeAtual(jogadorRequest.getClubeAtual())
                .reputacaoHistorica(jogadorRequest.getReputacaoHistorica())
                .apetiteFinanceiro(jogadorRequest.getApetiteFinanceiro())
                .preco(jogadorRequest.getPreco())
                .build();
    }

    /*static JogadorServiceRequest toJogadorService(JogadorControllerRequest jogador) {
       return Mappers.getMapper(JogadorControllerRequestMapper.class)
                .mapper(jogador);
    }

    JogadorServiceRequest mapper(JogadorControllerRequest jogador);*/

}
