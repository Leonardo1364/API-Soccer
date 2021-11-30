package com.desafios.soccer.service.v1.jogadorService;

import com.desafios.soccer.exceptions.notfound.NotFoundException;
import com.desafios.soccer.model.entity.Jogador;
import com.desafios.soccer.repository.JogadorRepository;
import com.desafios.soccer.service.mapper.response.JogadorServiceResponseMapper;
import com.desafios.soccer.service.model.request.JogadorServiceRequest;
import com.desafios.soccer.service.model.response.JogadorServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.desafios.soccer.service.mapper.request.JogadorServiceRequestMapper.toJogadorEntity;
import static com.desafios.soccer.service.mapper.response.JogadorServiceResponseMapper.toJogadorResponse;

@AllArgsConstructor
@Component
public class JogadorServiceFacadeImpl implements JogadorServiceFacade {

    private final JogadorRepository jogadorRepository;

    public JogadorServiceResponse saveJogador(JogadorServiceRequest jogador) {
        Jogador jogadorSave = toJogadorEntity(jogador);
        Jogador jogadorResponse = jogadorRepository.save(jogadorSave);
        return toJogadorResponse(jogadorResponse);
    }

    public JogadorServiceResponse updateJogadorById(JogadorServiceRequest jogador, Long id) {
        Jogador jogadorNome = jogadorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        jogador.setId(jogadorNome.getId());
        Jogador jogadorEntity = toJogadorEntity(jogador);
        Jogador jogadorSave = jogadorRepository.save(jogadorEntity);
        return toJogadorResponse(jogadorSave);
    }

    public void deleteById(Long id) {
        jogadorRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("ID not found"));
        jogadorRepository.deleteById(id);
    }

    public JogadorServiceResponse findJogadorById(Long id) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toJogadorResponse(jogador);
    }

    public List<JogadorServiceResponse> findAllJogadores() {
        return jogadorRepository.findAll().stream()
                .map(JogadorServiceResponseMapper::toJogadorResponse)
                .collect(Collectors.toList());
    }
}

