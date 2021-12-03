package com.desafios.soccer.service.v1.playerService;

import com.desafios.soccer.service.model.request.PlayerServiceRequest;
import com.desafios.soccer.service.model.response.PlayerServiceResponse;

import java.util.List;

public interface PlayerServiceFacade {

    PlayerServiceResponse savePlayer(PlayerServiceRequest player);

    PlayerServiceResponse updatePlayerById(PlayerServiceRequest player, String id);

    void deletePlayerById(String id);

    PlayerServiceResponse findPlayerById(String id);

    List<PlayerServiceResponse> findAllPlayers();

}
