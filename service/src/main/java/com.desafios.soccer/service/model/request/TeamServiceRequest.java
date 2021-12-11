package com.desafios.soccer.service.model.request;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeamServiceRequest {
    private String id;
    private String name;
    private String historicalReputation;
    private Double balance;
    private LocalDate date;

}
