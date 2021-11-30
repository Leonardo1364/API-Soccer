package com.desafios.soccer.service.jogadorService;

import com.desafios.soccer.service.model.request.JogadorServiceRequest;
import com.desafios.soccer.service.model.response.JogadorServiceResponse;

import java.util.List;

public interface JogadorServiceFacade {

    JogadorServiceResponse saveJogador(JogadorServiceRequest jogador);

    JogadorServiceResponse updateJogadorById(JogadorServiceRequest jogador, Long id);

    void deleteById(Long id);

    JogadorServiceResponse findJogadorById(Long id);

    List<JogadorServiceResponse> findAllJogadores();

}
