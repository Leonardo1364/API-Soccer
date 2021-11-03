package com.desafios.soccer.contract.v1;

import com.desafios.soccer.contract.facade.clube.ClubeControllerFacade;
import com.desafios.soccer.contract.model.clube.ClubeControllerRequest;
import com.desafios.soccer.contract.model.clube.ClubeControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/clube")
public class ClubeController {

    private final ClubeControllerFacade facade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClubeControllerResponse saveClube(@RequestBody ClubeControllerRequest clube) {
        return facade.saveClube(clube);
    }

    @PutMapping("/{id}")
    @ResponseStatus()
    public ClubeControllerResponse updateClubeById(@RequestBody ClubeControllerRequest clube, @PathVariable Long id) {
        return facade.updateClubeById(clube, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClubeById(@PathVariable Long id) {
        facade.deleteClubeById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClubeControllerResponse findClubeById(@PathVariable Long id) {
        return facade.findClubeById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClubeControllerResponse> findAllClubes() {
        return facade.findAllClubes();
    }
}
