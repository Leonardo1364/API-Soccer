package com.desafios.soccer.contract.facade.jogador;

import com.desafios.soccer.model.request.JogadorControllerRequest;
import com.desafios.soccer.model.response.JogadorControllerResponse;

import java.util.List;

public interface JogadorControllerFacade {

    JogadorControllerResponse saveJogador(JogadorControllerRequest jogador);

    JogadorControllerResponse updateJogador(JogadorControllerRequest jogador, Long id);

    void deleteJogadorById(Long id);

    JogadorControllerResponse findJogadorById(Long id);

    List<JogadorControllerResponse> findAllJogadores();

}
