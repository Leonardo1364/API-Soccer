package com.desafios.soccer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Clube {

    private String name;
    private String reputacaoHistorica;
    private Double saldo;
}
