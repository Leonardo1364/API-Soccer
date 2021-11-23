package com.desafios.soccer.service.jogador;

import com.desafios.soccer.service.model.jogador.JogadorServiceRequest;
import com.desafios.soccer.service.model.jogador.JogadorServiceResponse;

import java.util.List;

public interface JogadorServiceFacade {

    JogadorServiceResponse saveJogador(JogadorServiceRequest jogador);

    JogadorServiceResponse updateJogadorById(JogadorServiceRequest jogador, Long id);

    void deleteById(Long id);

    JogadorServiceResponse findJogadorById(Long id);

    List<JogadorServiceResponse> findAllJogadores();

}
