package com.desafios.soccer.contract.facade.jogador;

import com.desafios.soccer.mapper.response.PlayerControllerResponseMapper;
import com.desafios.soccer.model.request.PlayerControllerRequest;
import com.desafios.soccer.model.response.PlayerControllerResponse;
import com.desafios.soccer.service.v1.playerService.PlayerServiceFacade;
import com.desafios.soccer.service.model.request.PlayerServiceRequest;
import com.desafios.soccer.service.model.response.PlayerServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.desafios.soccer.mapper.request.PlayerControllerRequestMapper.toPlayerService;
import static com.desafios.soccer.mapper.response.PlayerControllerResponseMapper.toPlayerResponseController;

@AllArgsConstructor
@Component
public class PlayerControllerFacadeImpl implements PlayerControllerFacade {

    private final PlayerServiceFacade facade;

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
                .collect(Collectors.toList());
    }

}

