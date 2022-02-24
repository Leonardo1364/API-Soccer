package com.soccer.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LeagueServiceResponse league;
}
