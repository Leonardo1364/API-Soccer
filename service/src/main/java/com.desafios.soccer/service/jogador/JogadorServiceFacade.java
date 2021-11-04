package com.desafios.soccer.service.jogador;

import com.desafios.soccer.service.model.jogador.JogadorServiceRequest;
import com.desafios.soccer.service.model.jogador.JogadorServiceResponse;

public interface JogadorServiceFacade {

    JogadorServiceResponse saveJogador(JogadorServiceRequest jogador);

}
