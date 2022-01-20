package com.desafios.soccer.contract.facade.player;

import com.desafios.soccer.contract.model.request.PlayerControllerRequest;
import com.desafios.soccer.contract.model.response.PlayerControllerResponse;

import java.util.List;

public interface PlayerControllerFacade {

    PlayerControllerResponse save(PlayerControllerRequest player);

    PlayerControllerResponse update(PlayerControllerRequest player, String id);

    void delete(String id);

    PlayerControllerResponse findById(String id);

    List<PlayerControllerResponse> findAll();

}
