package com.desafios.soccer.contract.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeamPatchControllerRequest {

    private String id;

    @NotBlank
    @Size(min = 3, max = 255, message = "Min 1 and Max 255 characters.")
    private String name;
}
