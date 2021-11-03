package com.desafios.soccer.service.clube;

import com.desafios.soccer.service.model.clube.ClubeServiceRequest;
import com.desafios.soccer.service.model.clube.ClubeServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ClubeServiceFacadeImpl implements ClubeServiceFacade {

    private final ClubeService service;

    public ClubeServiceResponse saveClube(ClubeServiceRequest clube) {
        return service.saveClube(clube);
    }

    public ClubeServiceResponse updateClubeById(ClubeServiceRequest clube, Long id) {
        return service.updateClubeById(clube, id);
    }

    public void deleteClubeById(Long id) {
        service.deleteClubeById(id);
    }

    public ClubeServiceResponse findClubeById(Long id) {
        return service.findClubeById(id);
    }

    public List<ClubeServiceResponse> findAllClubes() {
        return service.findAllClubes();
    }

}
