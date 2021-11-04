package com.desafios.soccer.model.entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "clube")
public class Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "name")
    @NotNull
    private String nome;

    //@Column(name = "reputacao_historica")
    @NotNull
    private String reputacaoHistorica;

    @NotNull
    private Double saldo;

}
