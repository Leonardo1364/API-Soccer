package com.desafios.soccer.service.v1.playerService;

import com.desafios.soccer.service.model.request.PlayerServiceRequest;
import com.desafios.soccer.service.model.response.PlayerServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PlayerFacade {

    private PlayerService playerService;

    public PlayerServiceResponse savePlayer(PlayerServiceRequest player) {
        return playerService.savePlayer(player);
    }

    public PlayerServiceResponse updatePlayerById(PlayerServiceRequest player, String id) {
        PlayerServiceResponse playerById = playerService.findPlayerById(id);
        return playerService.updatePlayerById(player, playerById.getId());
    }

    public void deletePlayerById(String id) {
        playerService.findPlayerById(id);
        playerService.deletePlayerById(id);
    }

    public PlayerServiceResponse findPlayerById(String id) {
        playerService.findPlayerById(id);
        return playerService.findPlayerById(id);
    }

    public List<PlayerServiceResponse> findAllPlayers() {
        return playerService.findAllPlayers();
    }

}
