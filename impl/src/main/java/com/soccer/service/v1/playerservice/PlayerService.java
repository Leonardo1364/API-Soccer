package com.soccer.service.v1.playerservice;

import com.soccer.exceptions.notfound.NotFoundException;
import com.soccer.model.entity.PlayerEntity;
import com.soccer.repository.PlayerRepository;
import com.soccer.service.mapper.response.PlayerServiceResponseMapper;
import com.soccer.service.model.request.PlayerServiceRequest;
import com.soccer.service.model.response.PlayerServiceResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.soccer.service.mapper.request.PlayerServiceRequestMapper.toEntity;
import static com.soccer.service.mapper.response.PlayerServiceResponseMapper.toResponse;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerServiceResponse save(PlayerServiceRequest player) {
        PlayerEntity playerResponse = playerRepository.save(toEntity(player));
        return toResponse(playerResponse);
    }

    public PlayerServiceResponse update(PlayerServiceRequest player) {
        PlayerEntity playerSave = playerRepository.save(toEntity(player));
        return toResponse(playerSave);
    }

    public void deletePlayerById(String id) {
        playerRepository.deleteById(id);
    }

    public PlayerServiceResponse findById(String id) {
        PlayerEntity player = playerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toResponse(player);
    }

    public List<PlayerServiceResponse> findAll() {
        return playerRepository.findAll().stream()
                .map(PlayerServiceResponseMapper::toResponse)
                .toList();
    }
}

