package com.desafios.soccer.service.model.response;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeamServiceResponse {
    private String id;
    private String name;
    private String historicalReputation;
    private Double balance;
    private LocalDate date;
}
