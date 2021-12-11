package com.desafios.soccer.contract.v1;

import com.desafios.soccer.contract.facade.clube.TeamControllerFacade;
import com.desafios.soccer.contract.model.request.TeamControllerRequest;
import com.desafios.soccer.contract.model.response.TeamControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/team")
public class TeamController {

    private final TeamControllerFacade facade;

    @PostMapping
    @ResponseStatus(CREATED)
    public TeamControllerResponse saveTeam(@RequestBody @Valid TeamControllerRequest team) {
        return facade.saveTeam(team);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public TeamControllerResponse updateTeamById(@RequestBody @Valid TeamControllerRequest team,
                                                 @PathVariable String id) {
        return facade.updateTeamById(team, id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    public TeamControllerResponse patchTeam(@RequestBody @Valid TeamControllerRequest team, @PathVariable String id) {
        team.setName(findTeamById(id).getName());
        return facade.patchTeam(team, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteTeamById(@PathVariable String id) {
        facade.deleteTeamById(id);
    }

    //DELETE - v1/clube/1/jogadores?idJogadores=1&idJogadores=7
    //DELETE v1/clube/1/jogadores
    @DeleteMapping("/{id}/players")
    @ResponseStatus(NO_CONTENT)
    public void deletePlayers(@PathVariable Long id, @RequestParam List<String> idPlayers) {
        System.out.println("Teste" + idPlayers);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public TeamControllerResponse findTeamById(@PathVariable String id) {
        return facade.findTeamById(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<TeamControllerResponse> findAllTeams() {
        return facade.findAllTeams();
    }

}
