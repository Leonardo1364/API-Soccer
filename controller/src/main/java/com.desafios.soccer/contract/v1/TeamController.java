package com.desafios.soccer.contract.v1;

import com.desafios.soccer.contract.facade.team.TeamControllerFacade;
import com.desafios.soccer.contract.model.request.TeamControllerRequest;
import com.desafios.soccer.contract.model.request.TeamPatchControllerRequest;
import com.desafios.soccer.contract.model.response.TeamControllerResponse;
import com.desafios.soccer.contract.model.response.TeamPatchControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public TeamPatchControllerResponse patchTeam(@RequestBody @Valid TeamPatchControllerRequest team,
                                                 @PathVariable String id) {
        return facade.patchTeam(team, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteTeamById(@PathVariable String id) {
        facade.deleteTeamById(id);
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

    @GetMapping("/read-cookie")
    public String readCookie(
            @CookieValue(name = "team_id", defaultValue = "default-team-id") String teamId) {

        return teamId;
    }

    @GetMapping("/all-cookies")
    public String readAllCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(cookie -> cookie.getName() + " = " + cookie.getValue())
                    .collect(Collectors.joining(", "));
        }
        return "No cookies";
    }

    @PostMapping("/change-cookies")
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("team-id", "Grêmio");

        cookie.setHttpOnly(true); //informa ao navegador que este cookie é acessado apenas pelo servidor
        cookie.setSecure(true); // transmissão somente por criptografia
        cookie.setPath("/");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setDomain("localhost:27017");

        response.addCookie(cookie);

        /* ResponseCookie cookie = ResponseCookie.from("team-id", "c2FtLnNtaXRoQGV4YW1wbGUuY29t")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(60)
                .domain("localhost:27017")
                .build();

        ResponseEntity
                .ok()
                .header(SET_COOKIE, cookie.toString())
                .build();*/

        return "Team name is changed!";
    }

    @PostMapping("/headers")
    @ResponseStatus(OK)
    public ResponseEntity<Map<String, String>> TeamHeader(@RequestHeader(value = "Accept") String acceptHeader,
                                                          @RequestHeader(value = "Authorization") String authorization) {

        Map<String, String> returnValue = new HashMap<>();
            returnValue.put("Accept", acceptHeader);
            returnValue.put("Authorization", authorization);

        return ResponseEntity.status(OK).body(returnValue);
    }

    /*@DeleteMapping("/{id}/players")
    @ResponseStatus(NO_CONTENT)
    public void deletePlayers(@PathVariable Long id,
                              @RequestParam List<String> idPlayers) {
        //DELETE - v1/team/1/player?idPlayers=1&idPlayers=7
        //DELETE v1/team/1/player
    }*/

}
