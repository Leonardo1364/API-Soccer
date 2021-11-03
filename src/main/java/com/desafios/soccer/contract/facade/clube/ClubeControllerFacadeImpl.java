package com.desafios.soccer.contract.facade.clube;

import com.desafios.soccer.contract.mapper.clube.ClubeControllerResponseMapper;
import com.desafios.soccer.contract.model.clube.ClubeControllerRequest;
import com.desafios.soccer.contract.model.clube.ClubeControllerResponse;
import com.desafios.soccer.service.clube.ClubeServiceFacade;
import com.desafios.soccer.service.model.clube.ClubeServiceRequest;
import com.desafios.soccer.service.model.clube.ClubeServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.desafios.soccer.contract.mapper.clube.ClubeControllerRequestMapper.toClubeService;
import static com.desafios.soccer.contract.mapper.clube.ClubeControllerResponseMapper.toClubeResponseController;

@AllArgsConstructor
@Component
public class ClubeControllerFacadeImpl implements ClubeControllerFacade {

    private final ClubeServiceFacade facade;

    public ClubeControllerResponse saveClube(ClubeControllerRequest clube) {
        ClubeServiceRequest clubeSave = toClubeService(clube);
        ClubeServiceResponse clubeController = facade.saveClube(clubeSave);
        return toClubeResponseController(clubeController);
    }

    public ClubeControllerResponse updateClubeById(ClubeControllerRequest clube, Long id) {
        ClubeServiceRequest clubeSave = toClubeService(clube);
        ClubeServiceResponse clubeController = facade.updateClubeById(clubeSave, id);
        return toClubeResponseController(clubeController);
    }

    public void deleteClubeById(Long id) {
        facade.deleteClubeById(id);
    }

    public ClubeControllerResponse findClubeById(Long id) {
        ClubeServiceResponse clubeController = facade.findClubeById(id);
        return toClubeResponseController(clubeController);
    }

    public List<ClubeControllerResponse> findAllClubes() {
        return facade.findAllClubes().stream()
                .map(ClubeControllerResponseMapper::toClubeResponseController)
                .toList();
    }
}
