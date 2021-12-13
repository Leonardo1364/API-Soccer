package com.desafios.soccer.contract.v1;

import com.desafios.soccer.contract.facade.player.PlayerControllerFacade;
import com.desafios.soccer.contract.model.request.PlayerControllerRequest;
import com.desafios.soccer.contract.model.response.PlayerControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("v1/player")
public class PlayerController {

    private final PlayerControllerFacade facade;

    @PostMapping()
    @ResponseStatus(CREATED)
    public PlayerControllerResponse savePlayer(@RequestBody @Valid PlayerControllerRequest player) {
        return facade.savePlayer(player);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public PlayerControllerResponse updatePlayerById(@RequestBody @Valid PlayerControllerRequest player,
                                                     @PathVariable String id) {
        return facade.updatePlayerById(player, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletePlayerById(@PathVariable String id) {
        facade.deletePlayerById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public PlayerControllerResponse findPlayerById(@PathVariable String id) {
        return facade.findPlayerById(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<PlayerControllerResponse> findAllPlayers() {
        return facade.findAllPlayer();
    }

}
