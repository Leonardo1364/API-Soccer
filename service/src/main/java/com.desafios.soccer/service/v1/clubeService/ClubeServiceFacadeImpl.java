package com.desafios.soccer.service.v1.clubeService;

import com.desafios.soccer.exceptions.notfound.NotFoundException;
import com.desafios.soccer.model.entity.Clube;
import com.desafios.soccer.repository.ClubeRepository;
import com.desafios.soccer.service.mapper.response.ClubeServiceResponseMapper;
import com.desafios.soccer.service.model.request.ClubeServiceRequest;
import com.desafios.soccer.service.model.response.ClubeServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import static com.desafios.soccer.service.mapper.request.ClubeServiceRequestMapper.toClubeEntity;
import static com.desafios.soccer.service.mapper.response.ClubeServiceResponseMapper.toClubeResponse;

@AllArgsConstructor
@Component
public class ClubeServiceFacadeImpl implements ClubeServiceFacade {

    private final ClubeRepository clubeRepository;

    public ClubeServiceResponse saveClube(ClubeServiceRequest clube) {
        Clube clubeSave = toClubeEntity(clube);
        Clube clubeResponse = clubeRepository.save(clubeSave);
        return toClubeResponse(clubeResponse);
    }

    public ClubeServiceResponse updateClubeById(ClubeServiceRequest clube, Long id) {
        Clube clubeNome = clubeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        clube.setId(clubeNome.getId());
        Clube clubeEntity = toClubeEntity(clube);
        Clube clubeSave = clubeRepository.save(clubeEntity);
        return toClubeResponse(clubeSave);
    }

    public void deleteClubeById(Long id) {
        clubeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        clubeRepository.deleteById(id);
    }

    public List<ClubeServiceResponse> findAllClubes() {
        return clubeRepository.findAll().stream()
                .map(ClubeServiceResponseMapper::toClubeResponse)
                .collect(Collectors.toList());
    }

    public ClubeServiceResponse findClubeById(Long id) {
        Clube clube = clubeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toClubeResponse(clube);
    }

}