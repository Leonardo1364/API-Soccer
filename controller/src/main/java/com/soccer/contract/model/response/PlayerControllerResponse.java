package com.soccer.contract.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlayerControllerResponse {
    private String id;
    private String name;
    private Integer age;
    private String currentTeam;
    private Integer historicalReputation;
    private Double financialAppetite;
    private Double price;
}
