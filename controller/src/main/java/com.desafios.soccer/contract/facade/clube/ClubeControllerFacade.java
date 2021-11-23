package com.desafios.soccer.contract.facade.clube;

import com.desafios.soccer.model.request.ClubeControllerRequest;
import com.desafios.soccer.model.response.ClubeControllerResponse;

import java.util.List;

public interface ClubeControllerFacade {

    ClubeControllerResponse saveClube(ClubeControllerRequest clube);

    ClubeControllerResponse updateClubeById(ClubeControllerRequest clube, Long id);

    void deleteClubeById(Long id);

    ClubeControllerResponse findClubeById(Long id);

    List<ClubeControllerResponse> findAllClubes();
}
