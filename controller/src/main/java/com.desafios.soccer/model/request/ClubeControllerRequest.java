package com.desafios.soccer.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClubeControllerRequest {
    private Long id;

    @NotBlank
    @Size(min = 3, max = 255, message = "Min 1 and Max 255 characters.")
    private String nome;

    @NotBlank
    @Size(min = 3, max = 255, message = "Min 1 and Max 255 characters.")
    private String reputacaoHistorica;

    @NotBlank
    private Double saldo;
}
