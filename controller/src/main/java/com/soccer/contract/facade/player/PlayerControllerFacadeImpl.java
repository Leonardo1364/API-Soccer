package com.soccer.contract.facade.player;

import com.soccer.contract.mapper.response.PlayerControllerResponseMapper;
import com.soccer.contract.model.request.PlayerControllerRequest;
import com.soccer.contract.model.response.PlayerControllerResponse;
import com.soccer.service.model.response.PlayerServiceResponse;
import com.soccer.service.v1.playerservice.PlayerFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.soccer.contract.mapper.request.PlayerControllerRequestMapper.toServiceWithId;
import static com.soccer.contract.mapper.request.PlayerControllerRequestMapper.toServiceWithoutId;

@AllArgsConstructor
@Component
public class PlayerControllerFacadeImpl implements PlayerControllerFacade {

    private final PlayerFacade facade;

    public PlayerControllerResponse save(PlayerControllerRequest player) {
        PlayerServiceResponse playerResponse = facade.save(toServiceWithoutId(player));
        return PlayerControllerResponseMapper.toResponseController(playerResponse);
    }

    public PlayerControllerResponse update(PlayerControllerRequest player, String id) {
        PlayerServiceResponse playerResponse = facade.updateById(toServiceWithId(player, id));
        return PlayerControllerResponseMapper.toResponseController(playerResponse);
    }

    public void delete(String id) {
        facade.delete(id);
    }

    public PlayerControllerResponse findById(String id) {
        PlayerServiceResponse playerController = facade.findById(id);
        return PlayerControllerResponseMapper.toResponseController(playerController);
    }

    public List<PlayerControllerResponse> findAll() {
        return facade.findAll().stream()
                .map(PlayerControllerResponseMapper::toResponseController)
                .toList();
    }

}

