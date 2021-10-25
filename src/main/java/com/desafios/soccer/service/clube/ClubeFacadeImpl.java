package com.desafios.soccer.service.clube;

import com.desafios.soccer.model.dto.clube.ClubeRequestDto;
import com.desafios.soccer.model.dto.clube.ClubeResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ClubeFacadeImpl implements ClubeFacade {

    private final ClubeService service;

    public ClubeResponseDto saveClube(ClubeRequestDto clube) {
        return service.saveClube(clube);
    }

    public ClubeResponseDto updateClubeById(ClubeRequestDto clube, Long id) {
        return service.updateClubeById(clube, id);
    }

    public void deleteClubeById(Long id) {
        service.deleteClubeById(id);
    }

    public ClubeResponseDto findClubeById(Long id) {
        return service.findClubeById(id);
    }

    public List<ClubeResponseDto> findAllClubes() {
        return service.findAllClubes();
    }

}
