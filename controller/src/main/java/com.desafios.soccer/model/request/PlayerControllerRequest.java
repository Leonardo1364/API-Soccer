package com.desafios.soccer.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlayerControllerRequest {
    private String id;

    @NotBlank
    @Size(min = 1, max = 255, message = "Min 1 and Max 255 characters.")
    private String name;

    @DecimalMin(value = "12", message = "invalid age")
    private Integer age;

    @NotBlank
    @Size(min = 1, max = 255, message = "Min 1 and Max 255 characters.")
    private String currentTeam;

    @DecimalMin("1")
    private Integer historicalReputation;

    @DecimalMin("1")
    private Double financialAppetite;

    @DecimalMin("1")
    private Double price;
}
