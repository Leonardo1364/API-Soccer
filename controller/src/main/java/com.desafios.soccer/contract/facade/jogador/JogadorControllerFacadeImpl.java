package com.desafios.soccer.contract.facade.jogador;

import com.desafios.soccer.mapper.jogador.JogadorControllerResponseMapper;
import com.desafios.soccer.model.jogador.JogadorControllerRequest;
import com.desafios.soccer.model.jogador.JogadorControllerResponse;
import com.desafios.soccer.service.jogador.JogadorServiceFacade;
import com.desafios.soccer.service.model.jogador.JogadorServiceRequest;
import com.desafios.soccer.service.model.jogador.JogadorServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.desafios.soccer.mapper.jogador.JogadorControllerRequestMapper.toJogadorService;
import static com.desafios.soccer.mapper.jogador.JogadorControllerResponseMapper.toJogadorResponseController;

@AllArgsConstructor
@Component
public class JogadorControllerFacadeImpl implements JogadorControllerFacade {

    private final JogadorServiceFacade facade;

    public JogadorControllerResponse saveJogador(JogadorControllerRequest jogador) {
        JogadorServiceRequest jogadorSave = toJogadorService(jogador);
        JogadorServiceResponse jogadorResponse = facade.saveJogador(jogadorSave);
        return toJogadorResponseController(jogadorResponse);
    }

    public JogadorControllerResponse updateJogador(JogadorControllerRequest jogador, Long id) {
        JogadorServiceRequest jogadorSave = toJogadorService(jogador);
        JogadorServiceResponse jogadorResponse = facade.updateJogadorById(jogadorSave, id);
        return toJogadorResponseController(jogadorResponse);
    }

    public void deleteJogadorById(Long id) {
        facade.deleteById(id);
    }

    public JogadorControllerResponse findJogadorById(Long id) {
        JogadorServiceResponse jogadorController = facade.findJogadorById(id);
        return toJogadorResponseController(jogadorController);
    }

    public List<JogadorControllerResponse> findAllJogadores() {
        return facade.findAllJogadores().stream()
                .map(JogadorControllerResponseMapper::toJogadorResponseController)
                .collect(Collectors.toList());
    }

}

