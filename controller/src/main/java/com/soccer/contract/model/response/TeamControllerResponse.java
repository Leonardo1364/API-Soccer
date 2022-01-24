package com.soccer.contract.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamControllerResponse {
    private String id;
    private String name;
    private String historicalReputation;
    private Double balance;
    private LocalDate date;
    private LeagueControllerResponse league;
}
