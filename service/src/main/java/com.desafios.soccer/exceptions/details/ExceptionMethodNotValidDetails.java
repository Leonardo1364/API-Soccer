package com.desafios.soccer.exceptions.details;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Map;

@SuperBuilder
@Data
public class ExceptionMethodNotValidDetails {

    private Integer status;
    private String title;
    private Instant timestamp;
    private Map<String, String> details;
    private String developerMessage;

}
