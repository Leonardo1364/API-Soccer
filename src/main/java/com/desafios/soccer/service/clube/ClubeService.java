package com.desafios.soccer.service.clube;

import com.desafios.soccer.exceptions.notfound.NotFoundException;
import com.desafios.soccer.repository.model.entity.Clube;
import com.desafios.soccer.repository.repository.ClubeRepository;
import com.desafios.soccer.service.mapper.clube.ClubeServiceMapper;
import com.desafios.soccer.service.model.clube.ClubeServiceRequest;
import com.desafios.soccer.service.model.clube.ClubeServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClubeService {

    private final ClubeRepository repository;

    public ClubeServiceResponse saveClube(ClubeServiceRequest clube) {
        Clube clubeEntity = ClubeServiceMapper.INSTANCE.toClubeEntity(clube);
        Clube clubeSave = repository.save(clubeEntity);
        return ClubeServiceMapper.INSTANCE.toResponseService(clubeSave);
    }

    public ClubeServiceResponse updateClubeById(ClubeServiceRequest clube, Long id) {
        Clube clubeNome = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        clube.setId(clubeNome.getId());
        Clube clubeEntity = ClubeServiceMapper.INSTANCE.toClubeEntity(clube);
        Clube clubeSave = repository.save(clubeEntity);
        return ClubeServiceMapper.INSTANCE.toResponseService(clubeSave);
    }

    public void deleteClubeById(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        repository.deleteById(id);
    }

    public List<ClubeServiceResponse> findAllClubes() {
        return repository.findAll().stream()
                .map(ClubeServiceMapper.INSTANCE::toResponseService)
                .collect(Collectors.toList());
    }

    public ClubeServiceResponse findClubeById(Long id) {
        Clube clube = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return ClubeServiceMapper.INSTANCE.toResponseService(clube);
    }

}