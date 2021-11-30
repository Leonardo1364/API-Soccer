package com.desafios.soccer.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JogadorControllerRequest {
    private Long id;

    @NotBlank
    @Size(min = 1, max = 255, message = "Min 1 and Max 255 characters.")
    private String nome;

    @DecimalMin(value = "12", message = "invalid age")
    private Integer idade;

    @NotBlank
    @Size(min = 1, max = 255, message = "Min 1 and Max 255 characters.")
    private String clubeAtual;

    @DecimalMin("1")
    private Integer reputacaoHistorica;

    @DecimalMin("1")
    private Double apetiteFinanceiro;

    @DecimalMin("1")
    private Double preco;
}
