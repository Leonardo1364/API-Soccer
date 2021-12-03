package com.desafios.soccer.model.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document
public class Player {
    @Id
    private String id;

    private String name;

    private Integer age;

    private String currentTeam;

    private Integer historicalReputation;

    private Double financialAppetite;
    
    private Double price;

}
