package com.desafios.soccer.contract.model.clube;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClubeControllerRequest {
    private Long id;
    private String nome;
    private String reputacaoHistorica;
    private Double saldo;
}
