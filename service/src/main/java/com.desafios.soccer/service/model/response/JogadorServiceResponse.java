package com.desafios.soccer.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JogadorServiceResponse {
    private Long id;
    private String nome;
    private Integer idade;
    private String clubeAtual;
    private Integer reputacaoHistorica;
    private Double apetiteFinanceiro;
    private Double preco;
}
