package com.desafios.soccer.service.model.clube;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubeServiceResponse {
    private Long id;
    private String nome;
    private String reputacaoHistorica;
    private Double saldo;
}
