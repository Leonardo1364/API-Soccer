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
@Table(name = "clube")
public class Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
    @Max(255)
    private String nome;

    @Min(1)
    @Max(255)
    @Column(name = "reputacao_historica")
    private String reputacaoHistorica;

    private Double saldo;

}
