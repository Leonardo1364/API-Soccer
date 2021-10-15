package com.desafios.soccer.service;

import com.desafios.soccer.mappers.ClubeMapper;
import com.desafios.soccer.model.Clube;
import com.desafios.soccer.model.dto.clube.ClubeRequestDto;
import com.desafios.soccer.model.dto.clube.ClubeResponseDto;
import com.desafios.soccer.repository.ClubeRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClubeService {

    private final ClubeRepository clubeRepository;

    public ClubeResponseDto saveTeam(ClubeRequestDto clube) {
        Clube clubeEntity = ClubeMapper.INSTANCE.toClubeEntity(clube);
        Clube clubeSave = clubeRepository.save(clubeEntity);
        return ClubeMapper.INSTANCE.toClubeDto(clubeSave);
    }

    public ClubeResponseDto updateTeamById(ClubeRequestDto clube, String id) {
        Clube clubeNome = clubeRepository.findById(id)
                .orElseThrow(() -> new com.desafios.soccer.exceptions.notfound.NotFoundException("ID not found"));
        clube.setNome(clubeNome.getName());
        Clube clubeEntity = ClubeMapper.INSTANCE.toClubeEntity(clube);
        Clube clubeSave = clubeRepository.save(clubeEntity);
        return ClubeMapper.INSTANCE.toClubeDto(clubeSave);
    }

    public void deleteTeamById(String id) {
        clubeRepository.findById(id)
                .orElseThrow(() -> new com.desafios.soccer.exceptions.notfound.NotFoundException("ID not found"));
        clubeRepository.deleteById(id);
    }

    public List<ClubeResponseDto> findAllClubes() {
        return clubeRepository.findAll().stream()
                .map(ClubeMapper.INSTANCE::toClubeDto)
                .collect(Collectors.toList());
    }

    public ClubeResponseDto findTeamById(String id) {
        Clube clube = clubeRepository.findById(id)
                .orElseThrow(() -> new com.desafios.soccer.exceptions.notfound.NotFoundException("ID not found"));
        return ClubeMapper.INSTANCE.toClubeDto(clube);
    }
}