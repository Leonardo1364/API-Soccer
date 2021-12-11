package com.desafios.soccer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
