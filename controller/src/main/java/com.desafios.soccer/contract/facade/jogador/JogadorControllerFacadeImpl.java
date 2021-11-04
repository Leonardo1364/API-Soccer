package com.desafios.soccer.contract.facade.jogador;

import com.desafios.soccer.mapper.jogador.JogadorControllerMapper;
import com.desafios.soccer.model.jogador.JogadorControllerRequest;
import com.desafios.soccer.model.jogador.JogadorControllerResponse;
import com.desafios.soccer.service.jogador.JogadorServiceFacade;
import com.desafios.soccer.service.model.jogador.JogadorServiceRequest;
import com.desafios.soccer.service.model.jogador.JogadorServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class JogadorControllerFacadeImpl implements JogadorControllerFacade {

    private final JogadorServiceFacade facade;

    public JogadorControllerResponse saveJogador(JogadorControllerRequest jogador) {
        JogadorServiceRequest jogadorServiceRequest = JogadorControllerMapper.INSTANCE.toServiceRequest(jogador);
        JogadorServiceResponse jogadorServiceResponse = facade.saveJogador(jogadorServiceRequest);
        return JogadorControllerMapper.INSTANCE.toServiceResponse(jogadorServiceResponse);
    }

}

