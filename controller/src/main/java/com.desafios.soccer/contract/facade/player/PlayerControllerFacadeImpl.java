package com.desafios.soccer.contract.facade.player;

import com.desafios.soccer.contract.mapper.response.PlayerControllerResponseMapper;
import com.desafios.soccer.contract.model.request.PlayerControllerRequest;
import com.desafios.soccer.contract.model.response.PlayerControllerResponse;
import com.desafios.soccer.service.model.response.PlayerServiceResponse;
import com.desafios.soccer.service.v1.playerService.PlayerFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.desafios.soccer.contract.mapper.request.PlayerControllerRequestMapper.toServiceWithId;
import static com.desafios.soccer.contract.mapper.request.PlayerControllerRequestMapper.toServiceWithoutId;
import static com.desafios.soccer.contract.mapper.response.PlayerControllerResponseMapper.toResponseController;

@AllArgsConstructor
@Component
public class PlayerControllerFacadeImpl implements PlayerControllerFacade {

    private final PlayerFacade facade;

    public PlayerControllerResponse save(PlayerControllerRequest player) {
        PlayerServiceResponse playerResponse = facade.save(toServiceWithoutId(player));
        return toResponseController(playerResponse);
    }

    public PlayerControllerResponse update(PlayerControllerRequest player, String id) {
        PlayerServiceResponse playerResponse = facade.updateById(toServiceWithId(player, id));
        return toResponseController(playerResponse);
    }

    public void delete(String id) {
        facade.delete(id);
    }

    public PlayerControllerResponse findById(String id) {
        PlayerServiceResponse playerController = facade.findById(id);
        return toResponseController(playerController);
    }

    public List<PlayerControllerResponse> findAll() {
        return facade.findAll().stream()
                .map(PlayerControllerResponseMapper::toResponseController)
                .toList();
    }

}

