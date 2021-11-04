package com.desafios.soccer.service.clube;

import com.desafios.soccer.service.model.clube.ClubeServiceRequest;
import com.desafios.soccer.service.model.clube.ClubeServiceResponse;
import java.util.List;

public interface ClubeServiceFacade {

    ClubeServiceResponse saveClube(ClubeServiceRequest clube);

    ClubeServiceResponse updateClubeById(ClubeServiceRequest clube, Long id);

    void deleteClubeById(Long id);

    ClubeServiceResponse findClubeById(Long id);

    List<ClubeServiceResponse> findAllClubes();

}
