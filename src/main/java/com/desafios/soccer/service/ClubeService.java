package com.desafios.soccer.service;

import com.desafios.soccer.repository.ClubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClubeService {

    private final ClubeRepository clubeRepository;
}
