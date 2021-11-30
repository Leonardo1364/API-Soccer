package com.desafios.soccer.service.v1.clubeService;

import com.desafios.soccer.service.model.request.ClubeServiceRequest;
import com.desafios.soccer.service.model.response.ClubeServiceResponse;
import java.util.List;

public interface ClubeServiceFacade {

    ClubeServiceResponse saveClube(ClubeServiceRequest clube);

    ClubeServiceResponse updateClubeById(ClubeServiceRequest clube, Long id);

    void deleteClubeById(Long id);

    ClubeServiceResponse findClubeById(Long id);

    List<ClubeServiceResponse> findAllClubes();

}
