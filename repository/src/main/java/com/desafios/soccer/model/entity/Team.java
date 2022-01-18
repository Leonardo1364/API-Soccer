package com.desafios.soccer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document
public class Team {
    @Id
    private String id;

    private String name;

    private String historicalReputation;

    private Double balance;

    private LocalDate date;

    private League league;
}
