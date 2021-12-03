package com.desafios.soccer.contract.facade.jogador;

import com.desafios.soccer.model.request.PlayerControllerRequest;
import com.desafios.soccer.model.response.PlayerControllerResponse;

import java.util.List;

public interface PlayerControllerFacade {

    PlayerControllerResponse savePlayer(PlayerControllerRequest player);

    PlayerControllerResponse updatePlayerById(PlayerControllerRequest player, String id);

    void deletePlayerById(String id);

    PlayerControllerResponse findPlayerById(String id);

    List<PlayerControllerResponse> findAllPlayer();

}
