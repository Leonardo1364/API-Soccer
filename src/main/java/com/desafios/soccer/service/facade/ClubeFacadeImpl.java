package com.desafios.soccer.service.facade;

import com.desafios.soccer.model.dto.clube.ClubeRequestDto;
import com.desafios.soccer.model.dto.clube.ClubeResponseDto;
import com.desafios.soccer.service.ClubeService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ClubeFacadeImpl implements ClubeFacade{

    private final ClubeService clubeService;

    public ClubeResponseDto saveClube(ClubeRequestDto clube) {
        return clubeService.saveClube(clube);
    }

    public ClubeResponseDto updateClubeById(ClubeRequestDto clube, Long id) {
        return clubeService.updateClubeById(clube, id);
    }

    public void deleteClubeById(Long id) {
        clubeService.deleteClubeById(id);
    }

    public ClubeResponseDto findClubeById(Long id) {
        return clubeService.findClubeById(id);
    }

    public List<ClubeResponseDto> findAllClubes() {
        return clubeService.findAllClubes();
    }
}
