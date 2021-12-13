package com.desafios.soccer.contract.facade.player;

import com.desafios.soccer.contract.mapper.response.PlayerControllerResponseMapper;
import com.desafios.soccer.contract.model.request.PlayerControllerRequest;
import com.desafios.soccer.contract.model.response.PlayerControllerResponse;
import com.desafios.soccer.service.model.request.PlayerServiceRequest;
import com.desafios.soccer.service.model.response.PlayerServiceResponse;
import com.desafios.soccer.service.v1.playerService.PlayerFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.desafios.soccer.contract.mapper.request.PlayerControllerRequestMapper.toPlayerService;
import static com.desafios.soccer.contract.mapper.response.PlayerControllerResponseMapper.toPlayerResponseController;

@AllArgsConstructor
@Component
public class PlayerControllerFacadeImpl implements PlayerControllerFacade {

    private final PlayerFacade facade;

    public PlayerControllerResponse savePlayer(PlayerControllerRequest player) {
        PlayerServiceRequest playerSave = toPlayerService(player);
        PlayerServiceResponse playerResponse = facade.savePlayer(playerSave);
        return toPlayerResponseController(playerResponse);
    }

    public PlayerControllerResponse updatePlayerById(PlayerControllerRequest player, String id) {
        PlayerServiceRequest playerSave = toPlayerService(player);
        PlayerServiceResponse playerResponse = facade.updatePlayerById(playerSave, id);
        return toPlayerResponseController(playerResponse);
    }

    public void deletePlayerById(String id) {
        facade.deletePlayerById(id);
    }

    public PlayerControllerResponse findPlayerById(String id) {
        PlayerServiceResponse playerController = facade.findPlayerById(id);
        return toPlayerResponseController(playerController);
    }

    public List<PlayerControllerResponse> findAllPlayer() {
        return facade.findAllPlayers().stream()
                .map(PlayerControllerResponseMapper::toPlayerResponseController)
                .toList();
    }

}

