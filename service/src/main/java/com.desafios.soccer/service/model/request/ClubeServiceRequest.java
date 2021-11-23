package com.desafios.soccer.service.model.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubeServiceRequest {
    private Long id;
    private String nome;
    private String reputacaoHistorica;
    private Double saldo;
}
