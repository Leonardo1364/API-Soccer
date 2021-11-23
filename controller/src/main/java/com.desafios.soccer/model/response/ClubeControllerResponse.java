package com.desafios.soccer.model.response;

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
    private String reputacaoHistorica;
    private Double saldo;
}
