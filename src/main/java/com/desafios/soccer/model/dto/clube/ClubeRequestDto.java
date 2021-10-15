package com.desafios.soccer.model.dto.clube;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubeRequestDto {

    private String id;
    private String nome;
}
