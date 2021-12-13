package com.desafios.soccer.contract.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeamPatchControllerResponse {

    private String id;
    private String name;
}
