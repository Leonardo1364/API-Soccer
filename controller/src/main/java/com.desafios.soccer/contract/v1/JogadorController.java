package com.desafios.soccer.contract.v1;

import com.desafios.soccer.contract.facade.jogador.JogadorControllerFacade;
import com.desafios.soccer.model.jogador.JogadorControllerRequest;
import com.desafios.soccer.model.jogador.JogadorControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

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

}
