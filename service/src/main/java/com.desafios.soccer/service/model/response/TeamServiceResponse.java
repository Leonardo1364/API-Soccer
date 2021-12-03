package com.desafios.soccer.service.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeamServiceResponse {
    private String id;
    private String name;
    private String historicalReputation;
    private Double balance;
}
