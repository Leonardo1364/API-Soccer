package com.desafios.soccer.contract.model.jogador;

import javax.persistence.Id;

public class JogadorControllerRequest {
    private Long id;
    private String nome;
    private Integer idade;
    private String clubeAtual;
    private Integer reputacaoHistorica;
    private Double apetiteFinanceiro;
    private Double preco;
}
