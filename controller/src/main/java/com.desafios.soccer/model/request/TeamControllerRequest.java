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
@Builder
@Data
public class TeamControllerRequest {
    private String id;

    // U+0020 unicode
    //@Pattern(regexp = "\0020")
    @NotBlank
    @Size(min = 3, max = 255, message = "Min 1 and Max 255 characters.")
    private String name;

    @NotBlank
    @Size(min = 3, max = 255, message = "Min 1 and Max 255 characters.")
    private String historicalReputation;

    @DecimalMin("1")
    private Double balance;

}
