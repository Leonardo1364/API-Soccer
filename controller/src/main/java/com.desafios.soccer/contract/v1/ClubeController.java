package com.desafios.soccer.contract.v1;

import com.desafios.soccer.contract.facade.clube.ClubeControllerFacade;
import com.desafios.soccer.model.request.ClubeControllerRequest;
import com.desafios.soccer.model.response.ClubeControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/clube")
public class ClubeController {

    private final ClubeControllerFacade facade;

    @PostMapping
    @ResponseStatus(CREATED)
    public ClubeControllerResponse saveClube(@RequestBody @Valid ClubeControllerRequest clube) {
        return facade.saveClube(clube);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public ClubeControllerResponse updateClubeById(@RequestBody @Valid ClubeControllerRequest clube, @PathVariable Long id) {
        return facade.updateClubeById(clube, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteClubeById(@PathVariable Long id) {
        facade.deleteClubeById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ClubeControllerResponse findClubeById(@PathVariable Long id) {
        return facade.findClubeById(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ClubeControllerResponse> findAllClubes() {
        return facade.findAllClubes();
    }

}
