package com.desafios.soccer.service.v1.playerService;

import com.desafios.soccer.exceptions.notfound.NotFoundException;
import com.desafios.soccer.model.entity.Player;
import com.desafios.soccer.repository.PlayerRepository;
import com.desafios.soccer.service.mapper.response.PlayerServiceResponseMapper;
import com.desafios.soccer.service.model.request.PlayerServiceRequest;
import com.desafios.soccer.service.model.response.PlayerServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.desafios.soccer.service.mapper.request.PlayerServiceRequestMapper.toPlayerEntity;
import static com.desafios.soccer.service.mapper.response.PlayerServiceResponseMapper.toPlayerResponse;

@AllArgsConstructor
@Component
public class PlayerServiceFacadeImpl implements PlayerServiceFacade {

    private final PlayerRepository playerRepository;

    public PlayerServiceResponse savePlayer(PlayerServiceRequest player) {
        Player playerSave = toPlayerEntity(player);
        Player playerResponse = playerRepository.save(playerSave);
        return toPlayerResponse(playerResponse);
    }

    public PlayerServiceResponse updatePlayerById(PlayerServiceRequest player, String id) {
        Player playerName = playerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        player.setId(playerName.getId());
        Player playerEntity = toPlayerEntity(player);
        Player playerSave = playerRepository.save(playerEntity);
        return toPlayerResponse(playerSave);
    }

    public void deletePlayerById(String id) {
        playerRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("ID not found"));
        playerRepository.deleteById(id);
    }

    public PlayerServiceResponse findPlayerById(String id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toPlayerResponse(player);
    }

    public List<PlayerServiceResponse> findAllPlayers() {
        return playerRepository.findAll().stream()
                .map(PlayerServiceResponseMapper::toPlayerResponse)
                .collect(Collectors.toList());
    }
}

