package com.desafios.soccer.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "jogador")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
    @Max(255)
    private String nome;

    private Integer idade;

    @Column(name = "clube_atual")
    @Min(1)
    @Max(255)
    private String clubeAtual;

    @Column(name = "reputacao_historica")
    private Integer reputacaoHistorica;

    @Column(name = "apetite_financeiro")
    private Double apetiteFinanceiro;

    private Double preco;

}
