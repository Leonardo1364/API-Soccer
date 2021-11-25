package com.desafios.soccer.contract.v1;

import com.desafios.soccer.contract.facade.jogador.JogadorControllerFacade;
import com.desafios.soccer.model.request.JogadorControllerRequest;
import com.desafios.soccer.model.response.JogadorControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("v1/jogador")
public class JogadorController {

    private final JogadorControllerFacade facade;

    @PostMapping()
    @ResponseStatus(CREATED)
    public JogadorControllerResponse saveJogador(@RequestBody @Valid JogadorControllerRequest jogador) {
        return facade.saveJogador(jogador);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public JogadorControllerResponse updateJogadorById(@RequestBody @Valid JogadorControllerRequest jogador, @PathVariable Long id) {
        return facade.updateJogadorById(jogador, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteJogadorById(@PathVariable Long id) {
        facade.deleteJogadorById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public JogadorControllerResponse findJogadorById(@PathVariable Long id) {
        return facade.findJogadorById(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<JogadorControllerResponse> findAllJogadores() {
        return facade.findAllJogadores();
    }

}
