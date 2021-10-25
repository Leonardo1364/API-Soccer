package com.desafios.soccer.service.clube;

import com.desafios.soccer.model.dto.clube.ClubeRequestDto;
import com.desafios.soccer.model.dto.clube.ClubeResponseDto;

import java.util.List;

public interface ClubeFacade {

    ClubeResponseDto saveClube(ClubeRequestDto clube);

    ClubeResponseDto updateClubeById(ClubeRequestDto clube, Long id);

    void deleteClubeById(Long id);

    ClubeResponseDto findClubeById(Long id);

    List<ClubeResponseDto> findAllClubes();

}
