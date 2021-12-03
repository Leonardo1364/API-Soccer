package com.desafios.soccer.model.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

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
}
