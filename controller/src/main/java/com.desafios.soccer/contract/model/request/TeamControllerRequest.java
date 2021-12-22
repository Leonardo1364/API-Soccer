package com.desafios.soccer.contract.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamControllerRequest {
    private String id;

    //@Pattern(regexp = "&#32")
    @NotBlank
    @Size(min = 3, max = 255, message = "Min 1 and Max 255 characters.")
    private String name;

    @NotBlank
    @Size(min = 3, max = 255, message = "Min 1 and Max 255 characters.")
    private String historicalReputation;

    @DecimalMin("1")
    private Double balance;

    private LocalDate date;
}
