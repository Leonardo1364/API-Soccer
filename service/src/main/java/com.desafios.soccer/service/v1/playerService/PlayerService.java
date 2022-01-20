package com.desafios.soccer.service.v1.playerService;

import com.desafios.soccer.exceptions.notfound.NotFoundException;
import com.desafios.soccer.model.entity.Player;
import com.desafios.soccer.repository.PlayerRepository;
import com.desafios.soccer.service.mapper.response.PlayerServiceResponseMapper;
import com.desafios.soccer.service.model.request.PlayerServiceRequest;
import com.desafios.soccer.service.model.response.PlayerServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.desafios.soccer.service.mapper.request.PlayerServiceRequestMapper.toEntity;
import static com.desafios.soccer.service.mapper.response.PlayerServiceResponseMapper.toResponse;

@AllArgsConstructor
@Service
public record PlayerService(PlayerRepository playerRepository) {

    public PlayerServiceResponse save(PlayerServiceRequest player) {
        Player playerResponse = playerRepository.save(toEntity(player));
        return toResponse(playerResponse);
    }

    public PlayerServiceResponse update(PlayerServiceRequest player) {
        Player playerSave = playerRepository.save(toEntity(player));
        return toResponse(playerSave);
    }

    public void deletePlayerById(String id) {
        playerRepository.deleteById(id);
    }

    public PlayerServiceResponse findById(String id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toResponse(player);
    }

    public List<PlayerServiceResponse> findAll() {
        return playerRepository.findAll().stream()
                .map(PlayerServiceResponseMapper::toResponse)
                .toList();
    }
}

