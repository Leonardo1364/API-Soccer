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

    public PlayerServiceResponse save(PlayerServiceRequest player) {
        return playerService.save(player);
    }

    public PlayerServiceResponse updateById(PlayerServiceRequest player) {
        return playerService.update(player);
    }

    public void delete(String id) {
        playerService.findById(id);
        playerService.deletePlayerById(id);
    }

    public PlayerServiceResponse findById(String id) {
        playerService.findById(id);
        return playerService.findById(id);
    }

    public List<PlayerServiceResponse> findAll() {
        return playerService.findAll();
    }

}
