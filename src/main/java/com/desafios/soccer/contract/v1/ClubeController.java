package com.desafios.soccer.contract.v1;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/clube")
public class ClubeController {

    // TODO leonardo -> arrumar controller

//
//    private final ClubeFacade facade;
//
//    @PostMapping()
//    @ResponseStatus(CREATED)
//    public ClubeResponseDto saveClube(@RequestBody ClubeRequestDto clube) {
//        return facade.saveClube(clube);
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(OK)
//    public ClubeResponseDto updateClubeById(@RequestBody ClubeRequestDto clube, @PathVariable Long id) {
//        return facade.updateClubeById(clube, id);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(NO_CONTENT)
//    public void deleteClubeById(@PathVariable Long id) {
//        facade.deleteClubeById(id);
//    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(OK)
//    public ClubeResponseDto findClubeById(@PathVariable Long id) {
//        return facade.findClubeById(id);
//    }
//
//    @GetMapping
//    @ResponseStatus(OK)
//    public List<ClubeResponseDto> findAllClubes() {
//        return facade.findAllClubes();
//    }

}
