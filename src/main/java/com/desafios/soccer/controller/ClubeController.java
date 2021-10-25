package com.desafios.soccer.controller;

import com.desafios.soccer.model.dto.clube.ClubeRequestDto;
import com.desafios.soccer.model.dto.clube.ClubeResponseDto;
import com.desafios.soccer.service.facade.ClubeFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/clube")
public class ClubeController {

    private final ClubeFacade clubeFacade;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClubeResponseDto saveClube(ClubeRequestDto clube){
        return clubeFacade.saveClube(clube);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClubeResponseDto updateClubeById(@RequestBody ClubeRequestDto clube, @PathVariable Long id) {
        return clubeFacade.updateClubeById(clube, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClubeById(@PathVariable Long id) {
        clubeFacade.deleteClubeById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClubeResponseDto findClubeById(@PathVariable Long id) {
        return clubeFacade.findClubeById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClubeResponseDto> findAllClubes() {
        return clubeFacade.findAllClubes();
    }
}
