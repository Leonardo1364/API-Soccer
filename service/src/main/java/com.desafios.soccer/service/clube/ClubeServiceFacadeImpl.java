package com.desafios.soccer.service.clube;

import com.desafios.soccer.exceptions.notfound.NotFoundException;
import com.desafios.soccer.model.entity.Clube;
import com.desafios.soccer.repository.ClubeRepository;
import com.desafios.soccer.service.mapper.clube.ClubeServiceResponseMapper;
import com.desafios.soccer.service.model.clube.ClubeServiceRequest;
import com.desafios.soccer.service.model.clube.ClubeServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.desafios.soccer.service.mapper.clube.ClubeServiceRequestMapper.toClubeEntity;
import static com.desafios.soccer.service.mapper.clube.ClubeServiceResponseMapper.toClubeResponse;

@AllArgsConstructor
@Component
public class ClubeServiceFacadeImpl implements ClubeServiceFacade {

    private final ClubeRepository repository;

    public ClubeServiceResponse saveClube(ClubeServiceRequest clube) {
        Clube clubeSave = toClubeEntity(clube);
        Clube clubeResponse = repository.save(clubeSave);
        return toClubeResponse(clubeResponse);
    }

    public ClubeServiceResponse updateClubeById(ClubeServiceRequest clube, Long id) {
        Clube clubeNome = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        clube.setId(clubeNome.getId());
        Clube clubeEntity = toClubeEntity(clube);
        Clube clubeSave = repository.save(clubeEntity);
        return toClubeResponse(clubeSave);
    }

    public void deleteClubeById(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        repository.deleteById(id);
    }

    public List<ClubeServiceResponse> findAllClubes() {
        return repository.findAll().stream()
                .map(ClubeServiceResponseMapper::toClubeResponse)
                .toList();
    }

    public ClubeServiceResponse findClubeById(Long id) {
        Clube clube = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toClubeResponse(clube);
    }

}