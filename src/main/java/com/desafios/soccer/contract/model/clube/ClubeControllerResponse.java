package com.desafios.soccer.contract.model.clube;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClubeControllerResponse {
    private Long id;
    private String nome;
    private String ReputacaoHistorica;
    private Double saldo;
}
