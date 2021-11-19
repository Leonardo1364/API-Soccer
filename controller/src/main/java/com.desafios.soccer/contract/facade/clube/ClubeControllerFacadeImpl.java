package com.desafios.soccer.contract.facade.clube;

import com.desafios.soccer.mapper.clube.ClubeControllerResponseMapper;
import com.desafios.soccer.model.clube.ClubeControllerRequest;
import com.desafios.soccer.model.clube.ClubeControllerResponse;
import com.desafios.soccer.service.clube.ClubeServiceFacade;
import com.desafios.soccer.service.model.clube.ClubeServiceRequest;
import com.desafios.soccer.service.model.clube.ClubeServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import static com.desafios.soccer.mapper.clube.ClubeControllerRequestMapper.toClubeService;
import static com.desafios.soccer.mapper.clube.ClubeControllerResponseMapper.toClubeResponseController;

@AllArgsConstructor
@Component
public class ClubeControllerFacadeImpl implements ClubeControllerFacade {

    private final ClubeServiceFacade facade;

    public ClubeControllerResponse saveClube(ClubeControllerRequest clube) {
        ClubeServiceRequest clubeSave = toClubeService(clube);
        ClubeServiceResponse clubeResponse = facade.saveClube(clubeSave);
        return toClubeResponseController(clubeResponse);
    }

    public ClubeControllerResponse updateClubeById(ClubeControllerRequest clube, Long id) {
        ClubeServiceRequest clubeSave = toClubeService(clube);
        ClubeServiceResponse clubeResponse = facade.updateClubeById(clubeSave, id);
        return toClubeResponseController(clubeResponse);
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
                .collect(Collectors.toList());
    }
}
