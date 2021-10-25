package com.desafios.soccer.service.jogador;

import com.desafios.soccer.repository.repository.JogadorRepository;
import com.desafios.soccer.repository.model.entity.Jogador;
import com.desafios.soccer.service.mapper.jogador.JogadorServiceMapper;
import com.desafios.soccer.service.model.jogador.JogadorServiceRequest;
import com.desafios.soccer.service.model.jogador.JogadorServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class JogadorServiceFacadeImpl implements JogadorServiceFacade {

    private final JogadorRepository repository;

    public JogadorServiceResponse saveJogador(JogadorServiceRequest jogador) {
        Jogador jogadorEntity = JogadorServiceMapper.INSTANCE.toJogadorEntity(jogador);
        Jogador jogadorSave = repository.save(jogadorEntity);
        return JogadorServiceMapper.INSTANCE.toResponseService(jogadorSave);
    }

}

