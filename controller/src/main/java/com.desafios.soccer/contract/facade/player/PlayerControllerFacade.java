package com.desafios.soccer.contract.facade.player;

import com.desafios.soccer.contract.model.request.PlayerControllerRequest;
import com.desafios.soccer.contract.model.response.PlayerControllerResponse;

import java.util.List;

public interface PlayerControllerFacade {

    PlayerControllerResponse savePlayer(PlayerControllerRequest player);

    PlayerControllerResponse updatePlayerById(PlayerControllerRequest player, String id);

    void deletePlayerById(String id);

    PlayerControllerResponse findPlayerById(String id);

    List<PlayerControllerResponse> findAllPlayer();

}