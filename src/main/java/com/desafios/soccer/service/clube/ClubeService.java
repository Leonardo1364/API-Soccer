package com.desafios.soccer.service.clube;

import com.desafios.soccer.exceptions.notfound.NotFoundException;
import com.desafios.soccer.mappers.ClubeMapper;
import com.desafios.soccer.model.dto.clube.ClubeRequestDto;
import com.desafios.soccer.model.dto.clube.ClubeResponseDto;
import com.desafios.soccer.repository.repository.ClubeRepository;
import com.desafios.soccer.repository.model.entity.Clube;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClubeService {

    private final ClubeRepository repository;

    public ClubeResponseDto saveClube(ClubeRequestDto clube) {
        Clube clubeEntity = ClubeMapper.INSTANCE.toClubeEntity(clube);
        Clube clubeSave = repository.save(clubeEntity);
        return ClubeMapper.INSTANCE.toClubeResponse(clubeSave);
    }

    public ClubeResponseDto updateClubeById(ClubeRequestDto clube, Long id) {
        Clube clubeNome = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        clube.setId(clubeNome.getId());
        Clube clubeEntity = ClubeMapper.INSTANCE.toClubeEntity(clube);
        Clube clubeSave = repository.save(clubeEntity);
        return ClubeMapper.INSTANCE.toClubeResponse(clubeSave);
    }

    public void deleteClubeById(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        repository.deleteById(id);
    }

    public List<ClubeResponseDto> findAllClubes() {
        return repository.findAll().stream()
                .map(ClubeMapper.INSTANCE::toClubeResponse)
                .collect(Collectors.toList());
    }

    public ClubeResponseDto findClubeById(Long id) {
        Clube clube = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return ClubeMapper.INSTANCE.toClubeResponse(clube);
    }

}