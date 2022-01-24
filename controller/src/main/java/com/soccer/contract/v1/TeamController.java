package com.soccer.contract.v1;

import com.soccer.contract.facade.team.TeamControllerFacade;
import com.soccer.contract.model.request.TeamControllerRequest;
import com.soccer.contract.model.request.TeamPatchControllerRequest;
import com.soccer.contract.model.response.TeamControllerResponse;
import com.soccer.contract.model.response.TeamPatchControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    public TeamControllerResponse save(@RequestBody @Valid TeamControllerRequest team) {
        return facade.save(team);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public TeamControllerResponse update(@RequestBody @Valid TeamControllerRequest team,
                                         @PathVariable String id) {
        return facade.update(team, id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    public TeamPatchControllerResponse patch(@RequestBody @Valid TeamPatchControllerRequest team,
                                             @PathVariable String id) {
        return facade.patch(team, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable String id) {
        facade.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public TeamControllerResponse findById(@PathVariable String id) {
        return facade.findById(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<TeamControllerResponse> findAll() {
        return facade.findAll();
    }

    @GetMapping("/read-cookie")
    public String readCookie(
            @CookieValue(name = "team_id", defaultValue = "default-team-id") String teamId) {

        return teamId;
    }

    @GetMapping("/all-cookies")
    public String readAllCookies(@NotNull HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(cookie -> cookie.getName() + " = " + cookie.getValue())
                    .collect(Collectors.joining(", "));
        }
        return "No cookies";
    }

    @PostMapping("/change-cookies")
    public String setCookie(@NotNull HttpServletResponse response) {
        Cookie cookie = new Cookie("team-id", "Time");

        cookie.setHttpOnly(true); // informa ao navegador que este cookie é acessado apenas pelo servidor
        cookie.setSecure(true); // transmissão somente por criptografia
        cookie.setPath("/"); // tornar um cookie acessível em qualquer lugar para o domínio atual.
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setDomain("localhost");

        response.addCookie(cookie);

        return "Team name is changed!";
    }

    @PostMapping("/headers")
    @ResponseStatus(OK)
    public ResponseEntity<Map<String, String>> setHeader(@RequestHeader(value = "Accept") String acceptHeader,
                                                          @RequestHeader(value = "Authorization") String authorization) {

        Map<String, String> returnValue = new HashMap<>();
            returnValue.put("Accept", acceptHeader);
            returnValue.put("Authorization", authorization);

        return ResponseEntity.status(OK).body(returnValue);
    }

}
