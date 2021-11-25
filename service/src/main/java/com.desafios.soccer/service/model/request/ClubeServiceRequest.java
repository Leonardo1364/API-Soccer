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

    public void setNome(String nome) {
        this.nome = nome.strip();
    }

    public void setReputacaoHistorica(String reputacaoHistorica) {
        this.reputacaoHistorica = reputacaoHistorica.strip();
    }
}
