package com.desafios.soccer.contract.facade.jogador;

import com.desafios.soccer.contract.model.jogador.JogadorControllerRequest;
import com.desafios.soccer.contract.model.jogador.JogadorControllerResponse;

public interface JogadorControllerFacade {

    JogadorControllerResponse saveJogador(JogadorControllerRequest jogador);

}
